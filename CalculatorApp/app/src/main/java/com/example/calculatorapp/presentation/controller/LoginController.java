package com.example.calculatorapp.presentation.controller;

import com.example.calculatorapp.domain.model.Credentials;
import com.example.calculatorapp.domain.model.LoginRequest;
import android.content.Context;

import com.example.calculatorapp.domain.model.RegisterRequest;
import com.example.calculatorapp.domain.repository.AuthRepository;
import com.example.calculatorapp.presentation.validator.EmailValidator;
import com.example.calculatorapp.presentation.validator.LoginValidator;
import com.example.calculatorapp.presentation.validator.Validator;
import com.example.calculatorapp.presentation.validator.PasswordValidator;

public class LoginController {
    private final AuthRepository authRepository;

    public LoginController(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public void login(LoginRequest loginRequest, AuthRepository.AuthCallback callback) {
        authRepository.login(loginRequest, callback);
    }
}
