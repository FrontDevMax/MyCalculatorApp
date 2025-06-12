package com.example.calculatorapp.domain.task;

import com.example.calculatorapp.presentation.util.Logger;

public class Task1 implements Task {
    @Override
    public void runTask(String first, String last) {
        int start = Integer.parseInt(first);
        int end = Integer.parseInt(last);
        while (start <= end) {
            if (!containsZero(start)) {
                int product = digitProduct(start);
                if (!(product == 0)) {
                    double result = calcResult(start, product);
                    if (isInteger(result)) {
                        Logger.add(Integer.toString(start));
                    }
                }
            }
            start++;
        }
    }

    private double calcResult(int start, int multiply) {
        return (double)start / multiply;
    }

    private boolean containsZero(int num) {
        String s = Integer.toString(num);
        return s.contains("0");
    }

    private int digitProduct(int num) {
        int product = 1;
        String s = Integer.toString(num);
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            product *= digit;
            if (product == 0) {
                return 1;
            }
        }
        return product;
    }

    private boolean isInteger(double num) {
        return num % 1 == 0;
    }
}
