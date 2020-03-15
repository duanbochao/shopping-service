package com.mapper;

import com.bean.User;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/3/14 18:48
 */
public interface UserMapper {

    User loadUserByUsername(String s);
}
