package com.shiyanlou.server.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class CalcServerHandler extends ChannelInboundHandlerAdapter {

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    System.out.println("有新的客户端连接至服务器");
  }

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    //拿到上一个handle返回的对象
    CalcBean calcBean = (CalcBean) msg;
    double result = 0;
    double num1 = calcBean.getNum1();
    double num2 = calcBean.getNum2();
    //分配一个ByteBuf对象
    ByteBuf response = Unpooled.buffer();
      //根据符号进行相应的计算
    switch (calcBean.getSymbol()) {
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
    //将计算结果写入到ByteBuf中
    response.writeBytes((result + System.lineSeparator()).getBytes());
    //把消息返回到客户端
    ctx.writeAndFlush(response);
  }
}
