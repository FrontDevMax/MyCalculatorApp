package com.example.calculatorapp.util;

import com.example.calculatorapp.task.Task;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class DateTime {
    private DateTime(){}

    public static String getCurrentTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM.dd, hh:mm:ss.SSS");
        return simpleDateFormat.format(Calendar.getInstance().getTime());
    }
}
