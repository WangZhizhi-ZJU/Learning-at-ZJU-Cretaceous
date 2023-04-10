package com.melodic.pojo.account;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.io.Serializable;
import java.time.LocalDate;

public class Teacher implements Account, Serializable {

    String accountID;
    String accountName;
    String password;
    String avatar;
    String name;
    String phone;
    String personalID;
    Integer gender;
    String collegeID;
    String collegeName;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Beijing")
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    LocalDate joinDate;
    String professionalTitle;
    String region;

    public Teacher() {}

    public Teacher(String accountID, String accountName, String password, String avatar, String name, String phone, String personalID, Integer gender, String collegeID, LocalDate joinDate, String professionalTitle, String region) {
        this.accountID = accountID;
        this.accountName = accountName;
        this.password = password;
        this.avatar = avatar;
        this.name = name;
        this.phone = phone;
        this.personalID = personalID;
        this.gender = gender;
        this.collegeID = collegeID;
        this.joinDate = joinDate;
        this.professionalTitle = professionalTitle;
        this.region = region;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPersonalID() {
        return personalID;
    }

    public void setPersonalID(String personalID) {
        this.personalID = personalID;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
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

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public String getProfessionalTitle() {
        return professionalTitle;
    }

    public void setProfessionalTitle(String professionalTitle) {
        this.professionalTitle = professionalTitle;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "accountID='" + accountID + '\'' +
                ", accountName='" + accountName + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", collegeID='" + collegeID + '\'' +
                ", joinDate=" + joinDate +
                ", professionalTitle='" + professionalTitle + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}
