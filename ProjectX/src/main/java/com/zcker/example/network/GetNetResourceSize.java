package com.zcker.example.network;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author zcker
 * @version 1.0.0
 * @ClassName GetNetResourceSize.java
 * @Description TODO
 * @createTime 2020年08月01日 22:20:00
 */

public class GetNetResourceSize extends JFrame {
    private JTextField textField_size;
    private JTextField textField_url;

    public static void main(String[] args) {
        try {
            GetNetResourceSize frame = new GetNetResourceSize();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public GetNetResourceSize() {
        super();

        setTitle("Get the size of resource from Internet");
        getContentPane().setLayout(null);
        setBounds(200, 200, 400, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JLabel label_title = new JLabel();
        label_title.setForeground(Color.GREEN);
        label_title.setFont(new Font("", Font.BOLD, 20));
        label_title.setText("Get the size of resource from Internet");
        label_title.setBounds(5, 5, 400, 5);

        final JLabel label_title_url = new JLabel();
        label_title_url.setText("Enter URL");
        label_title_url.setBounds(10, 80, 80, 25);

        final JLabel label_title_size = new JLabel();
        label_title_size.setText("Size: ");
        label_title_size.setBounds(10, 125, 125, 25);

        textField_url = new JTextField();
        textField_url.setBounds(80, 80, 286, 25);

        textField_size = new JTextField();
        textField_size.setBounds(80, 125, 145, 25);
        //同上

        final JButton button = new JButton();
        //声明并实例化了一个按钮，用于执行获取资源大小的操作
        button.setText("Get the size");
        //设置按钮上要显示的文字
        button.setBounds(235, 125, 135, 25);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                String url = textField_url.getText().trim();
                try {
                    long len = resourceSize(url);
                    textField_size.setText(String.valueOf(len) + "byte(s)");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        getContentPane().add(label_title);
        getContentPane().add(label_title_url);
        getContentPane().add(label_title_size);
        getContentPane().add(textField_url);
        getContentPane().add(textField_size);
        getContentPane().add(button);
    }

    public long resourceSize(String sUrl) throws Exception {
        URL url = new URL(sUrl);
        URLConnection urlConn = url.openConnection();
        urlConn.connect();
        return urlConn.getContentLength();
    }
}
