package com.zcker.example.easyJDK.lang;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName PD.java
 * @Description TODO
 * @createTime 2020年08月08日 09:41:00
 */

public class PD {
    public String id;
    public String name;
    public Set<Student> students;

    public PD(String id, String name) {
        this.id = id;
        this.name = name;
        this.students = new HashSet<Student>();
    }
}
