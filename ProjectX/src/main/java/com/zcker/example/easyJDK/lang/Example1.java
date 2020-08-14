package com.zcker.example.easyJDK.lang;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName Example1.java
 * @Description TODO
 * @createTime 2020年08月02日 15:46:00
 */

public class Example1 {
    public static void main(String[] args) {
        Integer a = new Integer("10");
        Integer b = new Integer(11);
        System.out.println(a.compareTo(b));
        System.out.println(a.equals(b));
        float c = a.floatValue();
        System.out.println(c);
        String d = "10101110";
        int e = Integer.parseInt(d, 2);
        System.out.println(e);
    }
}
