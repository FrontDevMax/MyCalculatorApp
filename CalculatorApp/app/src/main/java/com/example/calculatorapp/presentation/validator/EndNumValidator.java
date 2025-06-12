package com.example.calculatorapp.presentation.validator;

import com.example.calculatorapp.domain.enumeration.NumError;
import com.example.calculatorapp.domain.exception.NumException;
import com.example.calculatorapp.domain.model.CalculatorModel;

public class EndNumValidator implements Validator<CalculatorModel> {
    @Override
    public ValidationResult validate(CalculatorModel calculatorModel) {
        String endNum = calculatorModel.getEndNum();
        if(endNum.equals("")) {
            return ValidationResult.invalid("Конец диапазона пустой");
        } else if(endNum.length() > 20) {
            return ValidationResult.invalid("Конец диапазона слишком большой");
        }
        return ValidationResult.valid();
    }
}
