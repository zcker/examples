package com.shiyanlou.server;

import com.shiyanlou.server.handler.EchoServerHandler;
import com.shiyanlou.server.handler.HttpServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName HttpServer.java
 * @Description TODO
 * @createTime 2020年08月23日 11:18:00
 */

public class HttpServer {
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
                            channel.pipeline().addLast(new HttpServerCodec());
                            channel.pipeline().addLast(new HttpObjectAggregator(1024 * 1024 * 8));
//                            channel.pipeline().addLast(new EchoServerHandler());
                            channel.pipeline().addLast(new HttpServerHandler());
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
        new HttpServer().bind(8080);
    }
}
