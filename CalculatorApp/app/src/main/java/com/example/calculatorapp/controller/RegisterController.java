package com.example.calculatorapp.controller;

import com.example.calculatorapp.exception.AuthException;
import com.example.calculatorapp.model.RegisterRequest;
import com.example.calculatorapp.validator.FieldAuthValidator;
import com.example.calculatorapp.validator.RegisterValidator;

public class RegisterController {
    private FieldAuthValidator<RegisterRequest> registerValidator;

    public RegisterController() {
        this.registerValidator = new RegisterValidator();
    }

    public void register(RegisterRequest registerRequest) throws AuthException {
        registerValidator.validate(registerRequest);
    }
}
