package com.example.calculatorapp.controller;

import android.util.Patterns;

import com.example.calculatorapp.enumeration.ErrorType;
import com.example.calculatorapp.exception.AuthException;
import com.example.calculatorapp.model.LoginData;

public class LoginController {
    public void validateEmail(LoginData loginData) throws AuthException {
        if(loginData.getEmail().equals("") && !Patterns.EMAIL_ADDRESS.matcher(loginData.getEmail()).matches()) {
            throw new AuthException(ErrorType.EMAIL, "Эл. почта не должна быть пустая!");
        }
    }

    public void validatePassword(LoginData loginData) throws AuthException {
        if(loginData.getPassword().equals("")) {
            throw new AuthException(ErrorType.PASSWORD, "Пароль не должен быть пустым!");
        }
    }
}
