package com.melodic.controller.common;

import com.melodic.common.Result;
import com.melodic.util.Captcha;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/service/common")
public class CaptchaController {

    @RequestMapping("/get-captcha")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) {
        try {
            ServletOutputStream os = response.getOutputStream();
            HttpSession session = request.getSession();
            String captcha = Captcha.outputCaptchaImage(80, 40, os, 4);
            session.setAttribute("captcha", captcha);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
