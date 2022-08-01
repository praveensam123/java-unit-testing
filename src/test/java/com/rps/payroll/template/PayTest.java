package com.rps.payroll.template;

import com.rps.payroll.PayrollService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(MockitoExtension.class)
public class PayTest {

    private @InjectMocks PayrollService payrollService;

    /***
     * Simple Test - 1
     */
    public void given_salary_and_rate_calculateIncentive_returns_incentive() {
        // Given
        double salary = 100000.0;
        double rate = 0.1;

        // When
        double incentive = payrollService.calculateIncentive(salary, rate);

        // Then
        assertThat(incentive, equalTo(10000.0));
    }

    /***
     * Simple Test - 2
     */
    public void given_incentive_and_rate_calculateIncentiveTax_returns_incentiveTax() {
        // Given
        double incentive = 10000.0;
        double rate = 0.3;

        // When
        double incentiveTax = payrollService.calculateIncentiveTax(incentive, rate);

        // Then
        assertThat(incentiveTax, equalTo(3000.0));
    }

    /***
     * Verify
     */
    public void when_updateIncentiveRate_is_called_it_should_call_payrollRepository_updateIncentiveRate(){
        // Given
        double rate = 0.15;
        String grade = "SG7";

        // When
        payrollService.updateIncentiveRate(grade, rate);

        // Then
        // TODO
    }

    /***
     * when - then || do - when
     */
    public void when_rate_is_available_for_the_grade_then_calculateIncentive_returns_incentive(){
        // Given
        double salary = 100000.0;
        String grade = "SG7";
        // TODO

        // When
        double incentive = payrollService.calculateIncentive(salary, grade);

        // Then
        assertThat(incentive, equalTo(10000.0));
    }

    /**
     * Exception | doThrow - when
     */
    public void when_rate_is_not_available_for_the_grade_then_calculateIncentive_throws_exception(){
        double salary = 100000.0;
        String grade = "LL6";
        // TODO
        payrollService.calculateIncentive(salary, grade);
    }

    public void given_salary_and_grade_calculateIncentiveTax_returns_incentiveTax() {
        double salary = 100000.0;
        String grade = "SG7";

        // TODO

        double incentiveTax = payrollService.calculateIncentiveTax(salary, grade);
        assertThat(incentiveTax, equalTo(2000.0));
    }

}
