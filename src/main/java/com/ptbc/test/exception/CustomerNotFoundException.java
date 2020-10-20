package com.ptbc.test.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(Long id) {
        super("Unable to find customer with id " + id);
    }
}