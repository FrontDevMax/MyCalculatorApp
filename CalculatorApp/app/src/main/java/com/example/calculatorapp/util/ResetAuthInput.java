package com.example.calculatorapp.util;

import android.content.res.Resources;
import android.graphics.Color;
import android.widget.ImageView;

import androidx.core.content.ContextCompat;

import com.example.calculatorapp.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ResourceBundle;

public final class ResetAuthInput {
    private ResetAuthInput() {}

    public static void resetUsername(TextInputLayout username) {
        username.setError(null);
        username.setErrorEnabled(false);
    }

    public static void resetEmail(TextInputLayout email) {
        email.setError(null);
        email.setErrorEnabled(false);
    }

    public static void resetPassword(TextInputLayout password, ImageView passwordToggle) {
        password.setError(null);
        password.setErrorEnabled(false);
        passwordToggle.setColorFilter(Color.parseColor("#009688"));
    }

    public static void resetConfirmPassword(TextInputLayout confirmPassword, ImageView confirmPasswordToggle) {
        confirmPassword.setError(null);
        confirmPassword.setErrorEnabled(false);
        confirmPasswordToggle.setColorFilter(Color.parseColor("#009688"));
    }
}
