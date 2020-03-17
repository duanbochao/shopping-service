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


    //前端查询接口
    public List<News> getNewsListById(Integer id){

        if (id!=null && !id.equals("")){
            newsMapper.addCount(id); //统计浏览次数
        }
        return newsMapper.getNewsListById(id);
    }

    //后台查询接口
    public  List<News> getNewsListByPage(String keywords,Integer page,Integer size){
        Integer start = (page - 1) * size;
        return newsMapper.getNewsListByPage(keywords, start, size);
    }
    //查询总页数
    public Integer getTotal(String keywords){
        return newsMapper.getTotal(keywords);
    }


    //修改新闻资讯
    public Integer updateNews(News news){
        return newsMapper.updateNews(news);
    }



}
