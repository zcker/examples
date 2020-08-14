/*
 * Created by JFormDesigner on Sun Aug 02 13:11:45 CST 2020
 */

package com.zcker.example.network.message;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Chengkai Zhang
 */
public class SendMessageClient extends JFrame {
    private Socket socket;
    //声明一个Socket对象

    private PrintWriter writer;

    public SendMessageClient() {
        initComponents();
    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
        try {
            writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println(textField1.getText());
            getTextArea1().append("Info entered: " + textField1.getText() + "\n");
            textField1.setText("");
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Chengkai Zhang
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        button1 = new JButton();
        textField1 = new JTextField();

        //======== this ========
        setTitle("Client");
        Container contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textArea1);
        }

        //---- button1 ----
        button1.setText("\u53d1\u9001");
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
                    .addGap(36, 36, 36)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                    .addComponent(button1)
                    .addGap(45, 45, 45))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(button1)
                            .addGap(116, 116, 116))))
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
    private JTextField textField1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args) {
        SendMessageClient sendMessageClient = new SendMessageClient();
        sendMessageClient.setVisible(true);
        sendMessageClient.connect();
    }

    private void connect() {
        //编写一个连接套接字的方法

        getTextArea1().append("Try to connect server...\n");
        //在文本区域中输出信息：尝试连接服务器
        try {
            //记得捕捉可能发生的异常
            socket = new Socket("127.0.0.1", 2015);
            //实例化Socket对象，设定的IP地址为本地回环地址，端口号为2015
            getTextArea1().append("Connect completed.\n");
            //在文本区域中输出信息：连接完成
            InetAddress serverAddress = socket.getInetAddress();
            //从连接的socket中，获得服务器的IP地址，类型为InetAddress对象
            String serverIP = serverAddress.getHostAddress();
            //获得远服务器的IP地址，存入serverIP变量中
            int serverPort = socket.getPort();
            //获得服务器的端口号，类型为int
            InetAddress localAddress = socket.getLocalAddress();
            //获得客户端的地址，类型为InetAddress对象
            String clientIP = localAddress.getHostAddress();
            //获得客户端的IP地址，存入clientIP变量中
            int clientPort = socket.getLocalPort();
            //获得客户端的端口号，类型为int

            getTextArea1().append("Server IP: " + serverIP + "\n");
            getTextArea1().append("Server Port: " + serverPort + "\n");
            getTextArea1().append("Client IP: " + clientIP + "\n");
            getTextArea1().append("Client Port: " + clientPort + "\n");
            //将上述内容追加在文本域中显示出来

        } catch (Exception e) {
            e.printStackTrace();
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

    public JTextField getTextField1() {
        return textField1;
    }

    public void setTextField1(JTextField textField1) {
        this.textField1 = textField1;
    }
}
