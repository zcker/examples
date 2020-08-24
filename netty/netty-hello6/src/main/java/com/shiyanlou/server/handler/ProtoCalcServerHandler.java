package com.shiyanlou.server.handler;

import io.netty.channel.ChannelInboundHandlerAdapter;
import com.shiyanlou.bean.CalcRequestProto;
import com.shiyanlou.bean.CalcResponseProto;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName ProtoCalcServerHandler.java
 * @Description TODO
 * @createTime 2020年08月23日 09:50:00
 */

public class ProtoCalcServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("有新的客户端连接至服务器");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //拿到上一个handle返回的对象
        CalcRequestProto.CalcRequest calcRequest = (CalcRequestProto.CalcRequest) msg;
        double result = 0;
        double num1 = calcRequest.getNum1();
        double num2 = calcRequest.getNum2();
        //根据符号进行相应的计算
        switch (calcRequest.getSymbol()) {
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
        //将计算结果写入到客户端
        ctx.writeAndFlush(CalcResponseProto.CalcResponse.newBuilder()
                .setResult(result)
                .build());
    }
}
