package com.shiyanlou.server.handler;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName CalcBean.java
 * @Description TODO
 * @createTime 2020年08月15日 22:21:00
 */

public class CalcBean {
    private int num1;
    private int num2;
    private String symbol;

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return num1 + " " + symbol + " " + num2;
    }
}
