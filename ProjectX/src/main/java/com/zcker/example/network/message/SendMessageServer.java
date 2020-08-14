/*
 * Created by JFormDesigner on Sun Aug 02 13:12:03 CST 2020
 */

package com.zcker.example.network.message;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Chengkai Zhang
 */
public class SendMessageServer extends JFrame {
    //声明一个显示纯文本的多行区域
    private ServerSocket server;
    //声明一个ServerSocket对象
    private Socket socket;
    //声明一个Socket对象
    private BufferedReader reader;

    public SendMessageServer() {
        initComponents();
    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Chengkai Zhang
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        button1 = new JButton();

        //======== this ========
        setTitle("Server");
        Container contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textArea1);
        }

        //---- button1 ----
        button1.setText("text");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
                    .addGap(38, 38, 38)
                    .addComponent(button1)
                    .addContainerGap(40, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(52, 52, 52)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(99, 99, 99)
                            .addComponent(button1)))
                    .addContainerGap(68, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Chengkai Zhang
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args) {
        try {
            SendMessageServer sendMessageServer = new SendMessageServer();
            sendMessageServer.setVisible(true);
            sendMessageServer.getServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getServer() {
        try {
            server = new ServerSocket(2015);
            getTextArea1().append("Server socket created successfully.\n");
            while (true) {
                getTextArea1().append("Waiting for connection from client...\n");
                socket = server.accept();
                getTextArea1().append("Connected successfully !\n");
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                //实例化BufferedReader对象
                getClientInfo();
                //调用getClientInfo()方法
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getClientInfo() {
        try {
            getTextArea1().append("Info fome client: " + reader.readLine() + "\n");
            //获得客户端传来的信息
        } catch (Exception e) {
            getTextArea1().append("Client is offline. \n");
            //输出异常信息
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                    //关闭流
                }
                if (socket != null) {
                    socket.close();
                    //关闭套接字连接
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public JTextArea getTextArea1() {
        return textArea1;
    }

    public void setTextArea1(JTextArea textArea1) {
        this.textArea1 = textArea1;
    }

    public JButton getButton1() {
        return button1;
    }

    public void setButton1(JButton button1) {
        this.button1 = button1;
    }
}
