package com.example.calculatorapp.validator;

import android.util.Patterns;

import com.example.calculatorapp.enumeration.AuthError;
import com.example.calculatorapp.enumeration.NumError;
import com.example.calculatorapp.exception.AuthException;
import com.example.calculatorapp.exception.NumException;
import com.example.calculatorapp.model.CalculatorModel;

public final class NumValidator implements FieldNumValidator<CalculatorModel> {
    private FieldNumValidator<CalculatorModel> startNumValidator, endNumValidator;

    public NumValidator() {
        this.startNumValidator = new StartNumValidator();
        this.endNumValidator = new EndNumValidator();
    }

    @Override
    public void validate(CalculatorModel calculatorModel) throws NumException {
        startNumValidator.validate(calculatorModel);
        endNumValidator.validate(calculatorModel);
    }
}
