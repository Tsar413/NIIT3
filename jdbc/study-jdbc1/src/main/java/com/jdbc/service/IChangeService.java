package com.jdbc.service;

import com.jdbc.entity.Student;

public interface IChangeService {

    Integer insertStudent(Integer studentId, String studentName, Integer studentAge);

    Integer insertCourse(Integer courseId, String courseName, Integer type);
}
