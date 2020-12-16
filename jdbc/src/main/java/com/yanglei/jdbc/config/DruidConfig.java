package com.yanglei.jdbc.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    //后台监控
    //因为springboot内置了servlet容器，所以没有web.xml.替代方法 ServletRegistrationBean
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        //后台账号密码配置
        HashMap<String, String> initParams = new HashMap<>();
        //增加配置
        initParams.put("loginUsername", "admin");//key是固定的
        initParams.put("loginPassword", "admin");

        //允许谁可以访问
        initParams.put("allow", "");//value为空代表所有人可以访问

        bean.setInitParameters(initParams);//设置初始化参数
        return bean;
    }

    //过滤
    @Bean
    public FilterRegistrationBean filter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        //过滤请求
        Map<String, String> initParams = new HashMap<>();

        //这些东西不进行统计
        initParams.put("exclusions", "*.js,*.css,/druid/*");

        bean.setInitParameters(initParams);
        return bean;
    }


}
