package com.yanglei.springweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//如果我们要扩展springmvc，官方建议我们这样去做
@Configuration
public class MyMvcConfiguration implements WebMvcConfigurer {

    //视图跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/login").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    //自定义国际化组件
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    /**
     * 自定义登录拦截器
     * @param registry
     */
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new LoginHandlerInterceptor()).
                addPathPatterns("/**").
                excludePathPatterns("/index", "/index.html", "/login", "/css/**", "/js/**", "/img/**");
    }
}