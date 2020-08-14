package com.zcker.example.ShiyanlouLambda;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName NewFeatureTester.java
 * @Description TODO
 * @createTime 2020年07月31日 17:17:00
 */

public class NewFeatureTester {
    public static void main(String args[]) {
        NewFeatureTester tester = new NewFeatureTester();

        MathOperation addition = (int a, int b) -> a + b;

        MathOperation subtraction = (a, b) -> a - b;

        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };

        MathOperation division = (int a, int b) -> a / b;

        // 输出结果
        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        GreetingService greetService1 = message -> System.out.println("Hello" + message);

        GreetingService greetService2 = message -> System.out.println("Hello" + message);

        greetService1.sayMessage("She");

        greetService2.sayMessage("He");
    }


    interface MathOperation {
        int operate(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation MathOperation) {
        return MathOperation.operate(a, b);
    }
}