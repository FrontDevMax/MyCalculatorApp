package com.example.calculatorapp.util;

import android.graphics.Color;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public final class DisplayError {
    private DisplayError() {}

    public static void showError(TextInputLayout inputLayout, String message) {
        inputLayout.setError(message);
        inputLayout.setErrorEnabled(true);
    }

    public static void showError(TextInputLayout inputLayout, ImageView inputToggle, String message) {
        inputLayout.setError(message);
        inputLayout.setErrorEnabled(true);
        inputToggle.setColorFilter(Color.RED);
    }

    public static void showError(TextView textView, String message) {
        textView.setText(message);
    }
}
