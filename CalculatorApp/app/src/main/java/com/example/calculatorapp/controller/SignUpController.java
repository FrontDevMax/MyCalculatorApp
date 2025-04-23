package com.example.calculatorapp.controller;

import android.util.Patterns;

import com.example.calculatorapp.enumeration.ErrorType;
import com.example.calculatorapp.exception.AuthException;
import com.example.calculatorapp.model.SignUpData;

public class SignUpController {
    public void validateUsername(SignUpData signUpData) throws AuthException {
        if(signUpData.getUsername().equals("")) {
            throw new AuthException(ErrorType.USERNAME, "Поле имя пользователя пустое!");
        }  else if(signUpData.getUsername().length() > 20) {
            throw new AuthException(ErrorType.USERNAME, "Поле имя пользователя пустое!");
        }
    }

    public void validateEmail(SignUpData signUpData) throws AuthException {
        if(signUpData.getEmail().equals("")) {
            throw new AuthException(ErrorType.EMAIL, "Поле email пустое!");
        } else if (!Patterns.EMAIL_ADDRESS.matcher(signUpData.getEmail()).matches()) {
            throw new AuthException(ErrorType.EMAIL, "Поле email отсутствует @!");
        }
    }

    public void validatePassword(SignUpData signUpData) throws AuthException {
        if(signUpData.getPassword().equals("")) {
            throw new AuthException(ErrorType.PASSWORD, "Поле пароля пустое!");
        } else if(signUpData.getPassword().length() > 8) {
            throw new AuthException(ErrorType.PASSWORD, "Длина пароля должна быть не более 8 символов");
        }
    }

    public void validateConfirmPassword(SignUpData signUpData) throws AuthException {
        if(signUpData.getPassword().equals("")) {
            throw new AuthException(ErrorType.CONFIRM_PASSWORD, "Поле повторите пароля пустое!");
        } else if(signUpData.getConfirmPassword().equalsIgnoreCase(signUpData.getPassword())) {
            throw new AuthException(ErrorType.CONFIRM_PASSWORD, "Поле повторите пароля не совпадает с паролем!");
        }
    }
}
