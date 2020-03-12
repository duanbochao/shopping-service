package com.mapper;

import com.bean.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/3/12 17:20
 */
public interface GoodsMapper {

   List<Goods> getGoodsByPage(@Param("start") Integer start,@Param("size") Integer size);
}
