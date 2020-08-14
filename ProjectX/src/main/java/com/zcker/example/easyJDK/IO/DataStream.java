package com.zcker.example.easyJDK.IO;

import java.io.*;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName DataStream.java
 * @Description TODO
 * @createTime 2020年08月10日 14:20:00
 */

public class DataStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("a.txt");
        DataOutputStream dos = new DataOutputStream(fos);
        try {
            dos.writeBoolean(true);
            dos.writeByte((byte) 233);
            dos.writeChar('j');
            dos.writeDouble(2.544235);
            dos.writeInt(432);
        } finally {
            dos.close();
        }
        FileInputStream fis = new FileInputStream("a.txt");
        DataInputStream dis = new DataInputStream(fis);
        try {
            System.out.println("\t" + dis.readBoolean());
            System.out.println("\t" + dis.readByte());
            System.out.println("\t" + dis.readChar());
            System.out.println("\t" + dis.readDouble());
            System.out.println("\t" + dis.readFloat());
            System.out.println("\t" + dis.readInt());
        }finally {
            dis.close();
        }
    }
}
