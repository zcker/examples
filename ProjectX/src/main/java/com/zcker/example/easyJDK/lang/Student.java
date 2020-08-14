package com.zcker.example.easyJDK.lang;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName Student.java
 * @Description TODO
 * @createTime 2020年08月08日 09:19:00
 */

public class Student {
    public String id;
    public String name;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
