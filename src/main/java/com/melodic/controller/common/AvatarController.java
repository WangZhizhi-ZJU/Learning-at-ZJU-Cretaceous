package com.melodic.controller.common;

import com.melodic.common.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
@RequestMapping("/service/common")
public class AvatarController {

    @RequestMapping("/get-avatar/{accountID}")
    public void getAvatar(HttpServletRequest request, HttpServletResponse response, @PathVariable String accountID) {
        String avatar = "src/main/resources/static/avatar/" + accountID + ".jpg";
        try {
            FileInputStream fis = new FileInputStream(avatar);
            ServletOutputStream os = response.getOutputStream();
            os.write(fis.readAllBytes());
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/set-avatar/{accountID}")
    @ResponseBody
    public Result<Boolean> setAvatar(HttpServletRequest request, HttpServletResponse response, @PathVariable String accountID, MultipartFile file) {
        String avatar = System.getProperty("user.dir") + "/src/main/resources/static/avatar/" + accountID + ".jpg";
        try {
            file.transferTo(new File(avatar));
            return Result.success(true);
        } catch (IOException e) {
            return Result.error(false, "头像上传失败，请联系管理员！");
        }
    }


    @RequestMapping("/upload-avatar")
    @ResponseBody
    public void uploadAvatar() {

    }
}
