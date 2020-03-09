package com.service;

import com.bean.News;
import com.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/3/8 17:11
 */
@Service
public class NewsService {

    @Autowired
    NewsMapper newsMapper;


    public List<News> getNewsListById(Integer id){

        if (id!=null && !id.equals("")){
            newsMapper.addCount(id); //统计浏览次数
        }
        return newsMapper.getNewsListById(id);
    }


}
