package com.shy.config;

import com.shy.beans.Account;
import com.shy.service.LoginService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: WeiDongDong
 * @Date 2020/4/19 13:26
 * @Description
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private LoginService loginServiceimpl;

    //权限认证
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //身份认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        Account account = loginServiceimpl.queryAccountByLogin(username);
        if (account==null){
            return null;
        }
        return new SimpleAuthenticationInfo("",account.getAPassword(),"");
    }
}
