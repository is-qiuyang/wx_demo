package com.school.demo.control;

import com.school.demo.control.request.SchoolLikeRequest;
import com.school.demo.control.response.SchoolResponse;
import com.school.demo.dto.GlobalResult;
import com.school.demo.entity.Information;
import com.school.demo.service.SchoolLikeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolLikeContrller {
    @Autowired
    private SchoolLikeService schoolLikeService;
    /**收藏高校
     */
    @ApiOperation(value = "收藏高校")
    @ResponseBody
    @RequestMapping(value="/add-school-like",method= RequestMethod.POST)
    public GlobalResult addSchoolLike(@RequestBody SchoolLikeRequest schoolLikeRequest){
        Boolean flag = schoolLikeService.addSchoolLike(schoolLikeRequest);
        return GlobalResult.build(200, "成功添加或删除", flag);
    }

    /** 获取高校收藏状态
     */
    @ApiOperation(value = " 获取高校收藏状态")
    @ResponseBody
    @RequestMapping(value="/get-school-like-status",method= RequestMethod.POST)
    public GlobalResult getSchoolLikeStatus(@RequestBody SchoolLikeRequest schoolLikeRequest){
        Boolean flag = schoolLikeService.getSchoolLikeStatus(schoolLikeRequest);
        return GlobalResult.build(200, null, flag);
    }

    /** 获取某个用户收藏的高校列表
     */
    @ApiOperation(value = " 获取某个用户收藏的高校列表")
    @ResponseBody
    @RequestMapping(value="/get-user-school-like",method= RequestMethod.POST)
    public GlobalResult getUserSchoolLike(@RequestBody SchoolLikeRequest schoolLikeRequest){
        List<SchoolResponse> responses= schoolLikeService.getUserSchoolLike(schoolLikeRequest);
        return GlobalResult.build(200, null, responses);
    }
}
