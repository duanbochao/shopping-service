package com.mapper;

import com.bean.Menu;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/3/15 9:09
 */
public interface MenuMapper {

    List<Menu> getAllMenus();

    List<Menu> getMenusById(@Param("id") Integer id);

    List<Menu> getMenuTree();

    List<Integer> getMenuByRid(@Param("rid") Integer rid);
}
