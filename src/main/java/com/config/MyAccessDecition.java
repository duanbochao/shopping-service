package com.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author duanbochao
 * @version 1.0
 * @date 2020/3/15 9:39
 */
@Component
public class MyAccessDecition implements AccessDecisionManager {
    @Override
    public void decide(Authentication auth, Object o, Collection<ConfigAttribute> cas) throws AccessDeniedException, InsufficientAuthenticationException {
        Iterator<ConfigAttribute> iterator = cas.iterator();

        while (iterator.hasNext()){

            ConfigAttribute ca = iterator.next();
            String needRoles = ca.getAttribute();

            if ("ROLE_LOGIN".equals(needRoles)){
                if (auth instanceof AnonymousAuthenticationToken){
                   throw new BadCredentialsException("未登录");
                }
                return;
            }

            Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();

            for (GrantedAuthority authority : authorities) {

                if (authority.getAuthority().equals(needRoles)){
                    return;
                }
            }
        }
        throw new AccessDeniedException("权限不足!");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
