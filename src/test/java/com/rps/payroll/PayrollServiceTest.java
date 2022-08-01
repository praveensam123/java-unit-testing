package com.rps.payroll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PayrollServiceTest {

    private @InjectMocks PayrollService payrollService;
    private @Mock PayrollRepository payrollRepository;
    private @Mock TaxService taxService;

    @Test
    public void given_salary_and_rate_calculateIncentive_returns_incentive() {
        // Given
        double salary = 100000.0;
        double rate = 0.1;

        // When
        double incentive = payrollService.calculateIncentive(salary, rate);

        // When
        assertThat(incentive, equalTo(10000.0));
    }

    @Test
    public void given_incentive_and_rate_calculateIncentiveTax_returns_incentiveTax() {
        // Given
        double incentive = 10000.0;
        double rate = 0.3;

        // When
        double incentiveTax = payrollService.calculateIncentiveTax(incentive, rate);

        // Then
        assertThat(incentiveTax, equalTo(3000.0));
    }

    @Test
    public void when_updateIncentiveRate_is_called_it_should_call_payrollRepository_updateIncentiveRate() {
        double rate = 0.4;
        String grade = "SG6";
        payrollService.updateIncentiveRate(grade, rate);
        Mockito.verify(payrollRepository).updateIncentiveRate(grade, rate);
    }

    @Test
    public void when_rate_is_available_for_the_grade_then_calculateIncentive_returns_incentive() {
        double salary = 100000.0;
        String grade = "SG7";
        doReturn(0.1).when(payrollRepository).getIncentiveRate(grade);
        double incentive = payrollService.calculateIncentive(salary, grade);
        assertThat(incentive, equalTo(10000.0));
    }

    @Test
    public void when_rate_is_not_available_for_the_grade_then_calculateIncentive_throws_exception() {
        double salary = 100000.0;
        String grade = "LL6";
        doThrow(RateNotAvailableException.class).when(payrollRepository).getIncentiveRate(grade);
        assertThrows(RateNotAvailableException.class, () -> payrollService.calculateIncentive(salary, grade));
    }

    @Test
    public void given_salary_and_grade_calculateIncentiveTax_returns_incentiveTax() {
        double salary = 100000.0;
        String grade = "SG7";
        when(payrollRepository.getIncentiveRate(grade)).thenReturn(0.1);
        when(payrollService.getIncentiveTaxRate(grade)).thenReturn(0.2);
        double incentiveTax = payrollService.calculateIncentiveTax(salary, grade);
        assertThat(incentiveTax, equalTo(2000.0));
    }

}
