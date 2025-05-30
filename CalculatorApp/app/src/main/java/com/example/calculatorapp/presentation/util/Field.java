package com.example.calculatorapp.presentation.util;

import com.google.android.material.textfield.TextInputEditText;

public final class Field {
    public static String getField(TextInputEditText editText) {
        return editText.getText().toString().trim();
    }
}
