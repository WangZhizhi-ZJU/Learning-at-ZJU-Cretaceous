package com.melodic.dao;

import com.melodic.pojo.basic.College;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
// @CacheNamespace(implementation = RedisCache.class)
public interface CollegeDao {

    @Select("select * from college_data_lizp")
    List<College> selectAll();
}
