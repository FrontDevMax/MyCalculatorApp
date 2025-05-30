package com.example.calculatorapp.presentation.view;

import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.calculatorapp.R;
import com.example.calculatorapp.presentation.util.Router;

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
        Router router = new Router(activity);
        builder.setTitle("Выход");
        builder.setMessage("Вы точно хотите уйти?");
        builder.setPositiveButton("Да", (dialog, which) -> {
            new Router(activity).exitApp(activity.getClass());
        });

        builder.setNegativeButton("Нет", (dialog, which) -> {
            dialog.dismiss();
        });

        builder.setCancelable(true);
        builder.show();
    }
}
