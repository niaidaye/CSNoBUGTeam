package DayList.deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Projectname: CSNoBUGTeam
 * @Filename:
 * @Author: an
 * @Data:2023/11/12 9:33 PM
 * @Description: TODO
 */
/*添加任务到队列尾部。 List的结构大差不差，使用可以按照任务点选配。多查找还是多插入。
添加任务到队列头部。
从队列头部取出任务执行，并将其放到队列尾部。
从队列尾部取出任务执行，并将其放到队列头部。
打印当前任务列表。
*/
public class Demo {
    public static void main(String[] args) {
        //建立一个双端队列
        Deque<Task> alternatingTaskList=new LinkedList<>();
        //添加任务
        addTask(alternatingTaskList);
        //打印任务
        System.out.println(alternatingTaskList);
        //添加任务到队列头部
        alternatingTaskList.addFirst(new Task("T",22));
        System.out.println(alternatingTaskList);
        //从队列头部取出任务执行，并将其放在队尾
        executAndmoveToEnd(alternatingTaskList);
        //
    }

    private static void executAndmoveToEnd(Deque<Task> alternatingTaskList) {
        Task frontTask=alternatingTaskList.removeFirst();
        System.out.println(alternatingTaskList.add(frontTask));

    }

    private static void addTask(Deque<Task> alternatingTaskList) {
        alternatingTaskList.add(new Task("Task",10));
        alternatingTaskList.add(new Task("Tom",5));
        alternatingTaskList.add(new Task("Task4",17));
    }
}
class Task{
    String name;
    int executionTime;

    public Task(String name, int executionTime) {
        this.name = name;
        this.executionTime = executionTime;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", executionTime=" + executionTime +
                '}';
    }
}