package com.example.calculatorapp.model;

public class SignInData {
    private String email;
    private String password;

    public SignInData(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
