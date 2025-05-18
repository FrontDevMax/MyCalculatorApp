package com.example.calculatorapp.controller;

import com.example.calculatorapp.exception.AuthException;
import com.example.calculatorapp.model.LoginRequest;
import com.example.calculatorapp.validator.AuthValidator;

public class LoginController {
    public void validateLogin(LoginRequest loginRequest) throws AuthException {
        AuthValidator.validateEmail(loginRequest.getEmail());
        AuthValidator.validatePassword(loginRequest.getPassword());
        AuthValidator.validateUser(loginRequest.getEmail(), loginRequest.getPassword());
    }
}
