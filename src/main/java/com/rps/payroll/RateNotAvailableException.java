package com.rps.payroll;

public class RateNotAvailableException extends RuntimeException {

    public RateNotAvailableException(String message) {
        super(message);
    }

}
