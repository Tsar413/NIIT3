package com.jdbc.dao.impl;

import com.jdbc.dao.IChangeDao;
import com.jdbc.entity.Course;
import com.jdbc.entity.Student;
import com.jdbc.utils.DatabaseConnection;
import com.jdbc.utils.SQLConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChangeDaoImpl implements IChangeDao {

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
    public String insertStudent(Student student) {
        String sql = SQLConstants.INSERT_ONE_STUDENT;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, student.getId());
            statement.setInt(2, student.getStudentId());
            statement.setString(3, student.getStudentName());
            statement.setInt(4, student.getStudentAge());
            int result = statement.executeUpdate();
            return result + "";
        } catch (SQLException e) {
            return e.getErrorCode() + "";
        }
    }

    @Override
    public String insertCourse(Course course) {
        String sql = SQLConstants.INSERT_ONE_COURSE;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, course.getCourseId());
            statement.setString(2, course.getCourseName());
            statement.setInt(3, course.getType());
            int result = statement.executeUpdate();
            return result + "";
        } catch (SQLException e) {
            return e.getErrorCode() + "";
        }
    }
}
