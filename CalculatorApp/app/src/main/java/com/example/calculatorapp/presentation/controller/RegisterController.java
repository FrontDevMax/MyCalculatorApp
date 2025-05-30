package com.example.calculatorapp.presentation.controller;

import android.content.Context;

import com.example.calculatorapp.domain.model.Credentials;
import com.example.calculatorapp.domain.model.LoginRequest;
import com.example.calculatorapp.domain.model.RegisterRequest;
import com.example.calculatorapp.domain.repository.AuthRepository;
import com.example.calculatorapp.presentation.validator.ConfirmPasswordValidator;
import com.example.calculatorapp.presentation.validator.EmailValidator;
import com.example.calculatorapp.presentation.validator.Validator;
import com.example.calculatorapp.presentation.validator.PasswordValidator;
import com.example.calculatorapp.presentation.validator.UsernameValidator;
//import com.example.calculatorapp.presentation.validator.RegisterValidator;

public class RegisterController {
    private final AuthRepository authRepository;

    public RegisterController(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public void register(RegisterRequest registerRequest, AuthRepository.AuthCallback callback) {
        authRepository.register(registerRequest, callback);
    }
}
