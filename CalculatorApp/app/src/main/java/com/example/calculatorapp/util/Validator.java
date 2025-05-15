package com.example.calculatorapp.util;

import android.util.Patterns;

import com.example.calculatorapp.enumeration.AuthError;
import com.example.calculatorapp.exception.AuthException;

public final class Validator {
    public static void validateUser(String email, String password) throws AuthException {
        if(!email.equals("admin@gmail.com") || !password.equals("admin")) {
            throw new AuthException(AuthError.LOGIN, "Неверный email или password");
        }
    }
    public static void validateUsername(String username) throws AuthException {
        if(username.equals("")) {
            throw new AuthException(AuthError.USERNAME, "Поле имя пользователя пустое!");
        }  else if(username.length() > 20) {
            throw new AuthException(AuthError.USERNAME, "Поле имя пользователя пустое!");
        }
    }

    public static void validateEmail(String email) throws AuthException {
        if(email.equals("")) {
            throw new AuthException(AuthError.EMAIL, "Эл. почта не должна быть пустая!");
        } else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            throw new AuthException(AuthError.EMAIL, "Отсутствует @ или неправильно ввели что-то");
        }
    }

    public static void validatePassword(String password) throws AuthException {
        if(password.equals("")) {
            throw new AuthException(AuthError.PASSWORD, "Пароль не должен быть пустым!");
        } else if(password.length() > 8) {
            throw new AuthException(AuthError.PASSWORD, "Длина пароля должна быть не более 8 символов");
        }
    }

    public static void validateConfirmPassword(String password, String confirmPassword) throws AuthException {
        if(confirmPassword.equals("")) {
            throw new AuthException(AuthError.CONFIRM_PASSWORD, "Поле повторите пароля пустое!");
        } else if(!confirmPassword.equals(password)) {
            throw new AuthException(AuthError.CONFIRM_PASSWORD, "Поле повторите пароля не совпадает с паролем!");
        }
    }
}
