package com.melodic.service.student;

import com.melodic.dao.StudentDao;
import com.melodic.pojo.account.Student;
import com.melodic.util.PasscodeEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentLoginService {

    @Autowired
    private StudentDao studentDao;

    public Student loginValidate(String accountName, String rawPassword) {
        String password = PasscodeEncoding.encodeBySHA256(rawPassword);
        return studentDao.selectByAccount(accountName, password);
    }
}
