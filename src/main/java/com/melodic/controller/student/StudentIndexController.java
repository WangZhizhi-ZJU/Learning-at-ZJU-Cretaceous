package com.melodic.controller.student;

import com.melodic.common.Result;
import com.melodic.pojo.account.Account;
import com.melodic.pojo.account.SessionSaveData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/service/student")
public class StudentIndexController {

    @PostMapping("/get-account")
    @ResponseBody
    public Result<SessionSaveData> getAccount(HttpServletRequest request) {
        HttpSession session = request.getSession();

        // Developing...
        session.setAttribute("account", new SessionSaveData(
                3,
                "3200100001",
                "3200100001@zju.edu.cn",
                "彭鹏"
        ));

        SessionSaveData account = (SessionSaveData) session.getAttribute("account");
        if (account == null || !Account.STUDENT.equals(account.getAccountType())) {
            return Result.error(null, "账号未登录！");
        } else {
            return Result.success(account);
        }
    }
}
