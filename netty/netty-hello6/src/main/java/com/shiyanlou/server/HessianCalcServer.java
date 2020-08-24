package com.shiyanlou.server;

import com.shiyanlou.codec.HessianEncoder;
import com.shiyanlou.codec.HessionDecoder;
import com.shiyanlou.server.handler.CalcServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName HessianCalcServer.java
 * @Description TODO
 * @createTime 2020年08月23日 10:49:00
 */

public class HessianCalcServer {
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
                            channel.pipeline().addLast(new HessianEncoder());
                            channel.pipeline().addLast(new HessionDecoder());
                            channel.pipeline().addLast(new CalcServerHandler());
                        }
                    });
            ChannelFuture f = bootstrap.bind(port).sync();
            System.out.println("启动成功");
            f.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new HessianCalcServer().bind(9988);
    }
}
