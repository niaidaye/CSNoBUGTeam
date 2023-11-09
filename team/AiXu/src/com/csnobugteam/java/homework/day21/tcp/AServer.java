package com.csnobugteam.java.homework.day21.tcp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * a. 客户端键盘录入，服务器输出文本文件
 *  在服务器端，接收客户端发送的内容，并将其写入到文本文件中。
 * @author aixu
 * @since 2023/11/8
 */
public class AServer {
    public static void main(String[] args) {
        try {
            // 创建 ServerSocket 对象，指定监听的端口号
            ServerSocket serverSocket = new ServerSocket(8888);

            System.out.println("服务器已启动，等待客户端的连接...");

            // 监听客户端的连接，返回 Socket 对象
            Socket socket = serverSocket.accept();

            // 获取输入流，用于接收客户端发来的数据
            InputStream inputStream = socket.getInputStream();

            // 创建字节数组，用于存储字节数据
            byte[] buffer = new byte[1024];
            int len;

            // 创建一个 FileWriter 对象，用于写入到文本文件
            FileWriter fileWriter = new FileWriter("output.txt");

            // 创建一个 BufferedWriter 对象，用于缓冲写入数据
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // 从输入流中读取数据，并写入到文本文件中
            while ((len = inputStream.read(buffer)) != -1) {
                String str = new String(buffer, 0, len);
                System.out.println("收到客户端发送的内容：" + str);

                // 将数据写入文本文件
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }

            // 刷新缓冲区，将数据写入到文本文件中
            bufferedWriter.flush();

            // 关闭资源
            inputStream.close();
            bufferedWriter.close();
            serverSocket.close();
            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
