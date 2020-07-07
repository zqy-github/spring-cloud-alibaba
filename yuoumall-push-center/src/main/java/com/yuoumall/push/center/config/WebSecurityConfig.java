package com.yuoumall.push.center.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author ZQY
 * @Date 2020/7/6
 * @Version 1.0
 * @Description 配置swagger
 */

@Configuration
@EnableSwagger2
public class WebSecurityConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yuoumall.push.center.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .title("SpringBoot整合Swagger")
                        .description("")
                        .version("9.0")
                        .contact(new Contact("zqy","","zhangqianyang@yuouhui1.com"))
                        .license("The Apache License")
                        .licenseUrl("/transfer/")
                        .build());
    }

}
