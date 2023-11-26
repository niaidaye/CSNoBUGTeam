//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.Iterator;
//
//public class Collection {
//    public static void main(String[] args) throws ParseException {
//        Collection<Stu> students = new ArrayList<>();
//        students.add(new Stu("zs", 21, 960, "2018-02-12"));
//        students.add(new Stu("ls", 22, 901, "2017-02-12"));
//        students.add(new Stu("ww", 23, 900, "2020-02-12"));
////        Collection<Stu> studentscopy1 = new ArrayList<>(students);
////        Collection<Stu> studentscopy2 = new ArrayList<>(students);
//        printStu(students);
//
//        System.out.println(highestScorer(students).name);
//
//        System.out.println(averageTotal(students));
//
//        Collection<Stu> stu1=deleteBelowAverageScore(students);
//        printStu(stu1);
//        System.out.println("--------");
//        Collection<Stu> stu2=find2year(students);
//        printStu(stu2);
//
//
//    }
//
//    public static long enterrollYear(Stu stu) throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date enrollmentDate = sdf.parse(stu.date);
//        long l = new Date().getTime() - enrollmentDate.getTime();
//        return l/1000/60/60/24/365;
//    }
//
//    private static void printStu(Collection<Stu> students) {
//        for (Stu student : students) {
//            System.out.println("姓名: " + student.name + ", 年龄: " + student.age +
//                    ", 总分: " + student.total + ", 入学日期: " + student.date);
//        }
//    }
//
//    public static Stu highestScorer(Collection<Stu> students) {
//        Iterator<Stu> iterator = students.iterator();
//        Stu highestscorer = iterator.next();
//        while (iterator.hasNext()) {
//            Stu currentscorer = iterator.next();
//            if (highestscorer.total < currentscorer.total) {
//                highestscorer = currentscorer;
//            }
//        }
//        return highestscorer;
//    }
//
//    public static double averageTotal(Collection<Stu> students) {
//        Iterator<Stu> iterator = students.iterator();
//        double total = 0;
//        while (iterator.hasNext()) {
//            total += iterator.next().total;
//        }
//        return total / (students.size());
//    }
//
//    public static Collection<Stu> deleteBelowAverageScore(Collection<Stu> students) {
//        Collection<Stu> studentsCopy = new ArrayList<>(students);
//        Iterator<Stu> iterator = studentsCopy.iterator();
//        double average = averageTotal(studentsCopy);
//        while (iterator.hasNext()) {
//            if (iterator.next().total < average) {
//                iterator.remove();
//            }
//        }
//        return studentsCopy;
//    }
//
//    public static Collection<Stu> find2year(Collection<Stu> students) throws ParseException {
//        Collection<Stu> studentsCopy = new ArrayList<>(students);
//        Iterator<Stu> iterator = studentsCopy.iterator();
//        while (iterator.hasNext()) {
//            if (enterrollYear(iterator.next()) >2) {
//                iterator.remove();
//            }
//        }
//        return studentsCopy;
//    }
//}
//
//class Stu {
//    String name;
//    int age;
//    int total;
//    String date;
//
//    public Stu(String name, int age, int total, String date) {
//        this.name = name;
//        this.age = age;
//        this.total = total;
//        this.date = date;
//    }
//}

