package DayList.set;

import javafx.concurrent.Task;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Projectname: CSNoBUGTeam
 * @Filename:
 * @Author: an
 * @Data:2023/11/12 10:43 PM
 * @Description: TODO
 */
/*
假设你要实现一个简单的任务管理系统，使用 LinkedHashSet 存储任务列表，每个任务具有名称和优先级。实现以下操作：

添加任务到任务列表尾部。
添加任务到任务列表头部。
移除任务列表头部的任务。
移除任务列表尾部的任务。
打印当前任务列表。
*/
public class TaskManager {
    public static void main(String[] args) {
//创建LinkedHashSet用于存储任务列表
        Set<Task> taskList=new LinkedHashSet<>();
        //添加任务到任务列表
        addTaskToEnd(taskList, new Task("TaskA", Priority.HIGH));
        addTaskToEnd(taskList, new Task("TaskB", Priority.MEDIUM));
        addTaskToEnd(taskList, new Task("TaskC", Priority.LOW));
//打印当前任务列表
        System.out.println(taskList);
        //添加任务至列表头部
        addTaskFront(taskList,new Task("TaskX",Priority.HIGH));
        System.out.println(taskList);
        // 移除任务列表头部的任务
        removeTaskFromFront(taskList);
        System.out.println(taskList);
        //移除任务列表尾部的任务
        removeTaskFromEnd(taskList);
        System.out.println(taskList);
    }

    private static void addTaskFront(Set<Task> taskList, Task task) {
        //新建一个set接收
        Set<Task> newTaskList=new LinkedHashSet<>();
        //传入task
        newTaskList.add(task);//此时注意Task在list最顶部！！
        newTaskList.addAll(taskList);
//再清空原list
        taskList.clear();
        taskList.addAll(newTaskList);

    }
    // 移除任务列表头部的方法
    private static void removeTaskFromFront(Set<Task> taskList) {
        if (!taskList.isEmpty()) {
            Task firstTask = taskList.iterator().next();
            taskList.remove(firstTask);
        }
    }

    // 移除任务列表尾部的方法
    private static void removeTaskFromEnd(Set<Task> taskList) {
        if (!taskList.isEmpty()) {
            taskList.remove(taskList.iterator().next());
        }
    }

    // 添加任务到任务列表尾部的方法
    private static void addTaskToEnd(Set<Task> taskList, Task task) {
        taskList.add(task);
    }

    static class Task {
        String name;
        Priority priority;

        public Task(String name, Priority priority) {
            this.name = name;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "name='" + name + '\'' +
                    ", priority=" + priority +
                    '}';
        }
    }
    // 任务优先级枚举
    enum Priority {
        HIGH, MEDIUM, LOW
    }
}
// 任务类

