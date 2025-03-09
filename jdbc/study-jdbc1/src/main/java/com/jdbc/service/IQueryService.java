package com.jdbc.service;

import com.jdbc.entity.Course;
import com.jdbc.entity.Student;

import java.util.List;

public interface IQueryService {
    List<Student> getAllStudents();

    List<Course> getAllCourses();

    String searchStudent(Integer id);

    String searchCourse(String courseName, Integer type);
}
