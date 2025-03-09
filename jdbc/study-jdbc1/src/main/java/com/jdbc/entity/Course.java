package com.jdbc.entity;

public class Course {
    private Integer courseId;

    private String courseName;

    private Integer type;

    public Course() {
    }

    public Course(Integer courseId, String courseName, Integer type) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.type = type;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", type=" + type +
                '}';
    }
}
