package com.shiyanlou.client.handler;

import com.shiyanlou.bean.CalcRequestProto;
import com.shiyanlou.bean.CalcResponseProto;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Scanner;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName ProtoCalcClientHandler.java
 * @Description TODO
 * @createTime 2020年08月23日 10:03:00
 */

public class ProtoCalcClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        CalcRequestProto.CalcRequest.Builder builder = CalcRequestProto.CalcRequest.newBuilder();
        //提示客户端输入待计算的数字和符号
        System.out.print("请输入第一个数字：");
        Scanner scanner = new Scanner(System.in);
        builder.setNum1(scanner.nextInt());
        System.out.print("请输入计算符号：");
        builder.setSymbol(scanner.next());
        System.out.print("请输入第二个数字：");
        builder.setNum2(scanner.nextInt());
        //将对象直接输出，通过自定义编码器处理对应的编码逻辑
        ctx.writeAndFlush(builder.build());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        CalcResponseProto.CalcResponse response = (CalcResponseProto.CalcResponse) msg;
        System.out.println("接收到计算结果" + response.getResult());
        System.out.println("继续Y/N");
        String flag = new Scanner(System.in).next();
        if ("Y".equalsIgnoreCase(flag)) {
            channelActive(ctx);
        } else {
            System.out.println("客户端关闭");
            ctx.close();
        }
    }
}
