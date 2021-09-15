package com.prashhanth.secuirty.service;


import com.prashhanth.secuirty.entity.external.UserExt;
import com.prashhanth.secuirty.util.AppConstants;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Producer {

    @Autowired
    private RabbitTemplate template;

    public String sendDataToActiveMq(List<UserExt> usersList){
        template.convertAndSend(AppConstants.EXCHANGE, AppConstants.ROUTING_KEY, usersList);
        return "Success !!";
    }
}
