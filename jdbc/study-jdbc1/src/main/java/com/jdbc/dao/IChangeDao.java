package com.jdbc.dao;

import com.jdbc.entity.Course;
import com.jdbc.entity.Student;

public interface IChangeDao {

    String insertStudent(Student student);

    String insertCourse(Course course);
}
