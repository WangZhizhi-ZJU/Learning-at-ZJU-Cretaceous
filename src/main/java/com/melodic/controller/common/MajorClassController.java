package com.melodic.controller.common;

import com.melodic.common.Result;
import com.melodic.pojo.basic.Major;
import com.melodic.pojo.basic.MajorClass;
import com.melodic.service.common.MajorClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/service/common")
public class MajorClassController {


    @Autowired
    private MajorClassService majorClassService;

    @RequestMapping("/get-major-class-list/{majorID}")
    @ResponseBody
    public Result<List<MajorClass>> getMajorClassList(@PathVariable String majorID) {
        List<MajorClass> majorClasses = majorClassService.getByMajorID(majorID);
        return Result.success(majorClasses);
    }
}
