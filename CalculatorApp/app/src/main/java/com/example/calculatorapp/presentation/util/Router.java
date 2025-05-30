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
        context.startActivity(intent);
        ((Activity)context).finish();
    }

    public void navigateToWithSavedActivity(Class<?> destination) {
        Intent intent = new Intent(context, destination);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(intent);
    }

    public void exitApp(Class<?> destination) {
        Intent intent = new Intent(context, destination);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        ((Activity)context).finish();
    }
}
