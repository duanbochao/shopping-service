package com.controller.admin.home;

import com.bean.*;
import com.service.ImageService;
import com.service.ShareService;
import com.service.UserService;
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

    @Autowired
    ShareService shareService;

    @Autowired
    UserService userService;

    /**
     * 获取轮播图
     * @return
     */
    @RequestMapping(value = "/web/getlunbo",method = RequestMethod.GET)
    public List<Rotation> getAllRotation(){
        return imageService.getAllRotation();
    }


    @RequestMapping("/getAllUser")
    public List<User> getAllUser(String keywords){
        return userService.getAllUser(keywords);
    }

    @RequestMapping("/getAllRoles")
    public List<Role> getAllRoles(){
        return userService.getAllRoles();
    }


    @RequestMapping("/updateRoles")
    public Integer updateRoles(String rids,Integer uid){
        return userService.updateRoles(rids, uid);
    }


    @RequestMapping("/updateUser")
    public Integer updateUser(User user){
        return userService.updateUser(user);
    }


    @RequestMapping("/deleteUserById")
    public Integer deleteUserById(Integer id){
        return userService.deleteUserById(id);
    }


}
