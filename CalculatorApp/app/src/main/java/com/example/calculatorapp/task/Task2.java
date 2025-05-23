package com.example.calculatorapp.task;

import android.util.Log;

import com.example.calculatorapp.util.Logger;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Task2 implements Task {
    @Override
    public void runTask(String first, String last) {
        BigInteger start = new BigInteger(first);
        BigInteger end = new BigInteger(last);
        while(start.compareTo(end) <= 0) {
            BigInteger temp = new BigInteger(start.toString());
            int length = first.length();
            BigInteger sum = sumNumbers(temp, length);
            if(isZero(sum)) {
                start = start.add(BigInteger.ONE);
                continue;
            }
            BigDecimal result = calcResult(start, sum);
            showResult(start, result);
            start = start.add(BigInteger.ONE);
        }
    }

    private boolean isZero(BigInteger sum) {
        if(sum.compareTo(BigInteger.ZERO) == 0) {
            return true;
        }
        return false;
    }

    private BigInteger sumNumbers(BigInteger start, int length) {
        BigInteger sum = BigInteger.ZERO;
        for(int i = 0; i < length; i++) {
            sum = sum.add(start.mod(BigInteger.TEN));
            start = start.divide(BigInteger.TEN);
        }
        return sum;
    }

    private BigDecimal calcResult(BigInteger start, BigInteger sum) {
        return new BigDecimal(start).divide(new BigDecimal(sum), 10, RoundingMode.HALF_UP);
    }

    private void showResult(BigInteger start, BigDecimal result) {
        if(isInteger(result)) {
            Logger.add(start.toString());
        }
    }

    private boolean isInteger(BigDecimal result) {
        return result.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0;
    }
}
