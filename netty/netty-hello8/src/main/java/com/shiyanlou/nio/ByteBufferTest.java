package com.shiyanlou.nio;

import java.nio.ByteBuffer;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName ByteBufferTest.java
 * @Description TODO
 * @createTime 2020年08月24日 08:54:00
 */

public class ByteBufferTest {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(8192);
        buffer.put((byte) 1);
        buffer.put(new byte[]{2, 3, 4, 5, 6});
        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get() + "\t");
        }
        System.out.println();
        buffer.clear();
        buffer.put((byte) 1);
        buffer.put((byte) 2);
        buffer.put((byte) 3);
        buffer.flip();
        byte[] bytes = new byte[buffer.remaining()];
        buffer.get(bytes);
        for (byte b : bytes) {
            System.out.println(b + "\t");
        }
    }
}
