package com.melodic.service.student;

import com.melodic.common.Result;
import com.melodic.dao.StudentDao;
import com.melodic.pojo.account.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentRegisterService {

    @Autowired
    private StudentDao studentDao;

    public Result<Boolean> checkRegisterRequest(String accountName, String phone, String personalID) {
        if (studentDao.countByAccountName(accountName) != 0) {
            return Result.error(false, "当前账户已被注册！");
        } else if (studentDao.countByPhone(phone) != 0) {
            return Result.error(false, "当前手机号已被注册！");
        } else if (studentDao.countByPersonalID(personalID) != 0) {
            return Result.error(false, "当前身份证已被注册！");
        }
        return Result.success(true);
    }

    public Result<String> getAvailableAccountID(String prefix) {
        String pattern = prefix + ".....";
        String exist = studentDao.getMaxAccountIDAsPattern(pattern);
        if (exist == null) {
            return Result.success(prefix + "00000");
        } else {
            long accountID = Long.parseLong(exist);
            if (accountID % 100000 == 99999) {
                return Result.error(null, "学工号分配异常，请联系管理员！");
            } else {
                return Result.success(String.format("%10d", accountID + 1));
            }
        }
    }

    public boolean register(Student student) {
        int count = studentDao.insert(student);
        return count >= 1;
    }
}
