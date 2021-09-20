package com.learning.kafkaconsumerexample.lisner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "UserDataTopic", groupId = "group_id")
    public void consumeMessage(String message) {
        log.info("Consumed Data : " + message);
    }

    /*@KafkaListener(topics = "UserDataTopic", groupId = "group_json")
    public void consumeMessage(UserDto userDto) {
        log.info("Consumed user data : " + userDto);
    }*/
}
