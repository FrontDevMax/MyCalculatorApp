package com.example.calculatorapp.controller;

import com.example.calculatorapp.exception.NumException;
import com.example.calculatorapp.model.CalculatorModel;
import com.example.calculatorapp.validator.FieldNumValidator;
import com.example.calculatorapp.validator.NumValidator;

public class CalculatorController {
    private FieldNumValidator<CalculatorModel> numValidator;

    public CalculatorController() {
        this.numValidator = new NumValidator();
    }

    public void validateInput(CalculatorModel calculatorModel) throws NumException {
        numValidator.validate(calculatorModel);
    }
}
