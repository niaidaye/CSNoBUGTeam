package com.csnobugteam.java.test.javase;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 使用TCP网络编程完成用户登录功能：
 * 客户端启动后提示键盘录入，控制台输入用户名和密码后，向服务器发出登录请求，此时发送的是一个User对象，而不是两个字符串；
 * 服务端接收到User对象后进行判断，如果用户名和密码均是admin，则登录成功，否则登录失败。不管登录是否成功，都需要返回相应响应信息，服务端结束；
 * 客户端接收响应后打印信息，输出登录结果，客户端结束。
 * 1)用户User类已提供构造方法 public User(String username,String password)。
 * 2)客户端采用ObjectOutputStream发送封装了用户名和密码的User对象。
 * 3)服务器端和客户端的类名和方法声明如下所示。
 * public class LoginServer {
 * 	public static void main(String[] args) throws Exception {}
 * }
 * public class LoginClient {
 * 	public static void main(String[] args) throws Exception {}
 * }
 */
public class LoginServer {
    public static void main(String[] args) throws Exception {
        // 创建 ServerSocket 对象，监听 8888 端口
        ServerSocket serverSocket = new ServerSocket(8888);
        // 调用 accept 方法，开始监听客户端请求
        Socket socket = serverSocket.accept();
        // 创建 ObjectInputStream 对象，用来读取客户端发送的 User 对象
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        // 读取并转换 User 对象
        User user = (User) objectInputStream.readObject();
        // 创建一个 ObjectOutputStream 对象，用于响应客户端结果
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        // 判断接收的对象中的用户名和密码是否都是 admin
        if ("admin".equals(user.getUsername()) && "admin".equals(user.getPassword())) {
            // 是则表示登录成功，返回给客户端 “登录成功”
            objectOutputStream.writeObject("登录成功");
        } else {
            // 否则表示登录失败，返回给客户端 “登录失败”
            objectOutputStream.writeObject("登录失败");
        }
        // 关闭资源
        objectOutputStream.close();
        objectInputStream.close();
        socket.close();
        serverSocket.close();
    }
}