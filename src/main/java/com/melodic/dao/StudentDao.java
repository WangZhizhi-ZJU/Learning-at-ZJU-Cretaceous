package com.melodic.dao;

import com.melodic.common.RedisCache;
import com.melodic.dao.provider.StudentDaoProvider;
import com.melodic.pojo.account.Student;
import org.apache.ibatis.annotations.*;

@Mapper
// @CacheNamespace(implementation = RedisCache.class)
public interface StudentDao {

    @Select("select * from student_account_data_lizp where accountID = #{accountID}")
    Student selectByAccountID(String accountID);

    @Select("select accountID, accountName, password, avatar, name, phone, personalID, gender, c.collegeID as collegeID, m.majorID as majorID, mc.majorClassID as majorClassID, joinDate, birthDate, region, majorName, majorClassName, collegeName\n" +
            "from student_account_data_lizp as s\n" +
            "    left outer join major_data_lizp m on s.majorID = m.majorID\n" +
            "    left outer join major_class_data_lizp mc on s.majorID = mc.majorID\n" +
            "    left outer join college_data_lizp c on s.collegeID = c.collegeID\n" +
            "where accountID = #{accountID}")
    Student selectDetailByAccountID(String accountID);

    @Select("select * from student_account_data_lizp where accountName = #{accountName} and password = #{password}")
    Student selectByAccount(@Param("accountName") String accountName, @Param("password") String password);

    @Insert("insert into student_account_data_lizp values(#{accountID}, #{accountName}, #{password}, #{avatar}, #{name}, #{phone}, #{personalID}, #{gender}, #{collegeID}, #{majorID}, #{majorClassID}, #{joinDate}, #{birthDate}, #{region})")
    int insert(Student student);

    @UpdateProvider(type = StudentDaoProvider.class, method = "update")
    int update(Student student);

    @Select("select count(1) from student_account_data_lizp where phone = #{phone}")
    int countByPhone(String phone);

    @Select("select count(1) from student_account_data_lizp where accountName = #{accountName}")
    int countByAccountName(String accountName);

    @Select("select count(1) from student_account_data_lizp where personalID = #{personalID}")
    int countByPersonalID(String personalID);

    @Select("select max(accountID) from student_account_data_lizp where accountID regexp #{pattern}")
    String getMaxAccountIDAsPattern(String pattern);
}
