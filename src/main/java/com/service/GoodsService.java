package com.service;

import com.bean.CommonDetail;
import com.bean.Goods;
import com.mapper.CommonDetailMapper;
import com.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/3/12 17:23
 */
@Service
public class GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    CommonDetailMapper commonDetailMapper;

   public  List<Goods> getGoodsByPage(Integer page, Integer size){
        Integer start = (page-1)*size;
        return goodsMapper.getGoodsByPage(start, size);
    }

    public  List<CommonDetail> getGoodsListByGid(Integer gid){
        return commonDetailMapper.getGoodsListByGid(gid);
    }
}
