package com.melodic.controller.student;

import com.melodic.common.Result;
import com.melodic.pojo.account.SessionSaveData;
import com.melodic.pojo.account.Student;
import com.melodic.service.student.StudentInformationService;
import com.melodic.util.PasscodeEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/service/student")
public class StudentInformationController {

    @Autowired
    private StudentInformationService studentInformationService;

    @RequestMapping("/get-info")
    @ResponseBody
    public Result<Student> getInfo(HttpServletRequest request) {
        HttpSession session = request.getSession();
        SessionSaveData account = (SessionSaveData) session.getAttribute("account");
        if (account == null) {
            return Result.error(null, "登录信息过期，请重新登录！");
        } else {
            Student student = studentInformationService.getInfoByAccountID(account.getAccountID());
            student.setPassword("");
            return Result.success(student);
        }
    }

    @RequestMapping("/modify-info/{captcha}")
    @ResponseBody
    public Result<Boolean> modifyBasicInformation(HttpServletRequest request, @RequestBody Student student, @PathVariable String captcha) {
        HttpSession session = request.getSession();
        SessionSaveData account = (SessionSaveData) session.getAttribute("account");
        if (account == null) {
            return Result.error(null, "登录信息过期，请重新登录！");
        } else {
            if (!((String) session.getAttribute("captcha")).equalsIgnoreCase(captcha)) {
                return Result.error(false, "验证码错误！");
            } else {
                boolean flag = studentInformationService.update(new Student(
                        student.getAccountID(),
                        null,
                        null,
                        null,
                        null,
                        student.getPhone(),
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        student.getBirthDate(),
                        student.getRegion()
                ));
                if (flag) {
                    return Result.success(true, "信息修改成功！");
                } else {
                    return Result.success(false, "信息修改发生异常，请联系管理员！");
                }
            }
        }
    }

    @GetMapping("/modify-password")
    @ResponseBody
    public Result<Boolean> modifyPassword(HttpServletRequest request, String accountName, String password, String newPassword, String captcha) {
        HttpSession session = request.getSession();
        SessionSaveData account = (SessionSaveData) session.getAttribute("account");
        if (account == null) {
            return Result.error(null, "登录信息过期，请重新登录！");
        } else {
            if (!((String) session.getAttribute("captcha")).equalsIgnoreCase(captcha)) {
                return Result.error(false, "验证码错误！");
            } else {
                Student student = studentInformationService.passwordValidate(accountName, password);
                boolean flag = studentInformationService.update(new Student(
                        student.getAccountID(),
                        null,
                        PasscodeEncoding.encodeBySHA256(newPassword),
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null
                ));
                if (flag) {
                    return Result.success(true, "密码修改成功！");
                } else {
                    return Result.success(false, "密码修改发生异常，请联系管理员！");
                }
            }
        }
    }
}
