package com.example.calculatorapp.presentation.util;

import android.util.Log;

import com.example.calculatorapp.domain.exception.ErrorHandler;
import com.example.calculatorapp.presentation.validator.ValidationResult;
import com.example.calculatorapp.presentation.validator.Validator;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.function.Consumer;
import java.util.function.Supplier;

public final class AutoValidation {
    public static <T> void setup(
            TextInputLayout inputLayout,
            Consumer<String> consumer,
            Supplier<T> supplier,
            Validator<T> validator
    ) {
        TextInputEditText editText = (TextInputEditText) inputLayout.getEditText();
        editText.setOnFocusChangeListener((v, hasFocus) -> {
           if(!hasFocus) {
               consumer.accept(Field.getField(editText));
               T model = supplier.get();
               ValidationResult validationResult = validator.validate(model);
               validationResult.applyResult(inputLayout, validationResult);
           }
        });
    }
}
