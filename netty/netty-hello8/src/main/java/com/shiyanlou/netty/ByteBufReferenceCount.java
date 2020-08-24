package com.shiyanlou.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName ByteBufReferenceCount.java
 * @Description TODO
 * @createTime 2020年08月24日 09:53:00
 */

public class ByteBufReferenceCount {
    public static void main(String[] args) {
        //通过内存池分配一个使用引用计数管理生命周期的ByteBuf
        ByteBuf buffer = PooledByteBufAllocator.DEFAULT.buffer();
        //初始化引用计数为1
        System.out.println(buffer.refCnt());
        //模拟buffer使用
        buffer.writeByte(1);
        buffer.readByte();
        //回收
        buffer.release();
        //也可以使用ReferenceCountUtil工具类回收
        //ReferenceCountUtil.release(buffer);

        //当引用计数为0，对象被回收
        System.out.println(buffer.refCnt());
        //当引用计数为0时，对象不可用，调用任何读写操作都会抛出异常
        buffer.writeByte(1);
    }
}
