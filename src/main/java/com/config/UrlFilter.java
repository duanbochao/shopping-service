package com.config;

import com.bean.Menu;
import com.bean.Role;
import com.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/3/15 9:01
 */
@Component
public class UrlFilter implements FilterInvocationSecurityMetadataSource {


    @Autowired
    MenuService menuService;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        AntPathMatcher matcher = new AntPathMatcher();
        String requestUrl = ((FilterInvocation) o).getRequestUrl();

        if ("/login_p".equals(matcher)){
            return null;
        }
        List<Menu> menus = menuService.getAllMenus();

        for (Menu menu : menus) {
            if (matcher.match(menu.getUrl(), requestUrl) && menu.getRoles().size()>0){
                List<Role> roles = menu.getRoles();
                int size = roles.size();
                String[] values = new String[size];
                for (int i = 0; i < roles.size(); i++) {
                    values[i]=roles.get(i).getNameZh();
                }
                return SecurityConfig.createList(values);
            }

        }

        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return SecurityConfig.class.isAssignableFrom(aClass);
    }
}
