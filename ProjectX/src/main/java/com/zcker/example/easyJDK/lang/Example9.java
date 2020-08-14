package com.zcker.example.easyJDK.lang;

import java.util.Random;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName Example9.java
 * @Description TODO
 * @createTime 2020年08月07日 12:58:00
 */

public class Example9 {
    public static void main(String[] args) {
        Random random = new Random();
        random.setSeed(3);
        System.out.println(random.nextGaussian());
    }
}
