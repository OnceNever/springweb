package com.yanglei.springshiro.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //shiroFilterFactoryBean step3
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("getDefaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        //添加shiro内置过滤器
        /*
           anon: 无需认证就可访问
           authc: 必须认证了才能访问
           user: 必须拥有 记住我 功能才能使用
           perms: 拥有某个资源的权限才能访问
           role: 拥有某个角色权限才能访问
         */

        Map<String, String> filterMap = new LinkedHashMap<>();

        //授权,正常情况下未授权会跳转到未授权页面
        filterMap.put("/user/add", "perms[add]");
        filterMap.put("/user/update", "perms[update]");

        //拦截请求
        filterMap.put("/user/*", "authc");
        bean.setFilterChainDefinitionMap(filterMap);

        //设置未登录跳转页面
        bean.setLoginUrl("/toLogin");

        //设置未授权跳转页面
        bean.setUnauthorizedUrl("/noAuth");

        return bean;
    }

    //DefaultWebSecurityManager step2
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联realm对象
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //创建realm对象 需要自定义 step1
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }
}
