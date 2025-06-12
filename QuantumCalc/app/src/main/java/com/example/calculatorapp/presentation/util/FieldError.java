package com.example.calculatorapp.presentation.util;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public final class FieldError {
    private FieldError() {}

    public static void showError(TextInputLayout inputLayout, String message) {
        inputLayout.setError(message);
        inputLayout.setErrorEnabled(true);
        inputLayout.setEndIconTintList(ColorStateList.valueOf(Color.RED));
    }

    public static void showError(TextView textView, String message) {
        textView.setText(message);
        textView.setEnabled(true);
    }
}
