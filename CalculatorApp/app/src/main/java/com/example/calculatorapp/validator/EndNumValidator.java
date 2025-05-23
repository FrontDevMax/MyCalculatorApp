package com.example.calculatorapp.validator;

import com.example.calculatorapp.enumeration.NumError;
import com.example.calculatorapp.exception.NumException;
import com.example.calculatorapp.model.CalculatorModel;

public class EndNumValidator implements FieldNumValidator<CalculatorModel> {
    @Override
    public void validate(CalculatorModel calculatorModel) throws NumException {
        if(calculatorModel.getEndNum().equals("")) {
            throw new NumException(NumError.INVALID_END_NUM, "Конец диапазона не может быть пустым");
        } else if(calculatorModel.getEndNum().length() > 20) {
            throw new NumException(NumError.INVALID_END_NUM, "Конец диапазона слишком большое");
        }
    }
}
