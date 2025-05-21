package com.example.calculatorapp.controller;

import com.example.calculatorapp.enumeration.AuthError;
import com.example.calculatorapp.exception.AuthException;
import com.example.calculatorapp.model.LoginRequest;
<<<<<<< HEAD
import com.example.calculatorapp.validator.FieldValidator;
import com.example.calculatorapp.validator.LoginValidator;

public class LoginController {
    private LoginValidator loginValidator = new LoginValidator();
    private LoginRequest loginRequest = new LoginRequest();

    public void validateLogin() throws AuthException {
        loginValidator.validateEmail(loginRequest.getEmail());
        loginValidator.validatePassword(loginRequest.getPassword());
=======
import com.example.calculatorapp.validator.AuthValidator;

public class LoginController {
    public void validateLogin(LoginRequest loginRequest) throws AuthException {
        AuthValidator.validateEmail(loginRequest.getEmail());
        AuthValidator.validatePassword(loginRequest.getPassword());
        AuthValidator.validateUser(loginRequest.getEmail(), loginRequest.getPassword());
>>>>>>> 762fa47b2cdb5880465c82ad77ed8758b6f7307f
    }
}
