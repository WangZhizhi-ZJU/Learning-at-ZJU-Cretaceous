package com.melodic.controller.student;

import com.melodic.common.Result;
import com.melodic.pojo.account.Account;
import com.melodic.pojo.account.SessionSaveData;
import com.melodic.pojo.account.Student;
import com.melodic.service.student.StudentRegisterService;
import com.melodic.util.PasscodeEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

@Controller
@RequestMapping("/service/student")
public class StudentRegisterController {

    @Autowired
    private StudentRegisterService studentRegisterService;

    @RequestMapping("/register/{captcha}")
    @ResponseBody
    public Result<Boolean> register(HttpServletRequest request, @RequestBody Student student, @PathVariable String captcha) {
        HttpSession session = request.getSession();
        if (!((String) session.getAttribute("captcha")).equalsIgnoreCase(captcha)) {
            return Result.error(false, "验证码错误！");
        }

        Result<Boolean> resultCheck = studentRegisterService.checkRegisterRequest(student.getAccountName(), student.getPhone(), student.getPersonalID());
        if (resultCheck.getCode() == Result.FAILED) {
            return resultCheck;
        }

        String accountID = new StringBuilder().append(3).append(String.format("%02d", student.getJoinDate().getYear() % 100)).append("01").toString();
        Result<String> resultAccountID = studentRegisterService.getAvailableAccountID(accountID);
        if (resultAccountID.getCode() == Result.FAILED) {
            return Result.error(false, resultAccountID.getMessage());
        }
        student.setAccountID(resultAccountID.getData());

        String encodedPassword = PasscodeEncoding.encodeBySHA256(student.getPassword());
        student.setPassword(encodedPassword);
        student.setAvatar("http://localhost/service/common/get-avatar/" + student.getAccountID());

        boolean register = studentRegisterService.register(student);

        if (!register) {
            return Result.error(false, "由于服务器异常，注册失败，请稍后再试！");
        }

        session.setAttribute("account", new SessionSaveData(
                Account.STUDENT,
                student.getAccountID(),
                student.getAccountName(),
                student.getName()
        ));
        return Result.success(true);
    }

    @RequestMapping("/register-avatar")
    @ResponseBody
    public Result<Boolean> registerAvatar(HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file) {
        HttpSession session = request.getSession();
        SessionSaveData account = (SessionSaveData) session.getAttribute("account");
        if (account == null) {
            return Result.error(false, "注册成功，但是头像上传存在异常，请稍后在个人信息管理处进行设置！");
        }
        String avatar = System.getProperty("user.dir") + "/src/main/resources/static/avatar/" + account.getAccountID() + ".jpg";
        try {
            if (file != null) {
                file.transferTo(new File(avatar));
            } else {
                String path = "D:\\xx";
                try (FileChannel in = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/static/avatar/default.jpg").getChannel();
                     FileChannel out = new FileOutputStream(avatar).getChannel()) {
                    out.transferFrom(in, 0, in.size());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return Result.success(true, "注册成功");
        } catch (IOException e) {
            return Result.error(false, "注册成功，但是头像上传存在异常，请稍后在个人信息管理处进行设置！");
        }
    }
}
