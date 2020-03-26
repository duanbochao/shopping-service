package com.service;

import com.bean.Role;
import com.mapper.RoleMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/3/26 12:45
 */
@Service
public class RoleService {

    @Autowired
    RoleMapper roleMapper;


    public Integer updateMenuRoles(String mids,Integer rid){
        String[] split = mids.split(",");
        roleMapper.deleteMenuRoleByRid(rid);
        return roleMapper.addMenuRoles(split, rid);
    }


    public Integer addRole(Role role){

       if (!role.getName().startsWith("ROLE_")){
           String roleName="ROLE_"+role.getName();
           role.setName(roleName);
       }
        return roleMapper.addRole(role);
    }
}
