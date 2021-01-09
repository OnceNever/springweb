package com.yanglei.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
@EnableOpenApi //3.0.0版本用这个注解@EnableOpenApi  低版本用 @EnableSwagger2 访问地址变为/swagger-ui/index.html
public class SwaggerConfig {

    //配置swagger的docket的bean
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.OAS_30).apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo(){

        Contact contact = new Contact("Lei Yang", "http://www.seeyourface.cn", "1269123897@qq.com");

        return new ApiInfo(
                "Seeyourface API Document",
                "Best wishes To you!",
                "V1.0",
                "http://www.seeyourface.cn",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
