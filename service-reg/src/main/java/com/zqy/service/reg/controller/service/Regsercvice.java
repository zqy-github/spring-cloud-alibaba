package com.zqy.service.reg.controller.service;

import com.zqy.commons.domain.Account;
import com.zqy.commons.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
/**
 * @Author: ZQY
 * @Date: 2020/5/29 15:31
 * @Version: 1.0
 * @Description:
 **/

@Service
public class Regsercvice {

    @Autowired
    private MessageChannel outPut;

    /**
     * 变为异步发送邮件
     */
    @Async
    public void sendEmail(Account account){
        try {
            outPut.send(MessageBuilder.withPayload(MapperUtils.obj2json(account)).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
