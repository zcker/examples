package com.zcker.example.easyJDK.lang;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName Example4.java
 * @Description TODO
 * @createTime 2020年08月02日 17:37:00
 */

public class Example4 {
    public static void main(String[] args) {
//        String s = new String("Java");
//        String m = "java";
//        System.out.println("用 equals() 比较，java 和 Java 结果为"+s.equals(m));
//        System.out.println("用 equalsIgnoreCase() 比较，java 和 Java 结果为"+s.equalsIgnoreCase(m));
//
//        String s0 = new String("Hello ");
//        String s1 = "World" + "!";   //+号连接
//        String s2 = s0.concat(s1); //concat() 方法连接
//        System.out.println(s2);
//
//        String s8 = "abc";
//        char c = s8.charAt(1);
//        System.out.println(c);

//        String s = "abcdefabc";
//        System.out.println("字符 a 第一次出现的位置为"+s.indexOf('a'));
//        System.out.println("字符串 bc 第一次出现的位置为"+s.indexOf("bc"));
//        System.out.println("字符 a 最后一次出现的位置为"+s.lastIndexOf('a'));
//        System.out.println("从位置 3 开始到结束的字符串"+s.substring(3));
//        System.out.println("从位置 3 开始到 6 之间的字符串"+s.substring(3,6));


//        String s = "Hello ";
//        s.concat("World!");   //字符串连接
//        System.out.println(s); //输出 s，还是"Hello"
//        s = s.concat("World!");  //把字符串对象连接的结果赋给了 s 引用
//        System.out.println(s);  //输出 s，变成了"Hello World!"
/*
上述三条语句其实产生了 3 个 String 对象，"Hello "，"World!"，"Hello World!"。
第 2 条语句确实产生了"Hello World"字符串，但是没有指定把该字符串的引用赋给谁，
因此没有改变 s 引用。第 3 条语句根据不变性，并没有改变"Hello "，
JVM 创建了一个新的对象，把"Hello "，"World!"的连接赋给了 s 引用，因此引用变了，
但是原对象没变。
*/

//        StringBuffer s = new StringBuffer("I");
//        s.append(" Java");
//        s.insert(1," love");
//        String t = s.toString();
//        System.out.println(t);
    }
}
