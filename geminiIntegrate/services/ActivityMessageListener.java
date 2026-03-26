package com.geminiIntegrate.services;

import com.geminiIntegrate.model.Activity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActivityMessageListener {

//    @Value("${rabbitmq.queue.name}")
//    private String queueActivity;

    @RabbitListener(queues = "queueActivity")
    public void processActivity(Activity activity){
        log.info("Received activity Message: {}", activity);
    }

}
