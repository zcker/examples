package com.zcker.example.easyJDK.lang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName SetTest.java
 * @Description TODO
 * @createTime 2020年08月08日 09:44:00
 */

public class SetTest {
    public List<Student> students;

    public SetTest() {
        students = new ArrayList<Student>();
    }

    public void testAdd() {
        Student st1 = new Student("1", "张三");
        students.add(st1);

        Student st2 = new Student("2", "李四");
        students.add(st2);

        Student[] student = {new Student("3", "王五"), new Student("4", "马六")};
        students.addAll(Arrays.asList(student));

        Student[] student2 = {new Student("5", "王五"), new Student("6", "赵八")};
        students.addAll(Arrays.asList(student2));

    }

    public void testForEach() {
        System.out.println("for输出");
        for (Object obj : students) {
            Student student = (Student) obj;
            System.out.println("学生" + student.id + ":" + student.name);
        }
    }

    public static void main(String[] args) {
        SetTest st = new SetTest();
        st.testAdd();
        st.testForEach();
        PD pd = new PD("1", "詹老师");
        System.out.println(pd.name+"选择");
        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<3;i++){
            System.out.println("输入ID");
            String stuID = scanner.next();
            for (Student s:st.students){
                if(s.id.equals(stuID)){
                    pd.students.add(s);
                }
            }
        }
        System.out.println(pd.students);
        st.testForEachForSer(pd);
        scanner.close();

    }
    
    public void testForEachForSer(PD pd) {
        for (Student s : pd.students) {
            System.out.println("选择" + s.id + ":" + s.name);
        }
    }
}
