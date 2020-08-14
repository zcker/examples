package com.zcker.example.easyJDK.IO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName test3.java
 * @Description TODO
 * @createTime 2020年08月10日 22:00:00
 */

public class test3 {
    public static void main(String[] args) {
        int data_arr[] = {12, 32, 43, 45, 1, 5};
        try {
            RandomAccessFile randf = new RandomAccessFile("temp.dat", "rw");
            for (int i = 0; i < data_arr.length; i++) {
                randf.writeInt(data_arr[i]);
            }
            for (int i = data_arr.length - 1; i >= 0; i--) {
                randf.seek(i * 4L);
                System.out.println(randf.readInt());
            }
            randf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
