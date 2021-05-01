package com.school.demo.serviceImpl;

import com.school.demo.entity.Information;
import com.school.demo.mapper.InformationMapper;
import com.school.demo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**新闻类的业务层实现类
 * @author ly
 *
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private InformationMapper informationMapper;
    @Override
    public Information getNewsByNewsId(Integer id) {
        return informationMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Information> getNewsList() {
        return informationMapper.selectAll();
    }

}
