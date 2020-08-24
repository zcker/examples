package com.shiyanlou.client;

import com.shiyanlou.client.handler.CalcClientHandler;
import com.shiyanlou.codec.HessianEncoder;
import com.shiyanlou.codec.HessionDecoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName HessianCalcClient.java
 * @Description TODO
 * @createTime 2020年08月23日 10:54:00
 */

public class HessianCalcClient {
    public void connect(String host, int port) {
        NioEventLoopGroup loopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap()
                    .group(loopGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer() {
                        @Override
                        protected void initChannel(Channel channel) throws Exception {
                            channel.pipeline().addLast(new HessianEncoder());
                            channel.pipeline().addLast(new HessionDecoder());
                            channel.pipeline().addLast(new CalcClientHandler());
                        }
                    });
            ChannelFuture f = bootstrap.connect(host, port).sync();
            f.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            loopGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new HessianCalcClient().connect("127.0.0.1",9988);
    }
}
