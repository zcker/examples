package com.shiyanlou.codec;

import com.caucho.hessian.io.Hessian2Output;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName HessianEncoder.java
 * @Description TODO
 * @createTime 2020年08月23日 10:16:00
 */

public class HessianEncoder extends MessageToByteEncoder {
    private static final byte[] LENGTH_PLACEHOLDER = new byte[4];

    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        int startIdx = out.writerIndex();
        out.writeBytes(LENGTH_PLACEHOLDER);
        Hessian2Output hessian2Output = null;
        try {
            hessian2Output = new Hessian2Output(new ByteBufOutputStream(out));
            hessian2Output.writeObject(msg);
            hessian2Output.flush();
        } finally {
            if (hessian2Output != null) {
                hessian2Output.close();
            }
        }
        int endIdx = out.writerIndex();
        out.setInt(startIdx, endIdx - startIdx - LENGTH_PLACEHOLDER.length);
    }
}
