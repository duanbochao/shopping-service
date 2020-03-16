package com.controller;

import com.bean.Menu;
import com.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/3/15 17:42
 */
@RestController
@RequestMapping("/config")
public class MenuController {

    @Autowired
    MenuService menuService;

    @RequestMapping("/getMenusById")
    public List<Menu> getMenuById(){
        return menuService.getMenusById();
    }
}
