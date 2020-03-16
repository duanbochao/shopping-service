package com.controller.admin.home.news;

import com.bean.News;
import com.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/3/8 17:14
 */
@RestController
@RequestMapping("/home/news")
public class NewsController {

    @Autowired
    NewsService newsService;

    /**
     * 获取新闻列表
     * @return
     */
    @RequestMapping(value = "/web/getNewsListById",method = RequestMethod.GET)
    public List<News> getNewsListById(@RequestParam(defaultValue = "",value = "id", required = false)Integer id){
        return newsService.getNewsListById(id);
    }

    @RequestMapping("/getAdmin")
    public String getTest(){
        return "超级管理员才能看到的信息";
    }

    /**
     * 后台查询接口
     * @param keywords
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/getNewsListByPage")
    public Map<String,Object> getNewsListByPage(String keywords, Integer page, Integer size){
        List<News> newsList = newsService.getNewsListByPage(keywords, page, size);
        HashMap<String, Object> map = new HashMap<>();
        map.put("newsList",newsList );
        map.put("total", newsService.getTotal(keywords));
        return map;
    }
}