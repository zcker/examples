package com.zcker.example.ShiyanlouLambda;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName NewFeatureTester1.java
 * @Description TODO
 * @createTime 2020年07月31日 17:48:00
 */

public class NewFeatureTester1 {
    //final static String salutation = "Hello1 "; // 正确，不可再次赋值
    // static String salutation = "Hello "; // 正确，可再次赋值
    // String salutation = "Hello "; // 报错
    // final String salutation = "Hello "; // 报错

    public static void main(String args[]){
         //final String salutation = "Hello2 "; // 正确，不可再次赋值
         String salutation = "Hello "; // 正确，隐性为 final，不可再次赋值

        // salution = "welcome to "
        GreetingService greetService1 = message ->
                System.out.println(salutation + message);
        greetService1.sayMessage("Shiyanlou");

    }

    interface GreetingService{
        void sayMessage(String message);
    }
}