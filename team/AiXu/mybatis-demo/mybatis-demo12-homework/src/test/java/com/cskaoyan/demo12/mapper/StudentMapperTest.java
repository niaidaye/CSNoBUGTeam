package com.cskaoyan.demo12.mapper;

import com.cskaoyan.demo12.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class StudentMapperTest {
    SqlSession sqlSession;
    StudentMapper studentMapper;

    @BeforeEach
    public void setUp() {
        // 1. 获取sqlSession
        sqlSession = MyBatisUtil.getSqlSession(true);

        // 2. 获取mapper
        studentMapper = sqlSession.getMapper(StudentMapper.class);
    }

    @AfterEach
    public void tearDown() {
        sqlSession.close();
    }

    @Test
    public void queryStudentNameById() {
        String expectedName = "zs";
        Integer studentId = 1;
        String actualName = studentMapper.queryStudentNameById(studentId);
        assertEquals(expectedName, actualName);
    }

    @Test
    public void queryStudentNameById2() {
        String expectedName = "ls";
        Integer studentId = 2;
        String actualName = studentMapper.queryStudentNameById2(studentId);
        assertEquals(expectedName, actualName);
    }

    @Test
    public void queryStudentByNameOrId3() {
        Integer expectedId = 3;
        String studentName = "王五";
        String actualName = studentMapper.queryStudentByNameOrId3(expectedId, studentName);
        assertEquals("ww", actualName);
    }

    @Test
    public void queryStudentNameOrId4() {
    }

    @Test
    public void queryStudentByNameOrAge() {
    }

    @Test
    public void queryStudentByNameOrAge2() {
    }
}