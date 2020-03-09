package com.mapper;

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
}
