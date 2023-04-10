package com.melodic.pojo.basic;

import java.io.Serializable;

public class College implements Serializable {

    String collegeID;
    String collegeName;

    public College() {}

    public College(String collegeID, String collegeName) {
        this.collegeID = collegeID;
        this.collegeName = collegeName;
    }

    public String getCollegeID() {
        return collegeID;
    }

    public void setCollegeID(String collegeID) {
        this.collegeID = collegeID;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    @Override
    public String toString() {
        return "College{" +
                "collegeID='" + collegeID + '\'' +
                ", collegeName='" + collegeName + '\'' +
                '}';
    }
}
