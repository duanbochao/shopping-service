package com.controller.goods;

import com.bean.Goods;
import com.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/getGoodsByPage")
    List<Goods> getGoodsByPage(Integer page){
        return goodsService.getGoodsByPage(page, 5);
    }


}
