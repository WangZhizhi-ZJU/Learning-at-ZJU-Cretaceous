package com.melodic.service.common;

import com.melodic.dao.MajorClassDao;
import com.melodic.pojo.basic.MajorClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorClassService {

    @Autowired
    private MajorClassDao majorClassDao;

    public List<MajorClass> getByMajorID(String majorID) {
        return majorClassDao.getByMajorID(majorID);
    }
}
