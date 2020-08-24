package com.shiyanlou.bean;

import java.io.Serializable;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName CalcResponse.java
 * @Description TODO
 * @createTime 2020年08月16日 14:43:00
 */

public class CalcResponse implements Serializable {
    private static final long serialVersionUID = -3707163497591222456L;

    private double result;

    public CalcResponse(double result) {
        this.result = result;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
