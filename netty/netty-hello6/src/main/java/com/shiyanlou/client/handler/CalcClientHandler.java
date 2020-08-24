package com.shiyanlou.client.handler;

import com.shiyanlou.bean.CalcRequest;
import com.shiyanlou.bean.CalcResponse;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Scanner;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName CalcClientHandler.java
 * @Description TODO
 * @createTime 2020年08月16日 16:31:00
 */

public class CalcClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        CalcRequest calcRequest = new CalcRequest();
        //提示客户端输入待计算的数字和符号
        System.out.print("请输入第一个数字：");
        Scanner scanner = new Scanner(System.in);
        calcRequest.setNum1(scanner.nextInt());
        System.out.print("请输入计算符号：");
        calcRequest.setSymbol(scanner.next());
        System.out.print("请输入第二个数字：");
        calcRequest.setNum2(scanner.nextInt());
        //将对象直接输出，通过自定义编码器处理对应的编码逻辑
        ctx.writeAndFlush(calcRequest);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        CalcResponse response = (CalcResponse) msg;
        System.out.println("接收结果" + response.getResult());
        System.out.println("y/n");
        String flag = new Scanner(System.in).next();
        if ("Y".equalsIgnoreCase(flag)) {
            channelActive(ctx);
        } else {
            System.out.println("客户端关闭");
            ctx.close();
        }
    }
}
