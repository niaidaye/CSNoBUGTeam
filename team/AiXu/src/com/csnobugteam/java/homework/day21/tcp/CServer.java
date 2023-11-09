package com.csnobugteam.java.homework.day21.tcp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * c. 客户端文本文件，服务器输出文本文件
 *  在服务器端，接收客户端发送的内容，并将其写入到另一个文本文件中。
 * @author aixu
 * @since 2023/11/8
 */
public class CServer {
    public static void main(String[] args) {
        try {
            // 创建 ServerSocket 对象，指定监听的端口号
            ServerSocket serverSocket = new ServerSocket(8888);

            System.out.println("服务器已启动，等待客户端的连接...");

            // 监听客户端的连接，返回 Socket 对象
            Socket socket = serverSocket.accept();

            // 获取输入流，用于接收客户端发来的数据
            InputStream inputStream = socket.getInputStream();

            // 读取客户端发送的数据
            Path path = Paths.get("input.txt");
            byte[] data = Files.readAllBytes(path);

            // 创建一个 FileWriter 对象，用于写入到文本文件
            FileWriter fileWriter = new FileWriter("output.txt");

            // 创建一个 BufferedWriter 对象，用于缓冲写入数据
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // 将数据写入到文本文件中
            bufferedWriter.write(new String(data));

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
