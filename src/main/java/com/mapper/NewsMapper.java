package com.mapper;

import com.bean.Comment;
import com.bean.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/3/8 17:11
 */
public interface NewsMapper {

    List<News> getNewsListById(@Param("id") Integer id);

    Integer addCount(@Param("id")Integer id);

    //后台查询接口
   List<News> getNewsListByPage(@Param("keywords") String keywords,@Param("start") Integer start,@Param("size") Integer size);

   Integer getTotal(@Param("keywords") String keywords);

   Integer updateNews(News news);

   Integer deleteNewsByIds(@Param("ids") String[] ids);

    Integer deleteNewsCommentCommonTableByIds(@Param("ids") String[] ids);

   Integer insertNewsList(@Param("news") News news);

}
