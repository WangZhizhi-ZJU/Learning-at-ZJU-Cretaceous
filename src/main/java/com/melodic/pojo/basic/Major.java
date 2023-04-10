package com.melodic.pojo.basic;

import java.io.Serializable;

public class Major implements Serializable {

    String majorID;
    String majorName;
    String collegeID;

    public Major() {}

    public Major(String majorID, String majorName, String collegeID) {
        this.majorID = majorID;
        this.majorName = majorName;
        this.collegeID = collegeID;
    }

    public String getMajorID() {
        return majorID;
    }

    public void setMajorID(String majorID) {
        this.majorID = majorID;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getCollegeID() {
        return collegeID;
    }

    public void setCollegeID(String collegeID) {
        this.collegeID = collegeID;
    }

    @Override
    public String toString() {
        return "Major{" +
                "majorID='" + majorID + '\'' +
                ", majorName='" + majorName + '\'' +
                ", collegeID='" + collegeID + '\'' +
                '}';
    }
}
