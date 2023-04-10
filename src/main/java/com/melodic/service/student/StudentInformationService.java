package com.melodic.service.student;

import com.melodic.dao.StudentDao;
import com.melodic.pojo.account.Student;
import com.melodic.util.PasscodeEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentInformationService {

    @Autowired
    StudentDao studentDao;

    public Student passwordValidate(String accountName, String rawPassword) {
        String password = PasscodeEncoding.encodeBySHA256(rawPassword);
        return studentDao.selectByAccount(accountName, password);
    }

    public Student getInfoByAccountID(String accountID) {
        return studentDao.selectDetailByAccountID(accountID);
    }

    public boolean update(Student student) {
        return studentDao.update(student) >= 1;
    }
}
