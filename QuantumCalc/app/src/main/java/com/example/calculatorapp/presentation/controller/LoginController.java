package com.example.calculatorapp.presentation.controller;

import com.example.calculatorapp.domain.model.LoginRequest;

import com.example.calculatorapp.domain.repository.AuthRepository;

public class LoginController {
    private final AuthRepository authRepository;

    public LoginController(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public void login(LoginRequest loginRequest, AuthRepository.AuthCallback callback) {
        authRepository.login(loginRequest, callback);
    }
}
