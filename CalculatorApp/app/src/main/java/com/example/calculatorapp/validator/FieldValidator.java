package com.example.calculatorapp.validator;

public interface FieldValidator {
    public boolean isValid(String input);
    public String getErrorMessage();
}
