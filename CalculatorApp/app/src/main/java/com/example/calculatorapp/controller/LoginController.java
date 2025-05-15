package com.example.calculatorapp.controller;

import com.example.calculatorapp.exception.AuthException;
import com.example.calculatorapp.model.LoginRequest;
import com.example.calculatorapp.util.Validator;

public class LoginController {
    public void validateSignIn(LoginRequest loginRequest) throws AuthException {
        Validator.validateEmail(loginRequest.getEmail());
        Validator.validatePassword(loginRequest.getPassword());
        Validator.validateUser(loginRequest.getEmail(), loginRequest.getPassword());
    }
}
