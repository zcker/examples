package com.shiyanlou.server;

import com.shiyanlou.server.handler.CalcServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;

public class CalcServer {

  public void bind(int port) {
    NioEventLoopGroup boosGroup = new NioEventLoopGroup();
    NioEventLoopGroup workerGroup = new NioEventLoopGroup();
    try {
      ServerBootstrap bootstrap = new ServerBootstrap()
          .group(boosGroup, workerGroup)
          .channel(NioServerSocketChannel.class)
          .childHandler(new ChannelInitializer() {

            @Override
            protected void initChannel(Channel channel) throws Exception {

              //使用换行符来分割业务数据
              channel.pipeline().addLast(new LineBasedFrameDecoder(1024));
              //自定义计算器handler类
              channel.pipeline().addLast(new CalcServerHandler());
            }
          });
      ChannelFuture f = bootstrap.bind(port).sync();
      System.out.println("服务器启动成功");
      f.channel().closeFuture().sync();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      boosGroup.shutdownGracefully();
      workerGroup.shutdownGracefully();
    }
  }

  public static void main(String[] args) {
    new CalcServer().bind(10086);
  }
}
