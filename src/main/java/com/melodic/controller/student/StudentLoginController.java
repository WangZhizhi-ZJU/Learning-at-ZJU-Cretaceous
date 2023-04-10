package com.melodic.controller.student;

import com.melodic.common.Result;
import com.melodic.pojo.account.Account;
import com.melodic.pojo.account.LoginRawData;
import com.melodic.pojo.account.SessionSaveData;
import com.melodic.pojo.account.Student;
import com.melodic.service.student.StudentLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/service/student")
public class StudentLoginController {

    @Autowired
    private StudentLoginService studentLoginService;

    @PostMapping("/login")
    @ResponseBody
    public Result<Boolean> loginValidate(HttpServletRequest request, HttpServletResponse response, @RequestBody LoginRawData data) {
        HttpSession session = request.getSession();
        String captcha = (String) session.getAttribute("captcha");
        if (!captcha.equalsIgnoreCase(data.getCaptcha())) {
            return Result.error(false, "验证码错误！");
        }
        Student student = studentLoginService.loginValidate(
                data.getAccountName(),
                data.getPassword()
        );
        if (student == null) {
            return Result.error(false, "用户名或密码错误！");
        } else {
            SessionSaveData account = new SessionSaveData(
                    Account.STUDENT,
                    student.getAccountID(),
                    student.getAccountName(),
                    student.getName()
            );
            session.setAttribute("account", account);
            if (data.getRemember()) {
                response.addCookie(new Cookie("accountName", data.getAccountName()));
                response.addCookie(new Cookie("password", data.getPassword()));
            }
            return Result.success(true, "登录成功！");
        }
    }

    @PostMapping("/logout")
    @ResponseBody
    public Result<Boolean> logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("account");
        return Result.success(true);
    }
}
