package com.zqy.rocketmq.consumer.service;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

/**
 * @Author: ZQY
 * @Date: 2020/5/25 14:20
 * @Version: 1.0
 * @Description:
 **/
@Service
public class ConsumerReceive {
    @StreamListener("input")
    public void receiveInput(String message) {
        System.out.println("Receive input: " + message);
    }
}
