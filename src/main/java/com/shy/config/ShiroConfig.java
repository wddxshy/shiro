package com.shy.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: WeiDongDong
 * @Date 2020/4/18 21:25
 * @Description Shiro配置类
 */
@Configuration
public class ShiroConfig {

    @Bean
    public HashedCredentialsMatcher getHashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("sha-256");
        hashedCredentialsMatcher.setHashIterations(10000);
        return hashedCredentialsMatcher;
    }

    //自定义Realm
    @Bean
    public UserRealm userRealm() {
        UserRealm userRealm = new UserRealm();
        userRealm.setCredentialsMatcher(getHashedCredentialsMatcher());
        return userRealm;
    }

    //DefaultWebSecurityManager
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        //关联自定义Realm
        securityManager.setRealm(userRealm());
        return securityManager;
    }


    //替代ShiroFilterFactoryBean
    @Bean
    public ShiroFilterChainDefinition getShiroFilterChainDefinition(){
        DefaultShiroFilterChainDefinition bean = new DefaultShiroFilterChainDefinition();
        bean.addPathDefinition("/verifyImg","anon");
        bean.addPathDefinition("/account/**","anon");
        bean.addPathDefinition("/user/**","authc");
        bean.addPathDefinition("/**","authc");

        return bean;
    }


}
