package com.controller.goods;

import com.bean.CommonDetail;
import com.bean.Goods;
import com.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/3/12 17:25
 */
@RestController
@RequestMapping("/home/goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    /***
     * 分页查询商品列表中
     * @param page
     * @return
     */
    @RequestMapping("/getGoodsByPage")
   public List<Goods> getGoodsByPage(Integer page){
        return goodsService.getGoodsByPage(page, 5);
    }

    /**
     * 根据商品的id获取商品的详情轮播图
     * @param gid
     * @return
     */
    @RequestMapping(value = "/getGoodsListByGid/{gid}",method = RequestMethod.GET)
    public  List<CommonDetail> getGoodsListByGid(@PathVariable Integer gid){
        return goodsService.getGoodsListByGid(gid);
    }

}
