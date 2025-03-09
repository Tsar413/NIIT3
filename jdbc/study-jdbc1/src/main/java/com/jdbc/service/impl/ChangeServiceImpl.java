package com.jdbc.service.impl;

import com.jdbc.dao.IChangeDao;
import com.jdbc.dao.IQueryDao;
import com.jdbc.dao.impl.ChangeDaoImpl;
import com.jdbc.dao.impl.QueryDaoImpl;
import com.jdbc.entity.Course;
import com.jdbc.entity.Student;
import com.jdbc.service.IChangeService;

public class ChangeServiceImpl implements IChangeService {

    private IChangeDao iChangeDao = new ChangeDaoImpl();

    public IQueryDao iQueryDao = new QueryDaoImpl();

    @Override
    public Integer insertStudent(Integer studentId, String studentName, Integer studentAge) {
        Student student = new Student();
        student.setId(iQueryDao.getMaxId() + 1);
        student.setStudentId(studentId);
        student.setStudentName(studentName);
        student.setStudentAge(studentAge);
        String flag = iChangeDao.insertStudent(student);
        if(flag.length() == 4){
            return -1;
        }
        return 1;
    }

    @Override
    public Integer insertCourse(Integer courseId, String courseName, Integer type) {
        Course course = new Course();
        course.setCourseId(courseId);
        course.setCourseName(courseName);
        course.setType(type);
        String flag = iChangeDao.insertCourse(course);
        if(flag.length() == 4){
            return -1;
        }
        return 1;
    }
}
