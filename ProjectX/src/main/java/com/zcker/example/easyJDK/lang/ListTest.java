package com.zcker.example.easyJDK.lang;

import java.util.*;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName ListTest.java
 * @Description TODO
 * @createTime 2020年08月08日 09:20:00
 */

public class ListTest {

    //集合后面的<>代表泛型的意思
    //泛型是规定了集合元素的类型
    //我们以后会详细讲到
    /**
     * 用于存放学生的 List
     */
    public List<Student> students;

    public ListTest() {
        this.students = new ArrayList<Student>();
    }

    /**
     * 用于往 students 中添加学生
     */
    public void testAdd() {
        // 创建一个学生对象，并通过调用 add 方法，添加到学生管理 List 中
        Student st1 = new Student("1", "张三");
        students.add(st1);

        // 取出 List 中的 Student 对象
        Student temp = students.get(0);
        System.out.println("添加了学生：" + temp.id + ":" + temp.name);

        Student st2 = new Student("2", "李四");
        students.add(0, st2);
        Student temp2 = students.get(0);
        System.out.println("添加了学生：" + temp2.id + ":" + temp2.name);

        // 对象数组的形式添加
        Student[] student = {new Student("3", "王五"), new Student("4", "马六")};

        // Arrays 类包含用来操作数组（比如排序和搜索）的各种方法，asList() 方法用来返回一个受指定数组支持的固定大小的列表
        students.addAll(Arrays.asList(student));
        Student temp3 = students.get(2);
        Student temp4 = students.get(3);
        System.out.println("添加了学生：" + temp3.id + ":" + temp3.name);
        System.out.println("添加了学生：" + temp4.id + ":" + temp4.name);
        Student[] student2 = {new Student("5", "周七"), new Student("6", "赵八")};
        students.addAll(2, Arrays.asList(student2));
        Student temp5 = students.get(2);
        Student temp6 = students.get(3);
        System.out.println("添加了学生：" + temp5.id + ":" + temp5.name);
        System.out.println("添加了学生：" + temp6.id + ":" + temp6.name);
    }

    public void testGet() {
        int size = students.size();
        for (int i = 0; i < size; i++) {
            Student student = students.get(i);
            System.out.println("学生" + student.id + ":" + student.name);
        }
    }

    public void testIterator() {
        Iterator<Student> iterator = students.iterator();
        System.out.println("Iterator访问");
        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println(student.id + ":" + student.name);
        }
    }

    public void testForEach() {
        System.out.println("for访问");
        for (Student obj : students) {
            Student student = obj;
            System.out.println("学生" + student.id + ":" + student.name);
        }
        students.stream().sorted(Comparator.comparing(x -> x.id)).forEach(System.out::println);
    }

    public void testModify(){
        students.set(4,new Student("3","无酒"));
    }

    public void testRemove(){
        Student student = students.get(4);
        System.out.println(student.id+":"+student.name+"将被删除");
        students.remove(student);
        testForEach();
    }

    public static void main(String[] args) {
        ListTest listTest = new ListTest();
        listTest.testAdd();
        listTest.testGet();
        listTest.testIterator();
        listTest.testModify();
        listTest.testForEach();
        listTest.testRemove();
    }
}
