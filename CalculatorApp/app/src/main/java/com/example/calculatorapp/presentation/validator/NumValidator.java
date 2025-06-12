package com.example.calculatorapp.presentation.validator;

import com.example.calculatorapp.domain.model.CalculatorModel;

public class NumValidator implements Validator<CalculatorModel> {
    @Override
    public ValidationResult validate(CalculatorModel calculatorModel) {
        String startNum = calculatorModel.getStartNum();
        String endNum = calculatorModel.getEndNum();
        if(startNum.equals("")) {
            return ValidationResult.invalid("Введите начальное число");
        } else if(startNum.length() > 5) {
            return ValidationResult.invalid("Максимальное начальное число: 99999");
        } else if(endNum.equals("")) {
            return ValidationResult.invalid("Введите конечное число");
        } else if(endNum.length() > 5) {
            return ValidationResult.invalid("Максимальное конечное число: 99999");
        } else if(Integer.parseInt(startNum) > Integer.parseInt(endNum) ) {
            return ValidationResult.invalid("Начальное число больше конечного");
        }
        return ValidationResult.valid();
    }
}
