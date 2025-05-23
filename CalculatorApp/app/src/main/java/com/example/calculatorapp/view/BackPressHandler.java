package com.example.calculatorapp.view;

import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.calculatorapp.R;

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
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.MyAlertDialogTheme);
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
