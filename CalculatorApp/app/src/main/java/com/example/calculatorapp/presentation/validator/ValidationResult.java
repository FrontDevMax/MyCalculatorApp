package com.example.calculatorapp.presentation.validator;

import com.example.calculatorapp.presentation.util.FieldError;
import com.example.calculatorapp.presentation.util.ResetInput;
import com.google.android.material.textfield.TextInputLayout;

public class ValidationResult {
    private String message;
    private boolean isValid;

    public ValidationResult(String message, boolean isValid) {
        this.message = message;
        this.isValid = isValid;
    }

    public static ValidationResult invalid(String message) {
        return new ValidationResult(message, false);
    }

    public static ValidationResult valid() {
        return new ValidationResult(null, true);
    }

    public void applyResult(TextInputLayout inputLayout, ValidationResult result) {
        if(result.isValid()) {
            ResetInput.reset(inputLayout);
        } else {
            FieldError.showError(inputLayout, result.getMessage());
        }
    }

    public boolean isValid() {
        return isValid;
    }

    public String getMessage() {
        return message;
    }
}
