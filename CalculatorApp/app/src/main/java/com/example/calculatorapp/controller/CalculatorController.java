package com.example.calculatorapp.controller;

import com.example.calculatorapp.exception.NumException;
import com.example.calculatorapp.model.CalculatorModel;
import com.example.calculatorapp.validator.NumValidator;

public class CalculatorController {
    public void validateInput(CalculatorModel calculatorModel) throws NumException {
        NumValidator.validateStartNum(calculatorModel.getStartNum());
        NumValidator.validateEndNum(calculatorModel.getEndNum());
        NumValidator.validateStartNum(
                calculatorModel.getStartNum(), calculatorModel.getEndNum()
        );
    }
}
