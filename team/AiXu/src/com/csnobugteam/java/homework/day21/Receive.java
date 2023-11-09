package com.csnobugteam.java.homework.day21;

import com.csnobugteam.java.utils.NetworkUtils;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

/**
 * 1.参考上课代码, 实现跟同桌聊天
 * 发送端
 * @author aixu
 * @since 2023/11/7
 */
public class Receive {
    /*
        思路：
     // 创建接收端的socket对象
     // 创建Scanner对象
     // 接收逻辑
     // 创建用于接收的数据报包
     // 创建接收端的socket对象

     */

    public static void main(String[] args) throws IOException {
        // 创建接收端的socket对象
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        // 创建Scanner对象
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // 接收逻辑
            // 创建接收端的socket对象
            DatagramPacket receivePacket = NetworkUtils.getReceivePacket();
            // receive
            datagramSocket.receive(receivePacket);
            //解析
            String msg = NetworkUtils.parseMsg(receivePacket);
            // 打印
            System.out.println("接收到了来自:" + receivePacket.getSocketAddress() +
                    "的消息: " + msg);

            // 发送逻辑
            // 接收键盘数据
            String s = scanner.nextLine();
            // 把要发送的数据封装成数据报包
            DatagramPacket sendPacket =
                    NetworkUtils.getSendPacket(s, "127.0.0.1", 8888);
            // send
            datagramSocket.send(sendPacket);
        }

    }
}
