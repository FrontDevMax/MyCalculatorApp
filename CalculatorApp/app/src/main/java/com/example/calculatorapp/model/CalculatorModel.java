package com.example.calculatorapp.model;

public class CalculatorModel {
    private String startNum;
    private String endNum;

    public CalculatorModel(String startNum, String endNum) {
        this.startNum = startNum;
        this.endNum = endNum;
    }

    public String getStartNum() {
        return startNum;
    }

    public String getEndNum() {
        return endNum;
    }
}
