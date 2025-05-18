package com.example.calculatorapp.view;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public interface BackPressHandler {
    default void setupBackPress(AppCompatActivity activity, boolean showDialog) {
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if(showDialog) {
                    showExitDialog(activity);
                } else {
                    activity.getOnBackPressedDispatcher().onBackPressed();
                }
            }
        };
        activity.getOnBackPressedDispatcher().addCallback(activity, callback);
    }

    default void showExitDialog(AppCompatActivity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Выход");
        builder.setMessage("Вы точно хотите уйти?");

        builder.setPositiveButton("Да", (dialog, which) -> {
            activity.finish();
        });

        builder.setNegativeButton("Нет", (dialog, which) -> {
            dialog.dismiss();
        });

        builder.setCancelable(true);
        builder.show();
    }
}
