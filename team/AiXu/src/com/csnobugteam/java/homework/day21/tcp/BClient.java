package com.csnobugteam.java.homework.day21.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * b. 客户端文本文件，服务器输出到控制台
 * 在客户端，读取要发送的文本文件内容，并将其发送到服务器。
 * @author aixu
 * @since 2023/11/8
 */
public class BClient {
    public static void main(String[] args) {
        try {
            // 创建 Socket 对象，指定服务器的 IP 和端口号
            Socket socket = new Socket("127.0.0.1", 8888);

            // 获取输出流，用于向服务器发送数据
            OutputStream outputStream = socket.getOutputStream();

            // 读取文本文件内容
            Path path = Paths.get("input.txt");
            byte[] data = Files.readAllBytes(path);

            // 发送数据给服务器
            outputStream.write(data);

            // 关闭资源
            outputStream.close();
            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
