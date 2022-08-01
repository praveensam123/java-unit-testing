package com.rps.payroll;

public class PayrollService {

    PayrollRepository payrollRepository;
    TaxService taxService;

    public PayrollService() {
        this.payrollRepository = new PayrollRepository();
        this.taxService = new TaxService();
    }

    public double calculateIncentive(double salary, double rate) {
        return salary * rate;
    }

    public double calculateIncentiveTax(double incentive, double rate) {
        return incentive * rate;
    }

    public void updateIncentiveRate(String grade, double rate) {
        payrollRepository.updateIncentiveRate(grade, rate);
    }

    public double calculateIncentive(double salary, String grade) {
        double incentiveRate = payrollRepository.getIncentiveRate(grade);
        return salary * incentiveRate;
    }

    public double calculateIncentiveTax(double salary, String grade) {
        double incentiveRate = payrollRepository.getIncentiveRate(grade);
        double incentive = salary * incentiveRate;
        return incentive * getIncentiveTaxRate(grade);
    }

    double getIncentiveTaxRate(String grade) {
        return taxService.getIncentiveTaxRate(grade);
    }

}
