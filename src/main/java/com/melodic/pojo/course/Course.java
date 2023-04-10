package com.melodic.pojo.course;

import java.io.Serializable;

public class Course implements Serializable {

    String courseID;
    String courseBaseID;
    String courseName;
    String courseTypeID;
    String collegeID;
    Double courseCredit;
    String teacherID;
    Integer studentsLimit;
    Integer state;
    Integer academicYear;
    Integer semester;
    String description;

    public Course() {}

    public Course(CourseBase base, String courseID, String teacherID, Integer studentsLimit, Integer state, Integer academicYear, Integer semester) {
        this.courseID = courseID;
        this.courseBaseID = base.getCourseBaseID();
        this.courseName = base.getCourseName();
        this.courseTypeID = base.getCourseTypeID();
        this.collegeID = base.getCollegeID();
        this.courseCredit = base.getCourseCredit();
        this.teacherID = teacherID;
        this.studentsLimit = studentsLimit;
        this.state = state;
        this.academicYear = academicYear;
        this.semester = semester;
        this.description = base.getDescription();
    }

    public Course(String courseID, String courseBaseID, String courseName, String courseTypeID, String collegeID, Double courseCredit, String teacherID, Integer studentsLimit, Integer state, Integer academicYear, Integer semester, String description) {
        this.courseID = courseID;
        this.courseBaseID = courseBaseID;
        this.courseName = courseName;
        this.courseTypeID = courseTypeID;
        this.collegeID = collegeID;
        this.courseCredit = courseCredit;
        this.teacherID = teacherID;
        this.studentsLimit = studentsLimit;
        this.state = state;
        this.academicYear = academicYear;
        this.semester = semester;
        this.description = description;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseBaseID() {
        return courseBaseID;
    }

    public void setCourseBaseID(String courseBaseID) {
        this.courseBaseID = courseBaseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseTypeID() {
        return courseTypeID;
    }

    public void setCourseTypeID(String courseTypeID) {
        this.courseTypeID = courseTypeID;
    }

    public String getCollegeID() {
        return collegeID;
    }

    public void setCollegeID(String collegeID) {
        this.collegeID = collegeID;
    }

    public Double getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(Double courseCredit) {
        this.courseCredit = courseCredit;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public Integer getStudentsLimit() {
        return studentsLimit;
    }

    public void setStudentsLimit(Integer studentsLimit) {
        this.studentsLimit = studentsLimit;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(Integer academicYear) {
        this.academicYear = academicYear;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID='" + courseID + '\'' +
                ", courseBaseID='" + courseBaseID + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseTypeID='" + courseTypeID + '\'' +
                ", collegeID='" + collegeID + '\'' +
                ", courseCredit=" + courseCredit +
                ", teacherID='" + teacherID + '\'' +
                ", studentsLimit=" + studentsLimit +
                ", state=" + state +
                ", academicYear=" + academicYear +
                ", semester=" + semester +
                ", description='" + description + '\'' +
                '}';
    }
}
