package com.mapper;

import com.bean.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/3/24 15:16
 */
public interface RoleMapper {
    List<Role> getAllRoles();

    Integer deleteRolesById(@Param("uid") Integer uid);

    Integer addRolesByIds(@Param("rids")String[] rids,@Param("uid") Integer uid);

}
