package com.csnobugteam.java.test.javase;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 登录客户端
 *
 * @author aixu
 * @since 2023/11/8
 */
public class LoginClient {
    public static void main(String[] args) throws Exception {
        try (// 创建一个 Scanner 对象，用于接收控制台输入的用户名和密码
        Scanner scanner = new Scanner(System.in)) {
            System.out.println("请输入用户名：");
            String username = scanner.nextLine();
            System.out.println("请输入密码：");
            String password = scanner.nextLine();
            // 创建一个 User 对象，并将用户名和密码封装在其中
            User user = new User(username, password);
            // 创建 Socket 对象，指明要连接的服务器端
            Socket socket = new Socket("localhost", 8888);
            // 创建 ObjectOutputStream 对象，用于发送 User 对象
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(user);
            // 创建 ObjectInputStream 对象，用于接收服务器端的响应结果
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            // 输出登录结果
            System.out.println(objectInputStream.readObject());
            // 关闭资源
            objectInputStream.close();
            objectOutputStream.close();
            socket.close();
        }
    }
}
