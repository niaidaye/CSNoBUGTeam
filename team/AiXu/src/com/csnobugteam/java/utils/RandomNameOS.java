package com.csnobugteam.java.utils;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 随机点名系统
 *  功能：通过读取文件中名单进行随机点名
 * @author aixu
 * @since 2023/11/18
 */
public class RandomNameOS {
    private List<String> nameArray;
    private List<String> outNameArray;
    String readFilePath ;
    String writeFilePath;

    public RandomNameOS(String readFilePath, String writeFilePath) {
        this.readFilePath = readFilePath;
        this.writeFilePath = writeFilePath;
        // TODO 进行文件交换逻辑bug
        File file = new File(readFilePath);
        // 如果文件空了进行交换
//        if (file.length() == 0){
//            String temp =  readFilePath;
//            readFilePath = writeFilePath;
//            writeFilePath = temp;
//            file = new File(readFilePath);
//        }

        this.nameArray = readFileNamesToArrays(file);
    }

    // 从文件中获取，每个人的姓名
    private List<String> readFileNamesToArrays(File file) {
        nameArray = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(Files.newInputStream(file.toPath())))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                nameArray.add(line);
            }        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return nameArray;
    }

    // 从nameArray随机抽一个人
    public String randomName() {
        outNameArray = new ArrayList<>();
        Random random = new Random();
        int nextInt = random.nextInt(nameArray.size());
        String name = nameArray.get(nextInt);
        outNameArray.add(name);
        nameArray.remove(nextInt);
        // 将待点名数据写回原文件
        writeNameArrayToFile(readFilePath, nameArray, false);
        // 将已点名数据写入，新文件
        writeNameArrayToFile(writeFilePath, outNameArray, true);
        return name;
    }

    // 写回文件
    private void writeNameArrayToFile(String filePath,List<String> date,boolean status) {
        File file = new File(filePath);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file,status))) {
            for (String name : date) {
                writer.write(name);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
// 多线程代码
//public class RandomNameOS {
//    private List<String> nameArray;
//    private List<String> outNameArray;
//    private String readFilePath;
//    private String writeFilePath;
//    private Lock readLock;
//    private Lock writeLock;
//
//    public RandomNameOS(String readFilePath, String writeFilePath) {
//        this.readFilePath = readFilePath;
//        this.writeFilePath = writeFilePath;
//        this.readLock = new ReentrantLock();
//        this.writeLock = new ReentrantLock();
//    }
//
//    // 从文件中获取每个人的姓名
//    public List<String> readFileNamesToArrays() {
//        readLock.lock();
//        try {
//            nameArray = new ArrayList<>();
//            File file = new File(readFilePath);
//            try (BufferedReader bufferedReader = new BufferedReader(
//                    new InputStreamReader(Files.newInputStream(file.toPath())))) {
//                String line;
//                while ((line = bufferedReader.readLine()) != null) {
//                    nameArray.add(line);
//                }
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            return nameArray;
//        } finally {
//            readLock.unlock();
//        }
//    }
//
//    // 从nameArray随机抽一个人
//    public String randomName() {
//        writeLock.lock();
//        try {
//            outNameArray = new ArrayList<>();
//            Random random = new Random();
//            int nextInt = random.nextInt(nameArray.size());
//            String name = nameArray.get(nextInt);
//            outNameArray.add(name);
//            nameArray.remove(nextInt);
//            return name;
//        } finally {
//            writeLock.unlock();
//        }
//    }
//
//    // 写回文件
//    private void writeNameArrayToFile(String filePath, List<String> data, boolean status) {
//        writeLock.lock();
//        try {
//            File file = new File(filePath);
//            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, status))) {
//                for (String name : data) {
//                    writer.write(name);
//                    writer.newLine();  // 添加换行符
//                }
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        } finally {
//            writeLock.unlock();
//        }
//    }
//
//    // 多线程读写文件
//    public void processNamesMultithreaded(int numThreads) {
//        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
//
//        // 读取文件任务
//        executorService.submit(() -> {
//            readFileNamesToArrays();
//            System.out.println("File read complete.");
//        });
//
//        // 随机抽取名字任务
//        for (int i = 0; i < numThreads - 1; i++) {
//            executorService.submit(() -> {
//                String name = randomName();
//                System.out.println("Random name: " + name);
//            });
//        }
//
//        // 写回output.txt任务
//        executorService.submit(() -> {
//            writeNameArrayToFile(writeFilePath, outNameArray, true);
//            System.out.println("File write complete (output.txt).");
//        });
//
//        // 写回input.txt并删除已抽取的名字任务
//        executorService.submit(() -> {
//            writeNameArrayToFile(readFilePath, nameArray, false);
//            System.out.println("File write complete (input.txt).");
//        });
//
//        // 关闭线程池
//        executorService.shutdown();
//    }
//
//    public static void main(String[] args) {
//        RandomNameOS randomNameOS = new RandomNameOS("input.txt", "output.txt");
//        randomNameOS.processNamesMultithreaded(4);
//    }
//}