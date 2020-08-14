package com.zcker.example.easyJDK.IO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName test.java
 * @Description TODO
 * @createTime 2020年08月10日 09:59:00
 */

public class test {
    public void copy(InputStream in, OutputStream out) throws IOException {
        byte[] buf = new byte[4096];
        int len = in.read(buf);
        while (len != -1) {
            out.write(buf, 0, len);
            len = in.read(buf);
        }
    }

    public static void main(String[] args) throws IOException {
        test t = new test();
        System.out.println("输出");
        t.copy(System.in, System.out);
    }
}
