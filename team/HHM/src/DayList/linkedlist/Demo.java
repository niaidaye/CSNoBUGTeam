package DayList.linkedlist;

import java.util.LinkedList;

/**
 * @Projectname: CSNoBUGTeam
 * @Filename:
 * @Author: an
 * @Data:2023/11/12 8:41 PM
 * @Description: TODO
 */
/*使用 LinkedList 实现一个学生名单，每个节点包含学生的姓名和学号。实现以下操作：

添加学生到名单的末尾。
在名单的开头插入一个新学生。
删除名单中指定学号的学生。
打印学生名单。*/


public class Demo {
    public static void main(String[] args) {
        //打印一个学生数组用于存储学生信息
        LinkedList<Student> studentList=new LinkedList<>();
        //添加学生信息+option+command+M 抽方法
        addInfoStudent(studentList);
        //链表开头插一个学生
        studentList.addFirst(new Student("AIxu",20,"running"));
        System.out.println(studentList);
        //添加学生信息至Bod尾
        studentList.addLast(new Student("Faker",23,"LOL"));
        System.out.println(studentList);
        //根据学号id查找学生索引
        int indexOfBob= studentList.indexOf(new Student("",12,null));
        if(indexOfBob!=-1){
            //根据索引替换学生爱好
            studentList.set(indexOfBob,new Student("BoB",12,"football"));
            System.out.println(studentList);
        }
        studentList.remove(4);
        System.out.println(studentList);

    }

    private static void addInfoStudent(LinkedList<Student> studentList) {
        studentList.add(new Student("Alice", 11,"shopping"));
        studentList.add(new Student("Bob", 12,"swim"));
        studentList.add(new Student("Charlie", 22,"soccer"));
    }
}
class Student{
    String name;
    int id;
    String hobby;

    public Student(String name, int id, String hobby) {
        this.name = name;
        this.id = id;
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}