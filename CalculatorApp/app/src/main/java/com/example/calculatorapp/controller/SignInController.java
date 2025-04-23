package com.example.calculatorapp.controller;

import android.database.Cursor;
import android.util.Log;
import android.util.Patterns;

import com.example.calculatorapp.enumeration.ErrorType;
import com.example.calculatorapp.exception.AuthException;
import com.example.calculatorapp.model.SignInData;
import com.example.calculatorapp.repository.UserRepo;
import com.example.calculatorapp.utils.DatabaseHelper;

public class SignInController {
    private UserRepo userRepo;
    public void validateFields(SignInData signInData, Cursor cursor) throws AuthException {
        if(signInData.getEmail().equals("")) {
            throw new AuthException(ErrorType.EMAIL, "Эл. почта не должна быть пустая!");
        } else if (!Patterns.EMAIL_ADDRESS.matcher(signInData.getEmail()).matches()) {
            throw new AuthException(ErrorType.EMAIL, "ХЗ");
        } else if(signInData.getPassword().equals("")) {
            throw new AuthException(ErrorType.PASSWORD, "Пароль не должен быть пустым!");
        }
        boolean isFind = false;
        while(cursor.moveToNext()) {
            String email = cursor.getString(2);
            String password = cursor.getString(3);
            Log.e("SQL", email);
            Log.e("SQL", password);
            if(signInData.getEmail().equals(email) && signInData.getPassword().equals(password)) {
                isFind = true;
            }
        }
        cursor.close();
        if(!isFind) {
            throw new AuthException(ErrorType.SIGNIN, "Такого аккаунта нет");
        }
    }
}
