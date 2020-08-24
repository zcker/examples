package com.shiyanlou.bean;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName CalcRequest.java
 * @Description TODO
 * @createTime 2020年08月16日 14:40:00
 */

import java.io.Serializable;

public class CalcRequest implements Serializable {
    private static final long serialVersionUID = 2550047665191884003L;

    //数字一
    private int num1;
    //数字二
    private int num2;
    //运算符号
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
