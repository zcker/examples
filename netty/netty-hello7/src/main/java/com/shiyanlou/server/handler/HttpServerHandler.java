package com.shiyanlou.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.AsciiString;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName HttpServerHandler.java
 * @Description TODO
 * @createTime 2020年08月23日 21:45:00
 */

public class HttpServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {
        String uri = msg.uri();
        if (uri.equals("/")) {
            uri = "/index.html";
        }

        FullHttpResponse response;
        URL resource = Thread.currentThread().getContextClassLoader().getResource(uri.substring(1));
        try {
            if (resource != null) {
                response = buildResponse(uri, HttpResponseStatus.OK);
            } else {
                uri = "/404.html";
        response = buildResponse(uri, HttpResponseStatus.NOT_FOUND);
            }
    } catch (IOException e) {
            e.printStackTrace();
            uri = "/500.html";
            response = buildResponse(uri, HttpResponseStatus.INTERNAL_SERVER_ERROR);
        }
        buildContentType(response, uri);
    //写出到客户端
    ctx.writeAndFlush(response);
    }

    /**
     * 通过uri来读取对应的文件，构造FullHttpResponse对象
     *
     * @param uri
     */
    private FullHttpResponse buildResponse(String uri, HttpResponseStatus status) throws IOException {
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, status);
        //读取本地文件
        try (
                InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(uri.substring(1))
        ) {
            int contentLength = inputStream.available();
            //将读取的文件流写入到响应体中
            response.content().writeBytes(inputStream, contentLength);
            //响应头长度写入
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, contentLength);
        }
        return response;
    }

    /**
     * 根据uri后缀设置对应的Content-Type响应头
     *
     * @param httpResponse
     * @param uri
     */
    private void buildContentType(FullHttpResponse httpResponse, String uri) {
        int index = uri.lastIndexOf(".");
        //取后缀名
        String mime = index == -1 ? "" : uri.substring(index + 1);
        //根据后缀名生成对应的Content-Type
        if (mime != null) {
            AsciiString contentType;
            switch (mime) {
                case "txt":
                case "text":
                    contentType = AsciiString.cached("text/plain; charset=utf-8");
                    break;
                case "html":
                case "htm":
                    contentType = AsciiString.cached("text/html; charset=utf-8");
                    break;
                case "css":
                    contentType = AsciiString.cached("text/css; charset=utf-8");
                    break;
                case "js":
                    contentType = AsciiString.cached("application/javascript; charset=utf-8");
                    break;
                case "png":
                    contentType = AsciiString.cached("image/png");
                    break;
                case "jpg":
                case "jpeg":
                    contentType = AsciiString.cached("image/jpeg");
                    break;
                case "bmp":
                    contentType = AsciiString.cached("application/x-bmp");
                    break;
                case "gif":
                    contentType = AsciiString.cached("image/gif");
                    break;
                case "ico":
                    contentType = AsciiString.cached("image/x-icon");
                    break;
                case "ttf":
                    contentType = AsciiString.cached("font/ttf; charset=utf-8");
                    break;
                case "woff":
                    contentType = AsciiString.cached("application/font-woff; charset=utf-8");
                    break;
                default:
                    contentType = HttpHeaderValues.APPLICATION_OCTET_STREAM;
            }
            httpResponse.headers().set(HttpHeaderNames.CONTENT_TYPE, contentType);
        }
    }
}

