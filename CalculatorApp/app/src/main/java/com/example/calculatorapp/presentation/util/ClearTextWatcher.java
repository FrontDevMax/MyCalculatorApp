package com.example.calculatorapp.presentation.util;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class ClearTextWatcher implements TextWatcher {
    private TextInputLayout inputLayout;
    private TextView textView;
    private ImageView passwordToggle;

    public ClearTextWatcher(TextInputLayout inputLayout, TextView textView, ImageView passwordToggle) {
        this.inputLayout = inputLayout;
        this.textView = textView;
        this.passwordToggle = passwordToggle;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        ResetInput.reset(inputLayout);
        ResetInput.reset(textView);
        ResetInput.reset(passwordToggle);
    }

    @Override
    public void afterTextChanged(Editable s) {}
}
