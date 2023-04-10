package com.melodic.controller.common;

import com.melodic.common.Result;
import com.melodic.pojo.basic.College;
import com.melodic.service.common.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/service/common")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @RequestMapping("/get-college-list")
    @ResponseBody
    public Result<List<College>> getCollegeList() {
        List<College> colleges = collegeService.selectAll();
        return Result.success(colleges);
    }
}
