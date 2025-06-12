package com.example.calculatorapp.presentation.validator;

import com.example.calculatorapp.domain.model.Credentials;

@FunctionalInterface
public interface CredentialsHolder {
    Credentials getCredentials();
}
