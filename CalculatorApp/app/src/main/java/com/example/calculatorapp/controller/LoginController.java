package com.example.calculatorapp.controller;

import com.example.calculatorapp.enumeration.AuthError;
import com.example.calculatorapp.exception.AuthException;
import com.example.calculatorapp.model.LoginRequest;
import com.example.calculatorapp.validator.FieldValidator;
import com.example.calculatorapp.validator.LoginValidator;

public class LoginController {
    private LoginValidator loginValidator = new LoginValidator();
    private LoginRequest loginRequest = new LoginRequest();

    public void validateLogin() throws AuthException {
        loginValidator.validateEmail(loginRequest.getEmail());
        loginValidator.validatePassword(loginRequest.getPassword());
    }
}
