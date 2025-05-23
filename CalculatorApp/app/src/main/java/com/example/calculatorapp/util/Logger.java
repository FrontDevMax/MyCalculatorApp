package com.example.calculatorapp.util;

import android.widget.TextView;

import java.util.ArrayList;

public final class Logger {
    private static StringBuilder sb = new StringBuilder();

    private Logger(){}

    public static void add(String num) {
        sb.append(DateTime.getCurrentTime() + num + "\n");
    }

    public static void log(TextView textView) {
        textView.setText(sb.toString());
    }
}
