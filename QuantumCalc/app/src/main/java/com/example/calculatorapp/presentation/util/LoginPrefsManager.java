package com.example.calculatorapp.presentation.util;

import android.content.SharedPreferences;

import android.content.Context;

import com.example.calculatorapp.domain.model.LoginRequest;

public class LoginPrefsManager {
    private static final String PREFS_NAME = "LoginPrefs";
    private static final String KEY_REMEMBER_ME = "remember_me";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";

    private final SharedPreferences preferences;

    public LoginPrefsManager(Context context) {
        preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public void saveFields(LoginRequest loginRequest, boolean rememberMe) {
        SharedPreferences.Editor editor = preferences.edit();
        if (rememberMe) {
            editor.putString(KEY_EMAIL, loginRequest.getCredentials().getEmail());
            editor.putString(KEY_PASSWORD, loginRequest.getCredentials().getPassword());
        } else {
            editor.remove(KEY_EMAIL);
            editor.remove(KEY_PASSWORD);
        }
        editor.putBoolean(KEY_REMEMBER_ME, rememberMe);
        editor.apply();
    }

    public String getSavedEmail() {
        return preferences.getString(KEY_EMAIL, null);
    }

    public String getSavedPassword() {
        return preferences.getString(KEY_PASSWORD, null);
    }

    public boolean isRememberMeChecked() {
        return preferences.getBoolean(KEY_REMEMBER_ME, false);
    }

    public void clearSavedFields() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(KEY_EMAIL);
        editor.remove(KEY_PASSWORD);
        editor.remove(KEY_REMEMBER_ME);
        editor.apply();
    }
}