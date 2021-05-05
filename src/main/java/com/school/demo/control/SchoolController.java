package com.school.demo.control;

import com.school.demo.control.request.SchoolRequest;
import com.school.demo.control.response.SchoolResponse;
import com.school.demo.dto.GlobalResult;
import com.school.demo.entity.Information;
import com.school.demo.service.SchoolService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {
    @Autowired
    private SchoolService schoolService;
    /**查询高校数据
     */
    @ApiOperation(value = "查询高校数据")
    @ResponseBody
    @RequestMapping(value="/get-school-information",method= RequestMethod.POST)
    public GlobalResult getSchoolInformation(@RequestBody SchoolRequest schoolRequest){
        List<SchoolResponse> informations = schoolService.getSchoolInformation(schoolRequest);
        return GlobalResult.build(200, null, informations);
    }

    /**
     * 查看高校详情
     */
    @ApiOperation(value = "查看一个高校详情")
    @ResponseBody
    @RequestMapping(value="/get-school-one",method= RequestMethod.GET)
    public GlobalResult getSchoolOne(Integer schoolId){

        SchoolResponse information = schoolService.getSchoolOne(schoolId);
        return GlobalResult.build(200, null, information);
    }
}
