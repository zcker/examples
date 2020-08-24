package com.shiyanlou.codec;

import com.caucho.hessian.io.Hessian2Input;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName HessionDecoder.java
 * @Description TODO
 * @createTime 2020年08月23日 10:26:00
 */

public class HessionDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() < 4) {
            in.resetReaderIndex();
            return;
        }
        int contentLength = in.readInt();
        if (in.readableBytes() < contentLength) {
            in.readerIndex(in.readerIndex() - 4);
            return;
        }
        Hessian2Input hessian2Input = null;
        try {
            hessian2Input = new Hessian2Input(new ByteBufInputStream(in));
            Object object = hessian2Input.readObject();
            out.add(object);
        } finally {
            if (hessian2Input != null) {
                hessian2Input.close();
            }
        }
    }
}
