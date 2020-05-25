package com.zqy.rocketmq.provider.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * @Author: ZQY
 * @Date: 2020/5/25 11:57
 * @Version: 1.0
 * @Description:
 **/
@Service
public class ProviderService {
    @Autowired
    private MessageChannel output;

    public void send(String message){
        output.send(MessageBuilder.withPayload(message).build());
    }
}
