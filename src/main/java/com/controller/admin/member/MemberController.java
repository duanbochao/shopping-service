package com.controller.admin.member;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/3/15 12:24
 */
@RestController
@RequestMapping("/member")
public class MemberController {

    @RequestMapping("/getAdminInfo")
    public String getAdmin(){
        return "这条信息只有超级管理员才能看到！~ V ~";
    }
}
