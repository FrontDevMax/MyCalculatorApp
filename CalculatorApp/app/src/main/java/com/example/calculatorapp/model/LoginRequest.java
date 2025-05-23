package com.example.calculatorapp.model;

public class LoginRequest {
    private Credentials credentials;

    public LoginRequest() {
        this.credentials = new Credentials();
    }

    public Credentials getCredentials() {
        return credentials;
    }
}
