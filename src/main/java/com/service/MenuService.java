package com.service;

import com.bean.Menu;
import com.bean.utils.UserUtils;
import com.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/3/15 9:31
 */
@Service
@Transactional
public class MenuService {

    @Autowired
    MenuMapper menuMapper;

    public List<Menu> getAllMenus(){
        return menuMapper.getAllMenus();
    }

    public  List<Menu> getMenusById(){
        return menuMapper.getMenusById(UserUtils.getCurrentUser().getId());
    }

}
