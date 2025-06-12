package com.example.calculatorapp.presentation.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class DateTime {
    private DateTime(){}

    public static String getCurrentTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM.dd, hh:mm:ss.SSS");
        return "[" + simpleDateFormat.format(Calendar.getInstance().getTime()) + "]: ";
    }
}
