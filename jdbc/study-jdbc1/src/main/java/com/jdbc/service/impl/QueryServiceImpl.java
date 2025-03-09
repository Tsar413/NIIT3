package com.jdbc.service.impl;

import com.jdbc.dao.IQueryDao;
import com.jdbc.dao.impl.QueryDaoImpl;
import com.jdbc.entity.Course;
import com.jdbc.entity.Student;
import com.jdbc.service.IQueryService;

import java.util.List;

public class QueryServiceImpl implements IQueryService {

    private IQueryDao iQueryDao = new QueryDaoImpl();

    @Override
    public List<Student> getAllStudents() {
        return iQueryDao.queryAllStudents();
    }

    @Override
    public List<Course> getAllCourses() {
        return iQueryDao.getAllCourses();
    }

    @Override
    public String searchStudent(Integer id) {
        Student student = iQueryDao.searchStudent(id);
        if(student != null){
            return student.toString();
        }
        return "学生不存在";
    }

    @Override
    public String searchCourse(String courseName, Integer type) {
        Course course = iQueryDao.searchCourse(courseName, type);
        if(course != null){
            return course.toString();
        }
        return "课程不存在";
    }
}
