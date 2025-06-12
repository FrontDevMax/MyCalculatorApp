package com.example.calculatorapp.domain.enumeration;

public enum Title {
    TASK_1("Числа Цукермана"),
    TASK_2("Числа Нивена"),
    TASK_6("Числа Кита"),
    TASK_8("Числа Капрекара");

    private final String info;

    Title(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
