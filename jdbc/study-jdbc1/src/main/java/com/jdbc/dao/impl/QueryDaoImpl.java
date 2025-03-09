package com.jdbc.dao.impl;

import com.jdbc.dao.IQueryDao;
import com.jdbc.entity.Course;
import com.jdbc.entity.Student;
import com.jdbc.utils.DatabaseConnection;
import com.jdbc.utils.SQLConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryDaoImpl implements IQueryDao {

    private Connection connection;

    {
        try {
            //1建立连接
            connection = new DatabaseConnection().getDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> queryAllStudents() {
        String sql = SQLConstants.QUERY_ALL_STUDENTS;
        List<Student> student = new ArrayList<Student>();
        try {
            //2构造sql
            PreparedStatement statement = connection.prepareStatement(sql);
            //3执行sql
            ResultSet resultSet = statement.executeQuery();//结果集(把它看作一个表格结构的数据) 得到的是一个临时表
            //5遍历结果集
            while(resultSet.next()){
            /*用next()来取出下一行的数据,如果能够取出返回true,如果取不出来到达末尾了则返回false,循环结束
            有一个光标指向结果集的某一行,next()就是在处理移动光标.
            初始情况下,光标指向的是在第一行数据的前一个位置
            进入while循环,首先调用next,光标往后移动一行.看这一行的数据能不能够取出来,能够取出来next返回true,循环继续执行,
            在循环体里头就可以针对这一行进行操作了.再next...直到next返回false循环结束
            这个循环就是在控制光标往后移动的过程-------->取出每一行*/

                //针对这里的光标指向的行进行处理
                //这里的get也有很多方法,具体情况具体调用~
                //------->取出每一列
                Student student1 = new Student();
                int id = resultSet.getInt("student_id");//student_id为列的名字 返回一个int类型的值
                String name = resultSet.getString("student_name");//student_name也为列的名字 返回一个String类型的值
                int age = resultSet.getInt("student_age");//student_age为列的名字 返回一个int类型的值
                student1.setStudentId(id);
                student1.setStudentName(name);
                student1.setStudentAge(age);
                student.add(student1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }

    @Override
    public List<Course> getAllCourses() {
        String sql = SQLConstants.QUERY_ALL_COURSES;
        List<Course> courses = new ArrayList<Course>();
        try {
            //2构造sql
            PreparedStatement statement = connection.prepareStatement(sql);
            //3执行sql
            ResultSet resultSet = statement.executeQuery();//结果集(把它看作一个表格结构的数据) 得到的是一个临时表
            //5遍历结果集
            while(resultSet.next()){
            /*用next()来取出下一行的数据,如果能够取出返回true,如果取不出来到达末尾了则返回false,循环结束
            有一个光标指向结果集的某一行,next()就是在处理移动光标.
            初始情况下,光标指向的是在第一行数据的前一个位置
            进入while循环,首先调用next,光标往后移动一行.看这一行的数据能不能够取出来,能够取出来next返回true,循环继续执行,
            在循环体里头就可以针对这一行进行操作了.再next...直到next返回false循环结束
            这个循环就是在控制光标往后移动的过程-------->取出每一行*/

                //针对这里的光标指向的行进行处理
                //这里的get也有很多方法,具体情况具体调用~
                //------->取出每一列
                Course course = new Course();
                int id = resultSet.getInt("course_id");//student_id为列的名字 返回一个int类型的值
                String name = resultSet.getString("course_name");//student_name也为列的名字 返回一个String类型的值
                int type = resultSet.getInt("type");//student_age为列的名字 返回一个int类型的值
                course.setCourseId(id);
                course.setCourseName(name);
                course.setType(type);
                courses.add(course);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return courses;
    }

    @Override
    public Student searchStudent(Integer id) {
        String sql = SQLConstants.QUERY_ONE_STUDENT;
        Student student = null;
        try {
            //2构造sql
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            //3执行sql
            ResultSet resultSet = statement.executeQuery();//结果集(把它看作一个表格结构的数据) 得到的是一个临时表
            //4查询结果集
            if(resultSet.next()){
                student = new Student();
                student.setStudentId(resultSet.getInt("student_id"));
                student.setStudentName(resultSet.getString("student_name"));
                student.setStudentAge(resultSet.getInt("student_age"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }

    @Override
    public Course searchCourse(String courseName, Integer type) {
        String sql = SQLConstants.QUERY_ONE_COURSE;
        Course course = null;
        try {
            //2构造sql
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, courseName);
            statement.setInt(2, type);
            //3执行sql
            ResultSet resultSet = statement.executeQuery();//结果集(把它看作一个表格结构的数据) 得到的是一个临时表
            //4查询结果集
            if(resultSet.next()){
                course = new Course();
                course.setCourseId(resultSet.getInt("course_id"));
                course.setCourseName(resultSet.getString("course_name"));
                course.setType(resultSet.getInt("type"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return course;
    }

    @Override
    public Integer getMaxId() {
        String sql = SQLConstants.QUERY_BIGGEST_ID;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            //3执行sql
            ResultSet resultSet = statement.executeQuery();//结果集(把它看作一个表格结构的数据) 得到的是一个临时表
            //4查询结果集
            if(resultSet.next()){
                return resultSet.getInt("max(id)");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
