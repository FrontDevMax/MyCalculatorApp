package com.example.calculatorapp.presentation.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public final class Router {
    private Context context;

    public Router(Context context) {
        this.context = context;
    }

    public void navigateTo(Class<?> destination) {
        Intent intent = new Intent(context, destination);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        if (context instanceof Activity) {
            ((Activity)context).finish();
        }
    }

    public void navigateToWithSavedActivity(Class<?> destination) {
        Intent intent = new Intent(context, destination);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        context.startActivity(intent);
    }

    public void exitApp() {
        if (context instanceof Activity) {
            ((Activity)context).finish();
        }
    }
}
