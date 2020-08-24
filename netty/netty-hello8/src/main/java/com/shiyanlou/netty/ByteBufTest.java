package com.shiyanlou.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName ByteBufTest.java
 * @Description TODO
 * @createTime 2020年08月24日 09:43:00
 */

public class ByteBufTest {
    public static void main(String[] args) {
        ByteBuf buffer = Unpooled.buffer();
        buffer.writeByte(1);
        buffer.writeBytes(new byte[]{2, 3, 4, 5, 6});
        //把所有可读字节读取出来
        while (buffer.isReadable()) {
            System.out.print(buffer.readByte() + "\t");
        }
        System.out.println();

        //写入字节
        buffer.writeByte(1);
        buffer.writeByte(2);
        buffer.writeByte(3);
        //将可读字节全部读取到字节数组中
        byte[] bytes = new byte[buffer.readableBytes()];
        buffer.readBytes(bytes);
        for (byte b : bytes) {
            System.out.print(b + "\t");
        }
    }
}

