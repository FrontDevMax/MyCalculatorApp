package com.example.calculatorapp.controller;

import android.util.Patterns;

import com.example.calculatorapp.enumeration.ErrorType;
import com.example.calculatorapp.exception.AuthException;
import com.example.calculatorapp.model.SignInData;
import com.example.calculatorapp.repository.UserRepo;

public class SignInController {
    public void validateFields(SignInData signInData) throws AuthException {
        if(signInData.getEmail().equals("")) {
            throw new AuthException(ErrorType.EMAIL, "Эл. почта не должна быть пустая!");
        } else if (!Patterns.EMAIL_ADDRESS.matcher(signInData.getEmail()).matches()) {
            throw new AuthException(ErrorType.EMAIL, "ХЗ");
        } else if(signInData.getPassword().equals("")) {
            throw new AuthException(ErrorType.PASSWORD, "Пароль не должен быть пустым!");
        }
    }

    public void checkSignIn(String email, String confirmPassword) throws AuthException {
        UserRepo repo = new UserRepo();
        if(!repo.signInUser(email, confirmPassword)) {
            throw new AuthException(ErrorType.SIGNIN, "Такого пользователя нет");
        }
    }

}
