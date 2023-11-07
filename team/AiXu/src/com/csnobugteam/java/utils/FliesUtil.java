package com.csnobugteam.java.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 文件工具类
 *
 * @author aixu
 * @since 2023/11/2
 */
public class FliesUtil {

    private static List<String> stringList = new ArrayList<>();

    // 字符输入流
    public static char[] fileReadByByte(InputStream inputStream) {
        // 批量
        byte[] bytes = new byte[1024];
        StringBuilder dateBuilder = new StringBuilder();
        ;
        // 创建文件输入流
        try (BufferedInputStream input = new BufferedInputStream(inputStream)) {
            // 批量
            int readCount;
            // 循环读取
            while ((readCount = input.read(bytes)) != -1) {
                String date = new String(bytes, 0, readCount);
                dateBuilder.append(date);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return dateBuilder.toString().toCharArray();
    }

    // 字符输出流
    public static void fileWriteByByte(OutputStream outputStream, char[] date) {
        // 批量
        byte[] bytes = new byte[1024];
        // 创建文件输出流
        try (BufferedOutputStream output = new BufferedOutputStream(outputStream)) {
            output.write(System.lineSeparator().getBytes());
            output.write(Arrays.toString(date).getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("文件输出成功：");
    }

    /**
     * 创建递归查找文件操作
     *
     * @param file       查找文件路径
     * @param suffixName 文件后缀名
     */
    public static List<String> findFolder(File file, String suffixName) {
        // 递归结束条件
        if (!file.exists()) return null;

        // 如果是目录，请进入内部并递归调用
        if (file.isDirectory()) {
            for (File listFile : Objects.requireNonNull(file.listFiles())) {
                // 进行查找条件
                findFolder(listFile, suffixName);
            }
        }
        // 查找,代suffixName的文件
        if (file.getName().endsWith(suffixName)){
            stringList.add(file.getAbsolutePath());
        }
        return stringList;
    }

    /**
     * 复制文件
     * @param in 输入文件
     * @param out 输出文件
     */
    public static void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] bytes = new byte[1024];
        int readCount;
        while ((readCount = in.read(bytes)) != -1) {
            // write(byte[] b)
            // 读了多个个字节 写多少个
            out.write(bytes,0,readCount);
        }

    }

    // 字符输出流
    public static void fileWriteByFile(BufferedWriter output, String date) throws IOException {
        // 创建文件输出流
        output.newLine();
        output.write(date);
        output.newLine();
        System.out.println("文件输出成功：");
    }

}
