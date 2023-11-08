package com.csnobugteam.java.homework.day21.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * b. 客户端文本文件，服务器输出到控制台
 * 在服务器端，接收客户端发送的内容，并将其输出到控制台。
 * @author aixu
 * @since 2023/11/8
 */
public class BServer {
    public static void main(String[] args) {
        try {
            // 创建 ServerSocket 对象，指定监听的端口号
            ServerSocket serverSocket = new ServerSocket(8888);

            System.out.println("服务器已启动，等待客户端的连接...");

            // 监听客户端的连接，返回 Socket 对象
            Socket socket = serverSocket.accept();

            // 获取输入流，用于接收客户端发来的数据
            InputStream inputStream = socket.getInputStream();

            // 创建 BufferedReader 对象，用于读取数据
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            System.out.println("收到客户端发送的内容：");

            // 读取客户端发送的数据，并输出到控制台
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            // 关闭资源
            bufferedReader.close();
            serverSocket.close();
            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
