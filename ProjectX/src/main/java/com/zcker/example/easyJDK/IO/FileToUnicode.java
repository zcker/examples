package com.zcker.example.easyJDK.IO;

import java.io.*;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName FileToUnicode.java
 * @Description TODO
 * @createTime 2020年08月10日 20:59:00
 */

public class FileToUnicode {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("D:\\ProjectX\\src\\main\\file1.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                System.out.println("read:" + s);
            }
            inputStreamReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
