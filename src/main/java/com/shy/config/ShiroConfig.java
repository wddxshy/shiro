package com.shy.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: WeiDongDong
 * @Date 2020/4/18 21:25
 * @Description  Shiro配置类
 */
@Configuration
public class ShiroConfig {

    //ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(/*@Qualifier("securityManager")*/ DefaultWebSecurityManager DefaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();

        //设置安全管理器
        bean.setSecurityManager(DefaultWebSecurityManager);

        //添加shiro的内置过滤器
        Map<String,String> filterMap = new LinkedHashMap<>();
        filterMap.put("/user/add","authc");
        filterMap.put("/user/update","authc");
        filterMap.put("/user/*","authc");
        bean.setFilterChainDefinitionMap(filterMap);

        return bean;
    }

    //DefaultWebSecurityManager
    @Bean/*(name="securityManager")*/
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        //关联自定义Realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //自定义Realm
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }

}
