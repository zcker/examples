package com.shiyanlou.server;

import com.shiyanlou.bean.CalcRequestProto;
import com.shiyanlou.server.handler.ProtoCalcServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName ProtoCalcServer.java
 * @Description TODO
 * @createTime 2020年08月18日 09:47:00
 */

public class ProtoCalcServer {
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
                            channel.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
                            channel.pipeline().addLast(new ProtobufEncoder());
                            channel.pipeline().addLast(new ProtobufVarint32FrameDecoder());
                            channel.pipeline().addLast(new ProtobufDecoder(CalcRequestProto.CalcRequest.getDefaultInstance()));
                            channel.pipeline().addLast(new ProtoCalcServerHandler());
                        }
                    });
            ChannelFuture f = bootstrap.bind(port).sync();
            System.out.println("服务器启动");
            f.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            boosGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new ProtoCalcServer().bind(9999);
    }
}
