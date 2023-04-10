package com.melodic.service.common;

import com.melodic.dao.CollegeDao;
import com.melodic.pojo.basic.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeService {

    @Autowired
    private CollegeDao collegeDao;

    public List<College> selectAll() {
        return collegeDao.selectAll();
    }
}
