package com.rps.payroll;

public class TaxService {

    private final TaxRepository taxRepository;

    public TaxService() {
        this.taxRepository = new TaxRepository();
    }

    double getIncentiveTaxRate(String grade) {
        return taxRepository.getIncentiveTaxRate(grade);
    }
}
