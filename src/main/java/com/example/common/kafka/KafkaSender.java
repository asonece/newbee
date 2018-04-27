package com.example.common.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Ansai on 2018/4/13.
 */
@Component
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    //发送消息方法
    public void send() {
        String uuid=UUID.randomUUID().toString();
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(uuid);
        message.setSendTime(new Date());
        kafkaTemplate.send("test",uuid);
        System.out.println("------------------send message =" + message);
    }
}