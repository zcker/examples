package com.zcker.example.easyJDK.lang;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName MapTest.java
 * @Description TODO
 * @createTime 2020年08月08日 10:07:00
 */

public class MapTest {
    public Map<String, Course> courses;

    public MapTest() {
        this.courses = new HashMap<String, Course>();
    }

    public void testPut() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("课程ID");
            String ID = scanner.next();
            Course course = courses.get(ID);
            if (course == null) {
                System.out.println("输入课程名称");
                String name = scanner.next();
                Course newCourse = new Course(ID, name);
                courses.put(ID, newCourse);
                System.out.println("添加" + courses.get(ID).name);
            } else {
                System.out.println("ID 有了");
                continue;
            }
        }
    }

    public void testKeySet() {
        Set<String> keySet = courses.keySet();
        for (String crID : keySet) {
            Course cr = courses.get(crID);
            if (cr != null) {
                System.out.println("课程：" + cr.name);
            }
        }
    }

    public void testRemove() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("输入删除的ID");
            String ID = scanner.next();
            Course cr = courses.get(ID);

            if (cr == null) {
                System.out.println("ID 不存在");
                continue;
            }
            courses.remove(ID);
            System.out.println("成功删除" + cr.name);
            break;
        }
    }

    public void testEntrySet() {
        Set<Map.Entry<String, Course>> entrySet = courses.entrySet();
        for (Map.Entry<String, Course> entry : entrySet) {
            System.out.println("取得键"+entry.getKey());
            System.out.println("对应值"+entry.getValue().name);
        }
    }

    public void testModify(){
        System.out.println("要修改的ID");
        Scanner scanner = new Scanner(System.in);
        while (true){
            String crID = scanner.next();
            Course course = courses.get(crID);
            if(course==null){
                System.out.println("false");
                continue;
            }
            System.out.println("名称"+course.name);
            System.out.println("输入新的");
            String name = scanner.next();
            Course newCourse = new Course(crID, name);
            courses.put(crID,newCourse);
            System.out.println("修改成功");
            break;
        }
    }

    public static void main(String[] args) {
        MapTest mt = new MapTest();
        mt.testPut();
        mt.testKeySet();
        mt.testRemove();
        mt.testModify();
        mt.testEntrySet();

    }
}
