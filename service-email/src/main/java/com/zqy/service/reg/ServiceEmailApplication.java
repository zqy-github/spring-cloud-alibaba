package com.zqy.service.reg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Author: ZQY
 * @Date: 2020/5/29 15:17
 * @Version: 1.0
 * @Description:
 **/
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages  = "com.zqy")
@EnableBinding({Sink.class})
@EnableAsync
public class ServiceEmailApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceEmailApplication.class, args);
    }
}
