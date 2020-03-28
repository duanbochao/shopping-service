package com.mapper;

import com.bean.Role;
import com.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/3/14 18:48
 */
public interface UserMapper {

    User loadUserByUsername(String s);

    List<User> getAllUser(@Param("keywords") String keywords);

    Integer updateUser(User user);

    Integer deleteUserById(Integer id);

    Integer addUser(User user);

}
