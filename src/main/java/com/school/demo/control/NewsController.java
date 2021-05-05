package com.school.demo.control;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.school.demo.dto.GlobalResult;
import com.school.demo.entity.Information;
import com.school.demo.entity.News;
import com.school.demo.service.NewsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**微信小程序实际使用的后端控制层
 * @author ly
 *
 */
@Controller
@RequestMapping("/news")
public class NewsController {
	@Autowired
	private NewsService newsService;

    /**查询全部的的新闻表信息
     */
	@ApiOperation(value = "查询全部的的新闻表信息")
    @ResponseBody
    @RequestMapping(value="/getNewsList",method=RequestMethod.GET)
    public GlobalResult getNewsByNewsId(){
        List<Information> informations = newsService.getNewsList();
        return GlobalResult.build(200, null, informations);
    }

	/**根据id查询对应的新闻表信息
	 * @param id 要查询的新闻id号码
	 * @return JSON类型的指定新闻id的新闻表信息
	 */
	@ApiOperation(value = "根据id查询对应的新闻表信息")
	@ResponseBody
	@RequestMapping(value="/getNewsByNewsId",method=RequestMethod.GET)
	public GlobalResult getNewsByNewsId(@RequestParam("id")Integer id){
		Information information=newsService.getNewsByNewsId(id);
		return GlobalResult.build(200, null, information);
	}
}
