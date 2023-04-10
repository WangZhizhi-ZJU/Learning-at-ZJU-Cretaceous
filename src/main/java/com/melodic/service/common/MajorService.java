package com.melodic.service.common;

import com.melodic.dao.MajorDao;
import com.melodic.pojo.basic.Major;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorService {

    @Autowired
    private MajorDao majorDao;

    public List<Major> getByCollegeID(String collegeID) {
        return majorDao.getByCollegeID(collegeID);
    }
}
