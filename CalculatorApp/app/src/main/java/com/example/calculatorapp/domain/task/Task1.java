package com.example.calculatorapp.domain.task;

import com.example.calculatorapp.presentation.util.Logger;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Task1 implements Task {
    @Override
    public void runTask(String first, String last) {
        BigInteger start = new BigInteger(first);
        BigInteger end = new BigInteger(last);
        while (start.compareTo(end) <= 0) {
            if (!containsZero(start)) {
                BigInteger product = digitProduct(start);
                if (!product.equals(BigInteger.ZERO)) {
                    BigDecimal result = calcResult(start, product);
                    if (isInteger(result)) {
                        Logger.add(start.toString());
                    }
                }
            }
            start = start.add(BigInteger.ONE);
        }
    }

    private BigDecimal calcResult(BigInteger start, BigInteger multiply) {
        return new BigDecimal(start).divide(new BigDecimal(multiply), 10, RoundingMode.HALF_UP);
    }

    private boolean containsZero(BigInteger num) {
        String s = num.toString();
        return s.contains("0");
    }

    private BigInteger digitProduct(BigInteger num) {
        BigInteger product = BigInteger.ONE;
        String s = num.toString();
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            product = product.multiply(BigInteger.valueOf(digit));
            if (product.equals(BigInteger.ZERO)) {
                return BigInteger.ZERO;
            }
        }
        return product;
    }

    private boolean isInteger(BigDecimal num) {
        return num.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0;
    }
}
