package com.example.calculatorapp.util;

import android.graphics.Color;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public final class ResetInput {
    private ResetInput() {}

    public static void reset(TextInputLayout input) {
        input.setError(null);
        input.setErrorEnabled(false);
    }

    public static void reset(TextInputLayout input, ImageView inputToggle) {
        input.setError(null);
        input.setErrorEnabled(false);
        inputToggle.setColorFilter(Color.parseColor("#009688"));
    }

    public static void reset(TextView textView) {
        textView.setText("");
    }

    public static void reset(ImageView inputToggle) {
        inputToggle.setColorFilter(Color.parseColor("#009688"));
    }

    public static void reset(TextInputEditText editText) {
        editText.setText("");
    }
}
