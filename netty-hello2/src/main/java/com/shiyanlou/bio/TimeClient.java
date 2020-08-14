package com.shiyanlou.bio;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName TimeClient.java
 * @Description TODO
 * @createTime 2020年08月12日 09:05:00
 */

public class TimeClient {
    public void connect(String ip, int port) {
        try (Socket socket = new Socket(ip, port);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             ){
            while (true){
                System.out.println("输入要发送的数据");
                String input = new Scanner(System.in).nextLine();
                writer.write(input);
                writer.newLine();
                writer.flush();
                String response=reader.readLine();
                System.out.println("接收"+response);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TimeClient().connect("127.0.0.1",8989);
    }
}
