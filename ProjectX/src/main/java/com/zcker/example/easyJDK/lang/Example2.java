package com.zcker.example.easyJDK.lang;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName Example2.java
 * @Description TODO
 * @createTime 2020年08月02日 15:54:00
 */

public class Example2 {
    public static void main(String[] args) {
        int count;
        char[] values = {'*', '_', '%', '8', 'L', 'l'};
        for (count = 0; count < values.length; count++) {
            if (Character.isDigit(values[count])) {
                System.out.println(values[count] + "数字");
            }
            if (Character.isLetter(values[count])) {
                System.out.println(values[count] + "字母");
            }
            if (Character.isUpperCase(values[count])) {
                System.out.println(values[count] + "大写");
            }
            if (Character.isLowerCase(values[count])) {
                System.out.println(values[count] + "小写");
            }
            if (Character.isUnicodeIdentifierStart(values[count])) {
                System.out.println(values[count] + "是UNI");
            }
        }

        char c = ' ';
        System.out.println("空白？" + Character.isWhitespace(c));
    }
}
