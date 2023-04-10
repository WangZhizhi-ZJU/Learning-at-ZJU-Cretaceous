package com.melodic.dao;

import com.melodic.pojo.basic.MajorClass;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MajorClassDao {

    @Select("select * from major_class_data_lizp")
    List<MajorClass> selectAll();

    @Select("select majorClassID, majorClassName from major_class_data_lizp where majorID = #{majorID}")
    List<MajorClass> getByMajorID(String majorID);
}
