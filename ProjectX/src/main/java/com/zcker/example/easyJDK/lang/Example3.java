package com.zcker.example.easyJDK.lang;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName Example3.java
 * @Description TODO
 * @createTime 2020年08月02日 16:05:00
 */

public class Example3 {
    public static void main(String[] args) {
        // Boolean(boolean value) 构造方法
        Boolean a = new Boolean(true);
        System.out.println("a 为" + a);
        // Boolean(String s) 构造方法
        Boolean b = new Boolean("true");
        Boolean c = new Boolean("OK");
        System.out.println("b 为" + b);
        System.out.println("c 为" + c);
        System.out.println("a 的 booleanValue() 为" + a.booleanValue());
        System.out.println("a 和 b 相等吗？" + a.equals(b));
    }
}
