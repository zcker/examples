package com.shiyanlou.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName CalServerHandler.java
 * @Description TODO
 * @createTime 2020年08月14日 09:38:00
 */

public class CalServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("新连接");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        byte[] data = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(data);
        String body = new String(data, "utf-8");
        System.out.println("收到计算公式" + body);
        ByteBuf response = Unpooled.buffer();
        Pattern pattern = Pattern.compile("^(\\d+)([+\\-*/])(\\d+)$");
        Matcher matcher = pattern.matcher(body);
        double result = 0;
        if (matcher.find()) {
            Double num1 = Double.valueOf(matcher.group(1));
            Double num2 = Double.valueOf(matcher.group(3));
            String symbol = matcher.group(2);
            switch (symbol) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
            }
        } else {
            System.out.println("公式错误");
        }
        response.writeBytes((result + " ").getBytes());
        ctx.writeAndFlush(response);
    }
}
