package com.cskaoyan.demo12.mapper;

import com.cskaoyan.demo12.bean.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Common-zhou
 * @since 2023-12-05 18:23
 */
public interface StudentMapper {
    String queryStudentNameById(Integer id);

    String queryStudentNameById2(@Param("id") Integer id);

    String queryStudentByNameOrId3(Integer id, String name);

    List<Student> queryStudentNameOrId4(@Param("id") Integer id, @Param("name") String name);

    List<Student> queryStudentByNameOrAge(Student student);

    List<Student> queryStudentByNameOrAge2(@Param("student") Student student);

}
