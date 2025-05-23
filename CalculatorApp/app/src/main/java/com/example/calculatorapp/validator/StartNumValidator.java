package com.example.calculatorapp.validator;

import com.example.calculatorapp.enumeration.NumError;
import com.example.calculatorapp.exception.NumException;
import com.example.calculatorapp.model.CalculatorModel;

public class StartNumValidator implements FieldNumValidator<CalculatorModel> {
    @Override
    public void validate(CalculatorModel calculatorModel) throws NumException {
        if(calculatorModel.getStartNum().equals("")) {
            throw new NumException(NumError.INVALID_START_NUM, "Начало диапазона не может быть пустым");
        } else if(calculatorModel.getStartNum().length() > 20) {
            throw new NumException(NumError.INVALID_START_NUM, "Начало диапазона слишком большое");
        }
    }
}
