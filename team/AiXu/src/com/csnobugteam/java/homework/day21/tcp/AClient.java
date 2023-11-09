package com.csnobugteam.java.homework.day21.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * a.客户端键盘录入，服务器输出文本文件
 * 在客户端，使用Scanner类从键盘读取用户输入的内容，并将其发送到服务器。
 *
 * @author aixu
 * @since 2023/11/8
 */
public class AClient {
    public static void main(String[] args) {
        try {
            // 创建 Socket 对象，指定服务器的 IP 和端口号
            Socket socket = new Socket("127.0.0.1", 8888);

            // 获取输出流，用于向服务器发送数据
            OutputStream outputStream = socket.getOutputStream();

            // 创建 Scanner 对象，从键盘读取用户输入的内容
            Scanner scanner = new Scanner(System.in);

            System.out.println("请输入要发送给服务器的内容：");
            String input = scanner.nextLine();

            // 将用户输入的内容转为字节数组
            byte[] data = input.getBytes();

            // 发送数据给服务器
            outputStream.write(data);

            // 关闭资源
            scanner.close();
            outputStream.close();
            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
