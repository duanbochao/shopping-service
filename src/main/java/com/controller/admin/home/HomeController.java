package com.controller.admin.home;

import com.bean.*;
import com.service.ImageService;
import com.service.ShareService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.plugin.com.Utils;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

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


    /**
     * 添加用户
     */
    @RequestMapping("/web/addTouristName")
    public HashMap<String, Object> addTourist(){
        User user = new User();
        String username = UUID.randomUUID().toString();//创建用户名
        String pwd = UUID.randomUUID().toString();//创建密码
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode(pwd);
        user.setUsername(username);
        user.setPassword(password);
        user.setEnabled(true);
        Integer i = userService.addUser(user);

        HashMap<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("password", pwd);
        map.put("userface", "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3451096375,2110457866&fm=26&gp=0.jpg");
        if (i>0){
            return map;
        }
        return null;
    }

}
