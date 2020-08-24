package com.shiyanlou.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;

import java.nio.charset.Charset;
import java.util.Map;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName EchoServerHandler.java
 * @Description TODO
 * @createTime 2020年08月23日 11:31:00
 */

public class EchoServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {
        String method = msg.method().name();
        String uri = msg.uri();
        String version = msg.protocolVersion().text();
        HttpHeaders headers = msg.headers();
        String content = msg.content().toString(Charset.defaultCharset());

        StringBuilder body = new StringBuilder();
        body.append("<html>");
        body.append("<body>");
        body.append(method + " " + uri + " " + version + "</br>");

        //遍历请求头
        for (Map.Entry<String, String> entry : headers.entries()) {
            body.append(entry.getKey() + ": " + entry.getValue() + "</br>");
        }
        //分割请求头和请求体
        body.append("</br>");
        body.append(content);
        body.append("</body>");
        body.append("</html>");

        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);
        response.headers().set(HttpHeaderNames.CONTENT_LENGTH,
                body.toString().getBytes().length);
        response.content().writeBytes(body.toString().getBytes());
        ctx.writeAndFlush(response);
    }
}
