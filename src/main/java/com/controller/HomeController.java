package com.controller;

import com.bean.Rotation;
import com.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/3/8 11:15
 */

@RestController
@RequestMapping("/home/lunbo")
public class HomeController {

    @Autowired
    ImageService imageService;

    /**
     * 获取轮播图
     * @return
     */
    @RequestMapping(value = "/web/getlunbo",method = RequestMethod.GET)
    public List<Rotation> getAllRotation(){
        return imageService.getAllRotation();
    }
}
