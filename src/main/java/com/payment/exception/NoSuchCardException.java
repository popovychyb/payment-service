package com.payment.exception;

public class NoSuchCardException extends Exception {
    public NoSuchCardException(String message) {
        super(message);
    }
}
