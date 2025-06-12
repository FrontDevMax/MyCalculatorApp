package com.example.calculatorapp.domain.model;

import com.example.calculatorapp.presentation.validator.CredentialsHolder;

public class LoginRequest implements CredentialsHolder {
    private final Credentials credentials;

    public LoginRequest(String email, String password) {
        this.credentials = new Credentials(email, password);
    }

    @Override
    public Credentials getCredentials() {
        return credentials;
    }
}
