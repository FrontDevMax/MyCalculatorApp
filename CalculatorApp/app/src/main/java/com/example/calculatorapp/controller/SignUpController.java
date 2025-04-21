package com.example.calculatorapp.controller;

import android.util.Patterns;

import com.example.calculatorapp.enumeration.ErrorType;
import com.example.calculatorapp.exception.AuthException;
import com.example.calculatorapp.model.SignUpData;

public class SignUpController {
    public void validateFields(SignUpData signUpData) throws AuthException {
        if(signUpData.getUsername().equals("")) {
            throw new AuthException(ErrorType.USERNAME, "Поле имя пользователя пустое!");
        } else if(signUpData.getEmail().equals("")) {
            throw new AuthException(ErrorType.EMAIL, "Поле email пустое!");
        } else if (!Patterns.EMAIL_ADDRESS.matcher(signUpData.getEmail()).matches()) {
            throw new AuthException(ErrorType.EMAIL, "Поле email отсутствует @!");
        } else if(signUpData.getPassword().equals("")) {
            throw new AuthException(ErrorType.PASSWORD, "Поле пароля пустое!");
        } else if(!signUpData.getConfirmPassword().equals(signUpData.getPassword())) {
            throw new AuthException(ErrorType.CONFIRM_PASSWORD, "Пароль не совпадает с предыдущим!");
        }
    }
}
