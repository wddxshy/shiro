package com.shy.config;

import com.shy.beans.Account;
import com.shy.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

/**
 * @Author: WeiDongDong
 * @Date 2020/4/19 13:26
 * @Description
 */
@Slf4j
public class UserRealm extends AuthorizingRealm {

    @Resource
    private LoginService loginServiceImpl;


    //权限认证
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        return null;
    }

    //身份认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        Account account = loginServiceImpl.queryAccountByLogin(username);
        log.info("数据库查询用户信息 -->"+account.toString());
        if (account==null){
            return null;
        }
        //                                      数据库中的用户名          数据库中的密码                 盐                      自定义realm，通常指代继承AuthorizingRealm的类(当前类)
        return new SimpleAuthenticationInfo(account.getAusername(),account.getApassword(), ByteSource.Util.bytes(username),this.getName());
    }


}
