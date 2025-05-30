package com.example.calculatorapp.presentation.util;

import com.example.calculatorapp.domain.enumeration.Title;

public final class TaskHandler {
    public static String handleTask(int selectedItem) {
        final Title title;
        switch(selectedItem) {
            case 0:
                title = Title.TASK_1;
                break;
            case 1:
                title = Title.TASK_2;
                break;
            case 2:
                title = Title.TASK_6;
                break;
            case 3:
                title = Title.TASK_8;
                break;
            default:
                throw new IllegalArgumentException("Invalid task number");
        }
        return title.getInfo();
    }
}
