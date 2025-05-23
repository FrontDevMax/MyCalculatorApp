package com.example.calculatorapp.task;

import android.util.Log;

import com.example.calculatorapp.util.Logger;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Task1 implements Task {
    @Override
    public void runTask(String first, String last) {
        BigInteger start = new BigInteger(first);
        BigInteger end = new BigInteger(last);
        while(start.compareTo(end) <= 0) {
            BigInteger temp = new BigInteger(start.toString());
            int length = first.length();
            BigInteger multiply = multiplyNumbers(temp, length);
            if(isZero(multiply)) {
                start = start.add(BigInteger.ONE);
                continue;
            }
            BigDecimal result = calcResult(start, multiply);
            showResult(start, result);
            start = start.add(BigInteger.ONE);
        }
    }

    private boolean isZero(BigInteger multiply) {
        if(multiply.compareTo(BigInteger.ZERO) == 0) {
            return true;
        }
        return false;
    }

    private BigInteger multiplyNumbers(BigInteger start, int length) {
        BigInteger multiply = BigInteger.ONE;
        for(int i = 0; i < length; i++) {
            multiply = multiply.multiply(start.mod(BigInteger.TEN));
            start = start.divide(BigInteger.TEN);
        }
        return multiply;
    }

    private BigDecimal calcResult(BigInteger start, BigInteger multiply) {
        return new BigDecimal(start).divide(new BigDecimal(multiply), 10, RoundingMode.HALF_UP);
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
