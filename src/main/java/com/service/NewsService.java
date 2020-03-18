package com.service;

import com.bean.News;
import com.mapper.CommentMapper;
import com.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/3/8 17:11
 */
@Service
@Transactional
public class NewsService {

    @Autowired
    NewsMapper newsMapper;

    @Autowired
    CommentMapper commentMapper;

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

    //添加新闻资讯
    public  Integer addNewsList(News news){
        news.setEnabled(true);
        news.setSummary("暂无介绍...");
        return newsMapper.insertNewsList(news);
    }


    public Integer deleteNewsById(String ids){
        String[] split = ids.split(",");
        //1、删除评论表
        commentMapper.deleteCommentByIds(split);
        //2、删除资讯评论公共表
        newsMapper.deleteNewsCommentCommonTableByIds(split);
        //3、删除资讯表
        return newsMapper.deleteNewsByIds(split);
    }

}
