package com.melodic.dao.provider;

import com.melodic.pojo.account.Student;
import org.apache.ibatis.jdbc.SQL;

public class StudentDaoProvider {

    public String update(Student student) {
        SQL statement = new SQL().UPDATE("student_account_data_lizp").WHERE("accountID = #{accountID}");
        if (student.getAccountName() != null) {
            statement.SET("accountName = #{accountName}");
        }
        if (student.getPassword() != null) {
            statement.SET("password = #{password}");
        }
        if (student.getAvatar() != null) {
            statement.SET("avatar = #{avatar}");
        }
        if (student.getName() != null) {
            statement.SET("name = #{name}");
        }
        if (student.getPhone() != null) {
            statement.SET("phone = #{phone}");
        }
        if (student.getPersonalID() != null) {
            statement.SET("personalID = #{personalID}");
        }
        if (student.getGender() != null) {
            statement.SET("gender = #{gender}");
        }
        if (student.getCollegeID() != null) {
            statement.SET("collegeID = #{collegeID}");
        }
        if (student.getMajorID() != null) {
            statement.SET("majorID = #{majorID}");
        }
        if (student.getMajorClassID() != null) {
            statement.SET("majorClassID = #{majorClassID}");
        }
        if (student.getJoinDate() != null) {
            statement.SET("joinDate = #{joinDate}");
        }
        if (student.getBirthDate() != null) {
            statement.SET("birthDate = #{birthDate}");
        }
        if (student.getRegion() != null) {
            statement.SET("region = #{region}");
        }
        return statement.toString();
    }
}
