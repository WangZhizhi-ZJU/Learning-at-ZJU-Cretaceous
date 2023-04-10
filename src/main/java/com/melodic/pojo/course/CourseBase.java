package com.melodic.pojo.course;

import java.io.Serializable;

public class CourseBase implements Serializable {

    String courseBaseID;
    String courseName;
    String courseTypeID;
    String collegeID;
    Double courseCredit;
    Integer unavailable;
    String description;

    public CourseBase() {}

    public CourseBase(String courseBaseID, String courseName, String courseTypeID, String collegeID, Double courseCredit, Integer unavailable, String description) {
        this.courseBaseID = courseBaseID;
        this.courseName = courseName;
        this.courseTypeID = courseTypeID;
        this.collegeID = collegeID;
        this.courseCredit = courseCredit;
        this.unavailable = unavailable;
        this.description = description;
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

    public Integer getUnavailable() {
        return unavailable;
    }

    public void setUnavailable(Integer unavailable) {
        this.unavailable = unavailable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CourseBase{" +
                "courseBaseID='" + courseBaseID + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseTypeID='" + courseTypeID + '\'' +
                ", collegeID='" + collegeID + '\'' +
                ", courseCredit=" + courseCredit +
                ", unavailable=" + unavailable +
                ", description='" + description + '\'' +
                '}';
    }
}
