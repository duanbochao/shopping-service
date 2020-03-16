package com.bean.utils;


import com.bean.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/3/14 20:07
 */
public class UserUtils {

    public static User getCurrentUser(){
        User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user;
    }
}
