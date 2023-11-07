package com.csnobugteam.java.utils;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @description:
 * @author: AX
 * @date: 2023/11/6 17:38
 **/

public class NetworkUtils {
    // 提供一个用于获取发送端数据报包的方法
    public static DatagramPacket getSendPacket(String msg,String ip,int port) throws UnknownHostException {
        // 创建用于发送的数据报包 把要发送的数据封装成数据报包
        byte[] bytes = msg.getBytes();
        InetAddress targetIP = InetAddress.getByName(ip);
        // return 一个装满了要发送数据的包
        return new DatagramPacket(bytes, 0, bytes.length, targetIP, port);
    }

    // 提供一个用于获取接收的数据报包
    public static DatagramPacket getReceivePacket() {
        // 创建用于接收的数据报包
        byte[] bytes = new byte[1024];
        // return一个空包
        return new DatagramPacket(bytes, 0, bytes.length);
    }

    // 提供一个解析数据的方法
    public static String parseMsg(DatagramPacket packet) {
        byte[] data = packet.getData();
        int length = packet.getLength();
        int offset = packet.getOffset();
        return new String(data, offset, length);

    }
}
