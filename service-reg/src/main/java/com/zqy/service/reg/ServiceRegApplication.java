package com.zqy.service.reg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author: ZQY
 * @Date: 2020/5/27 14:14
 * @Version: 1.0
 * @Description:
 **/
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "com.zqy")
@MapperScan(basePackages = "com.zqy.commons.mapper")
@EnableBinding({Source.class})
@EnableAsync
public class ServiceRegApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceRegApplication.class, args);
    }
}
