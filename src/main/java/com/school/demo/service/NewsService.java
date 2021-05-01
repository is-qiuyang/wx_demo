package com.school.demo.service;

import com.school.demo.entity.Information;

import java.util.List;

/**新闻类业务层接口
 * @author ly
 *
 */
public interface NewsService {
    Information getNewsByNewsId(Integer id);

    List<Information> getNewsList();

}
