package com.shiyanlou.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName ByteBufAutoCapacity.java
 * @Description TODO
 * @createTime 2020年08月24日 09:52:00
 */

public class ByteBufAutoCapacity {
    public static void main(String[] args) {
        //分配一个ByteBuf对象，默认容量为4
        ByteBuf buffer = Unpooled.buffer(4);
        //打印容量大小
        System.out.println(buffer.capacity());
        //写入4个字节
        buffer.writeBytes(new byte[]{1, 2, 3, 4});
        //再写入1个字节
        buffer.writeByte(5);
        //打印容量大小
        System.out.println(buffer.capacity());
    }
}
