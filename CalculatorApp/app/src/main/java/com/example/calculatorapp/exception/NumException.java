package com.example.calculatorapp.exception;

import com.example.calculatorapp.enumeration.NumError;

public class NumException extends Exception {
    private NumError numError;
    public NumException(NumError numError, String message) {
        super(message);
        this.numError = numError;
    }

    public NumError getNumError() {
        return numError;
    }
}
