package com.example.calculatorapp.domain.model;

import com.example.calculatorapp.presentation.validator.CredentialsHolder;

public class RegisterRequest implements CredentialsHolder {
    private String username;
    private final Credentials credentials;
    private String confirmPassword;

    public RegisterRequest(
            String username,
            String email,
            String password,
            String confirmPassword
    ) {
        this.username = username;
        this.credentials = new Credentials(email, password);
        this.confirmPassword = confirmPassword;
    }

    @Override
    public Credentials getCredentials() {
        return credentials;
    }

    public String getUsername() {
        return username;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
