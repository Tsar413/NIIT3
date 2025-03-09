package com.jdbc.dao;

import com.jdbc.entity.Course;
import com.jdbc.entity.Student;

import java.util.List;

public interface IQueryDao {

    List<Student> queryAllStudents();

    List<Course> getAllCourses();

    Student searchStudent(Integer id);

    Course searchCourse(String courseName, Integer type);

    Integer getMaxId();
}
