package com.jdbc.utils;

public class SQLConstants {
    public static final String QUERY_ALL_STUDENTS = "select * from student";
    public static final String QUERY_ALL_COURSES = "select * from course";
    public static final String QUERY_ONE_STUDENT = "select * from student where student_id = ?";
    public static final String QUERY_ONE_COURSE = "select * from course where course_name = ? && type = ?";
    public static final String INSERT_ONE_STUDENT = "insert into student(id, student_id, student_name, student_age) " +
            "values (?,?,?,?)";
    public static final String QUERY_BIGGEST_ID = "select max(id) from student";
    public static final String INSERT_ONE_COURSE = "insert into course(course_id, course_name, type) " +
            "values (?,?,?)";
}
