package com.melodic.pojo.basic;

import java.io.Serializable;

public class MajorClass implements Serializable {

    String majorClassID;
    String majorClassName;
    String majorID;

    public MajorClass() {}

    public MajorClass(String majorClassID, String majorClassName, String majorID) {
        this.majorClassID = majorClassID;
        this.majorClassName = majorClassName;
        this.majorID = majorID;
    }

    public String getMajorClassID() {
        return majorClassID;
    }

    public void setMajorClassID(String majorClassID) {
        this.majorClassID = majorClassID;
    }

    public String getMajorClassName() {
        return majorClassName;
    }

    public void setMajorClassName(String majorClassName) {
        this.majorClassName = majorClassName;
    }

    public String getMajorID() {
        return majorID;
    }

    public void setMajorID(String majorID) {
        this.majorID = majorID;
    }

    @Override
    public String toString() {
        return "MajorClass{" +
                "majorClassID='" + majorClassID + '\'' +
                ", majorClassName='" + majorClassName + '\'' +
                ", majorID='" + majorID + '\'' +
                '}';
    }
}
