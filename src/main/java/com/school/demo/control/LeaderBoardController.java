package com.school.demo.control;

import com.school.demo.control.request.LeaderBoardRequest;
import com.school.demo.control.request.LeaderBoardValueRequest;
import com.school.demo.control.response.LeaderBoardResponse;
import com.school.demo.dto.GlobalResult;
import com.school.demo.entity.Information;
import com.school.demo.service.LeaderBoardService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LeaderBoardController {
    @Autowired
    private LeaderBoardService leaderBoardService;

    /**查询全部的的榜单
     */
    @ApiOperation(value = "查询全部的的榜单")
    @ResponseBody
    @RequestMapping(value="/get-all-board",method= RequestMethod.GET)
    public GlobalResult getAllBoard(){
        List<LeaderBoardResponse> informations = leaderBoardService.getAllBoard();
        return GlobalResult.build(200, null, informations);
    }

    /**增加榜单
     */
    @ApiOperation(value = "增加榜单")
    @ResponseBody
    @RequestMapping(value="/add-board",method= RequestMethod.POST)
    public GlobalResult addBoard(@RequestBody LeaderBoardRequest leaderBoardRequest){
        Boolean flag = leaderBoardService.addBoard(leaderBoardRequest);
        return GlobalResult.build(200, null, flag);
    }

    /**删除榜单
     */
    @ApiOperation(value = "删除榜单")
    @ResponseBody
    @RequestMapping(value="/delete-board",method= RequestMethod.POST)
    public GlobalResult deleteBoard(@RequestBody LeaderBoardRequest leaderBoardRequest){
        Boolean flag = leaderBoardService.deleteBoard(leaderBoardRequest);
        return GlobalResult.build(200, null, flag);
    }

    /**修改榜单
     */
    @ApiOperation(value = "修改榜单")
    @ResponseBody
    @RequestMapping(value="/update-board",method= RequestMethod.POST)
    public GlobalResult updateBoard(@RequestBody LeaderBoardRequest leaderBoardRequest){
        Boolean flag = leaderBoardService.updateBoard(leaderBoardRequest);
        return GlobalResult.build(200, null, flag);
    }
    /**修改榜单值
     */
    @ApiOperation(value = "修改榜单值")
    @ResponseBody
    @RequestMapping(value="/update-board-value",method= RequestMethod.POST)
    public GlobalResult updateBoardValue(@RequestBody LeaderBoardValueRequest leaderBoardValueRequest){
        Boolean flag = leaderBoardService.updateBoardValue(leaderBoardValueRequest);
        return GlobalResult.build(200, null, flag);
    }
    /**增加榜单值
     */
    @ApiOperation(value = "增加榜单值")
    @ResponseBody
    @RequestMapping(value="/add-board-value",method= RequestMethod.POST)
    public GlobalResult addBoardValue(@RequestBody LeaderBoardValueRequest leaderBoardValueRequest){
        Boolean flag = leaderBoardService.addBoardValue(leaderBoardValueRequest);
        return GlobalResult.build(200, null, flag);
    }

    /**删除榜单值
     */
    @ApiOperation(value = "删除榜单值")
    @ResponseBody
    @RequestMapping(value="/delete-board-value",method= RequestMethod.POST)
    public GlobalResult deleteBoardValue(@RequestBody LeaderBoardValueRequest leaderBoardValueRequest){
        Boolean flag = leaderBoardService.deleteBoardValue(leaderBoardValueRequest);
        return GlobalResult.build(200, null, flag);
    }
}
