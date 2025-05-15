package com.example.calculatorapp.controller;

import com.example.calculatorapp.exception.AuthException;
import com.example.calculatorapp.model.RegisterRequest;
import com.example.calculatorapp.util.Validator;

public class RegisterController {
    public void validateRegister(RegisterRequest registerRequest) throws AuthException {
        Validator.validateUsername(registerRequest.getUsername());
        Validator.validateEmail(registerRequest.getEmail());
        Validator.validatePassword(registerRequest.getPassword());
        Validator.validateConfirmPassword(
                registerRequest.getPassword(),
                registerRequest.getConfirmPassword()
        );
    }
}
