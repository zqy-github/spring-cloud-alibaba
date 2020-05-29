package com.zqy.service.reg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author: ZQY
 * @Date: 2020/5/27 14:14
 * @Version: 1.0
 * @Description:
 **/
@SpringBootApplication(scanBasePackages = "com.zqy")
@EnableDiscoveryClient
@MapperScan(basePackages = "com.zqy.commons.mapper")
public class ServiceRegApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceRegApplication.class, args);
    }
}
