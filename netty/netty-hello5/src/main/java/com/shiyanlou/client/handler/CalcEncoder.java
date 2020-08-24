package com.shiyanlou.client.handler;

import com.shiyanlou.server.handler.CalcBean;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName CalcEncoder.java
 * @Description TODO
 * @createTime 2020年08月16日 09:22:00
 */

public class CalcEncoder extends MessageToByteEncoder<CalcBean> {
    @Override
    protected void encode(ChannelHandlerContext ctx, CalcBean msg, ByteBuf out) throws Exception {
        byte[] content = (msg.getNum1() + msg.getSymbol() + msg.getNum2()).getBytes();
        out.writeInt(content.length);
        out.writeBytes(content);
    }
}
