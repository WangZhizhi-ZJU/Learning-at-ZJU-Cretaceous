package com.melodic.dao;

import com.melodic.pojo.basic.Major;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MajorDao {

    @Select("select * from major_data_lizp")
    List<Major> selectAll();

    @Select("select majorName, majorID from major_data_lizp where collegeID = #{collegeID}")
    List<Major> getByCollegeID(String collegeID);
}
