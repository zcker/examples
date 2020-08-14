package com.zcker.example.easyJDK.IO;

import java.io.*;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName test1.java
 * @Description TODO
 * @createTime 2020年08月10日 10:07:00
 */

public class test1 {
    public static void main(String[] args) {
        try {
            File inFile = new File("D:\\ProjectX\\src\\main\\file1.txt");
            File outFile = new File("D:\\ProjectX\\src\\main\\file2.txt");
            FileInputStream fis = new FileInputStream(inFile);
            FileOutputStream fos = new FileOutputStream(outFile);
            int c;
            while ((c = fis.read()) != -1) {
                fos.write(c);
            }
            fis.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
