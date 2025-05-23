package com.example.calculatorapp.validator;

import com.example.calculatorapp.exception.AuthException;
import com.example.calculatorapp.exception.NumException;

public interface FieldNumValidator<T> {
    public void validate(T request) throws NumException;
}
