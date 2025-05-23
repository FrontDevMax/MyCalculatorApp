package com.example.calculatorapp.controller;

import com.example.calculatorapp.exception.AuthException;
import com.example.calculatorapp.model.LoginRequest;
import com.example.calculatorapp.validator.FieldAuthValidator;
import com.example.calculatorapp.validator.LoginValidator;

public class LoginController {
    private FieldAuthValidator<LoginRequest> loginValidator;

    public LoginController() {
        this.loginValidator = new LoginValidator();
    }

    public void login(LoginRequest loginRequest) throws AuthException {
        loginValidator.validate(loginRequest);
    }
}
