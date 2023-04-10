package com.melodic.controller.common;

import com.melodic.common.Result;
import com.melodic.pojo.basic.Major;
import com.melodic.service.common.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/service/common")
public class MajorController {


    @Autowired
    private MajorService majorService;

    @RequestMapping("/get-major-list/{collegeID}")
    @ResponseBody
    public Result<List<Major>> getMajorList(@PathVariable String collegeID) {
        List<Major> majors = majorService.getByCollegeID(collegeID);
        return Result.success(majors);
    }
}
