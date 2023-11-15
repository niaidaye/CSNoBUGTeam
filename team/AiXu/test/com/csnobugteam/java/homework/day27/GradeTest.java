package com.csnobugteam.java.homework.day27;

import org.junit.Test;

import java.util.*;

public class GradeTest {
    @Test
    public void testGenerateGradeMap() {
        // test data
        List<Teacher> teachers = newTeachers();
        List<Student> students = newStudents(teachers);

        List<Grade> grades = new ArrayList<>();

        Map<Teacher, List<Student>> teacherStudentMap = generateTeacherStudentMap(teachers, students);
        Set<Map.Entry<Teacher, List<Student>>> entries = teacherStudentMap.entrySet();
        for (Map.Entry<Teacher, List<Student>> entry : entries) {
            Grade grade = new Grade(entry.getKey(), entry.getValue());
            grades.add(grade);
        }

        grades.forEach(grade -> System.out.println("老师："+grade.getTeacher().getName() +": 学生人数："+ grade.getStudents().size()));
    }

    private List<Teacher> newTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher(1, "Teacher1", 35));
        teachers.add(new Teacher(2, "Teacher2", 40));
        return teachers;
    }

    private List<Student> newStudents(List<Teacher> teachers) {
        List<Student> students = new ArrayList<>();
        int studentId = 1;

        for (Teacher teacher : teachers) {
            students.add(new Student(studentId++, "Student" + studentId, 18, teacher.getId()));
            students.add(new Student(studentId++, "Student" + studentId, 19, teacher.getId()));
        }

        return students;
    }

    private Map<Teacher, List<Student>> generateTeacherStudentMap(List<Teacher> teachers, List<Student> students) {
        Map<Teacher, List<Student>> teacherStudentMap = new HashMap<>();

        for (Teacher teacher : teachers) {
            List<Student> teacherStudents = new ArrayList<>();
            for (Student student : students) {
                if (student.getTeacherId() == teacher.getId()) {
                    teacherStudents.add(student);
                }
            }
            teacherStudentMap.put(teacher, teacherStudents);
        }

        return teacherStudentMap;
    }
}