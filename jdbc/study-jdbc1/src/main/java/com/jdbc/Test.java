package com.jdbc;

import com.jdbc.controller.JDBCLearningController;

public class Test {
    public static void main(String[] args) {
        System.out.println("Hello JDBC");
        JDBCLearningController JDBCLearningController = new JDBCLearningController();
        System.out.println(JDBCLearningController.getAllStudents());
        System.out.println(JDBCLearningController.getAllCourses());
        System.out.println(JDBCLearningController.searchStudent(1));
        System.out.println(JDBCLearningController.searchCourse("a programming", 1));
        //System.out.println(JDBCLearningController.insertStudent(5, "e", 20));
        System.out.println(JDBCLearningController.insertCourse(4, "a", 4));
    }
}
