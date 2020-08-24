package com.shiyanlou.server.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName CalcDecoder.java
 * @Description TODO
 * @createTime 2020年08月15日 22:23:00
 */

public class CalcDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() < 4) {
            return;
        }
        int contentLength = in.readInt();
        if (in.readableBytes() < contentLength) {
            in.readerIndex(in.readerIndex() - 4);
            return;
        }
        byte[] content = new byte[contentLength];
        in.readBytes(content);
        Pattern pattern = Pattern.compile("^(\\d+)([+\\-*/])(\\d+)$");
        Matcher matcher = pattern.matcher(new String(content));
        if (matcher.find()) {
            int num1 = Integer.valueOf(matcher.group(1));
            String symbol = matcher.group(2);
            int num2 = Integer.valueOf(matcher.group(3));
            CalcBean calcBean = new CalcBean();
            calcBean.setNum1(num1);
            calcBean.setNum2(num2);
            calcBean.setSymbol(symbol);
            System.out.println("收到请求" + calcBean.toString());
            out.add(calcBean);
        }
    }
}
