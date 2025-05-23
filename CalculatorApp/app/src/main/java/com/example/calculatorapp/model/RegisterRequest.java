package com.example.calculatorapp.model;

public class RegisterRequest {
    private String username;
    private Credentials credentials;
    private String confirmPassword;

    public RegisterRequest() {
        this.credentials = new Credentials();
    }

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
