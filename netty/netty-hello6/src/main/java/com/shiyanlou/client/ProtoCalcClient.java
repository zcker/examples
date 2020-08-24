package com.shiyanlou.client;

import com.shiyanlou.bean.CalcResponseProto;
import com.shiyanlou.client.handler.ProtoCalcClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName ProtoCalcClient.java
 * @Description TODO
 * @createTime 2020年08月23日 09:52:00
 */

public class ProtoCalcClient {
    public void connect(String host, int port) {
        NioEventLoopGroup loopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap()
                    .group(loopGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer() {
                        @Override
                        protected void initChannel(Channel channel) throws Exception {
                            channel.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
                            channel.pipeline().addLast(new ProtobufEncoder());
                            channel.pipeline().addLast(new ProtobufVarint32FrameDecoder());
                            channel.pipeline().addLast(new ProtobufDecoder(CalcResponseProto.CalcResponse.getDefaultInstance()));
                            channel.pipeline().addLast(new ProtoCalcClientHandler());
                        }
                    });
            ChannelFuture f = bootstrap.connect(host, port).sync();
            f.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ProtoCalcClient().connect("127.0.0.1", 9999);
    }
}
