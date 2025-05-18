package com.example.calculatorapp.util;

public final class Logger {
    private Logger(){}

    public String showLog(String log) {
        return "[" + DateTime.getCurrentTime() + "]: " + log;
    }
}
