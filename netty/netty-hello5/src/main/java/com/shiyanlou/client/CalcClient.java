package com.shiyanlou.client;

import com.shiyanlou.client.handler.CalcClientHandler;
import com.shiyanlou.client.handler.CalcEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class CalcClient {

    public void connect(String host, int port) {
        NioEventLoopGroup loopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap().group(loopGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer() {
                        @Override
            protected void initChannel(Channel channel) throws Exception {

              //添加自定义编码器用于CalcBean对象的编码
              channel.pipeline().addLast(new CalcEncoder());
              channel.pipeline().addLast(new CalcClientHandler());
                        }
                    });

            //指定服务器IP和端口发起连接
            ChannelFuture f = bootstrap.connect(host, port).sync();
            //阻塞当前线程，直到客户端关闭
            f.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //客户端优雅关闭
            loopGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new CalcClient().connect("127.0.0.1", 9999);
    }
}
