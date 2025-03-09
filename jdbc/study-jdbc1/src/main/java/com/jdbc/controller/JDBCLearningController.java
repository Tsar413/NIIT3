package com.jdbc.controller;

import com.jdbc.entity.Course;
import com.jdbc.entity.Student;
import com.jdbc.service.IChangeService;
import com.jdbc.service.IQueryService;
import com.jdbc.service.impl.ChangeServiceImpl;
import com.jdbc.service.impl.QueryServiceImpl;

import java.util.List;

public class JDBCLearningController {

    private IQueryService iQueryService = new QueryServiceImpl();

    private IChangeService iChangeService = new ChangeServiceImpl();

    public List<Student> getAllStudents(){
        return iQueryService.getAllStudents();
    }

    public List<Course> getAllCourses(){
        return iQueryService.getAllCourses();
    }

    public String searchStudent(Integer id){
        return iQueryService.searchStudent(id);
    }

    public String searchCourse(String courseName, Integer type){
        return iQueryService.searchCourse(courseName, type);
    }

    public Integer insertStudent(Integer studentId, String studentName, Integer studentAge){
        return iChangeService.insertStudent(studentId, studentName, studentAge);
    }

    public Integer insertCourse(Integer courseId, String courseName, Integer type){
        return iChangeService.insertCourse(courseId, courseName, type);
    }
}
