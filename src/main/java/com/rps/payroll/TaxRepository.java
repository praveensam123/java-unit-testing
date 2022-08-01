package com.rps.payroll;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class TaxRepository {

    private EntityManager entityManager;

    public double getIncentiveTaxRate(String grade) {
        double rate;
        String query = "SELECT rate FROM IncentiveTaxRates rates WHERE rates.grade = :grade";
        TypedQuery<Payroll> q = entityManager.createQuery(query, Payroll.class);
        q.setParameter("grade", grade);
        try {
            rate = q.getSingleResult().getRate();
        } catch (NoResultException exception) {
            throw new RateNotAvailableException("Grade: " + grade);
        }
        return rate;
    }
}
