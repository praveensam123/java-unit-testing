package com.rps.payroll;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class PayrollRepository {

    private EntityManager entityManager;

    public double getIncentiveRate(String grade) throws RateNotAvailableException {
        double rate;
        String query = "SELECT rate FROM PayrollRates rates WHERE rates.grade = :grade";
        TypedQuery<Payroll> q = entityManager.createQuery(query, Payroll.class);
        q.setParameter("grade", grade);
        try {
            rate = q.getSingleResult().getRate();
        } catch (NoResultException exception) {
            throw new RateNotAvailableException("Grade: " + grade);
        }
        return rate;
    }

    public void updateIncentiveRate(String grade, double rate) {
        String query = "UPDATE :rate FROM PayrollRates rates WHERE rates.grade = :grade";
        TypedQuery<Payroll> typedQuery = entityManager.createQuery(query, Payroll.class);
        typedQuery.setParameter("grade", grade);
        typedQuery.setParameter("rate", rate);
        typedQuery.executeUpdate();
    }
}
