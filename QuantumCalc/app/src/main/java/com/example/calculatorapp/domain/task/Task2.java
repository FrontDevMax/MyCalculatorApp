package com.example.calculatorapp.domain.task;

import com.example.calculatorapp.presentation.util.Logger;

public class Task2 implements Task {
    @Override
    public void runTask(String first, String last) {
        int start = Integer.parseInt(first);
        int end = Integer.parseInt(last);
        for (int num = start; num <= end; num++) {
            if (containsZero(num)) {
                continue;
            }
            int sum = digitSum(num);
            if (sum == 0) {
                continue;
            }
            if (num % sum == 0) {
                Logger.add(Integer.toString(num));
            }
        }
    }

    private boolean containsZero(int num) {
        int n = Math.abs(num);
        while (n > 0) {
            if (n % 10 == 0) {
                return true;
            }
            n /= 10;
        }
        return false;
    }

    private int digitSum(int num) {
        int sum = 0;
        int n = Math.abs(num);
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
