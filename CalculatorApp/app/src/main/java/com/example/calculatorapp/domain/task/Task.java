package com.example.calculatorapp.domain.task;

@FunctionalInterface
public interface Task {
    void runTask(String start, String end);
}
