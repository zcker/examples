package com.shiyanlou.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName TimeServer.java
 * @Description TODO
 * @createTime 2020年08月11日 16:49:00
 */

public class TimeServer {
    public void bind(int port) {
        try (
                //启动tcp服务器并监听指定端口
                ServerSocket serverSocket = new ServerSocket(port)
        ) {
            System.out.println("服务器启动成功");
            //通过死循环来监听客户端连接
            while (true) {
                System.out.println("等待客户端连接");
                //accept方法会阻塞到有客户端连接进来
                Socket socket = serverSocket.accept();
                System.out.println("客户端连接成功");
                //开启一个线程去处理对应的客户端连接
                new Thread(new TimeServerHandle(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class TimeServerHandle implements Runnable {
        private Socket socket;

        public TimeServerHandle(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            ) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("收到客户端数据"+line);
                    if (line.equalsIgnoreCase("Get Date")){
                        writer.write(new Date().toString());
                    }else {
                        writer.write("Bad Request");
                    }
                    writer.newLine();
                    writer.flush();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

  public static void main(String[] args) {
      //启动服务器
      new TimeServer().bind(8989);
  }
}
