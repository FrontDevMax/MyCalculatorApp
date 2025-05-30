package com.example.calculatorapp.presentation.validator;

import com.example.calculatorapp.domain.enumeration.NumError;
import com.example.calculatorapp.domain.exception.NumException;
import com.example.calculatorapp.domain.model.CalculatorModel;

public class StartNumValidator implements Validator<CalculatorModel> {
    @Override
    public ValidationResult validate(CalculatorModel calculatorModel) {
        String startNum = calculatorModel.getStartNum();
        String endNum = calculatorModel.getEndNum();
        if(startNum.equals("")) {
            return ValidationResult.invalid("Начало диапазона пустое");
        } else if(startNum.length() > 20) {
            return ValidationResult.invalid("Начало диапазона слишком большое");
        } else if(startNum.length() > endNum.length()) {
            return ValidationResult.invalid("Начало диапазона больше конца");
        }
        return ValidationResult.valid();
    }
}
