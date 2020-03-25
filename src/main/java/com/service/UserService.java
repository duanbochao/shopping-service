package com.service;

import com.bean.Role;
import com.bean.User;
import com.mapper.RoleMapper;
import com.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/3/14 18:48
 */
@Service
@Transactional
public class UserService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;


    @Autowired
    RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userMapper.loadUserByUsername(s);
        if (user==null){
            throw  new UsernameNotFoundException("用户名不存在!");
        }
        return user;
    }

    public List<User> getAllUser(String keywords){
        return userMapper.getAllUser(keywords);
    }

    public List<Role> getAllRoles(){
        return roleMapper.getAllRoles();
    }


    public Integer updateRoles(String rids,Integer uid){
        String[] split = rids.split(",");
        roleMapper.deleteRolesById(uid);
        return roleMapper.addRolesByIds(split, uid);
    }


    public Integer updateUser(User user){
        return userMapper.updateUser(user);
    }

    public Integer deleteUserById(Integer id){
        return userMapper.deleteUserById(id);
    }
}
