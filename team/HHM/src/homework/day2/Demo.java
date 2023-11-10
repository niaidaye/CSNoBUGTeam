package homework.day2;

/**
 * @Projectname: Day2homework
 * @Filename:
 * @Author: an
 * @Data:2023/11/10 8:21 PM
 * @Description: TODO
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

class Student {
    private String name;
    private int age;
    private int totalScore;
    private Date date;

    public Student(String name, int age, int totalScore, Date date) {
        this.name = name;
        this.age = age;
        this.totalScore = totalScore;
        this.date = date;
    }
    public int getAge(){
        return age;
    }

    public String getName() {
        return name;
    }

    public int getTotalScore() {
        return totalScore;
    }
}

public class Demo {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        // 添加学生信息
        students.add(new Student("Alice", 20, 85, new Date()));
        students.add(new Student("Bob", 22, 92, new Date()));
        students.add(new Student("zys", 21, 78, new Date()));
        students.add(new Student("David", 16, 90, new Date()));
        students.add(new Student("zs", 23, 88, new Date()));

        // 找出最高分
        Student highestScoringStudent = findHighestScoringStudent(students);

        if (highestScoringStudent != null) {
            System.out.println("最高分的学生是：" + highestScoringStudent.getName());
            System.out.println("总分：" + highestScoringStudent.getTotalScore());
        } else {
            System.out.println("没有学生信息");
        }
        //计算平均分
//        double averageScore = students.stream()
//                .mapToInt(Student::getTotalScore)
//                .average()
//                .orElse(0);
        double sum=0;
        for(Student student:students){
            sum +=student.getTotalScore();

        }
        double averageScore=sum/students.size();
        System.out.println("平均分："+averageScore);
        //删去低于平均分的学生
        //新建线性表

        List<Student>belowAverageStudents=new ArrayList<>();
        for(Student student:students){
            if(student.getTotalScore()<averageScore){
                belowAverageStudents.add(student);
            }
        }students.removeAll(belowAverageStudents);
        for(Student student:students){
            System.out.println("姓名"+student.getName());
            System.out.println("总分"+student.getTotalScore());

        }
        //删去年龄小于18岁的人
//        List<Student>loweighteenPerson=new ArrayList<>();
//        for(Student student:students){
//            if(student.getAge()<18){
//                loweighteenPerson.add(student);
//            }
//        }students.removeAll(loweighteenPerson);
        //使用迭代器方法
        Iterator<Student> iteator=students.iterator();
        while(iteator.hasNext()){
            Student student=iteator.next();
            if(student.getAge()<18){
                iteator.remove();
            }

        }
        for(Student student:students){
            System.out.println("姓名"+student.getName());
            System.out.println("年龄"+student.getAge());
        }
        //使用迭代器删去zs
        Iterator<Student>iterator=students.iterator();
        while(iterator.hasNext()){
            Student student=iterator.next();
            if(student.getName().equals("zs")){
                iterator.remove();

            }
        }
        for(Student student:students){
            System.out.println("姓名"+student.getName());
            System.out.println("年龄"+student.getAge());
        }
    }

    private static Student findHighestScoringStudent(List<Student> students) {
        Student highestScoringStudent = null;
        //Integer.MIN_VALUE找出最小值，节省一次遍历操作
        int highestScore = Integer.MIN_VALUE;
//遍历
        for (Student student : students) {
            if (student.getTotalScore() > highestScore) {
                highestScore = student.getTotalScore();
                highestScoringStudent = student;
            }
        }

        return highestScoringStudent;
    }

//sout操作有点冗余，可以做成方法包处理
}