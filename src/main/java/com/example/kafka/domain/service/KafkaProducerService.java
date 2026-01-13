package com.example.kafka.domain.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final String topic = "topic-1";

    /**
     * 기본적인 메시지 전송
     *
     * @param message
     */
    public void sendMessage(String message){
        log.info("send message: " + message);
        kafkaTemplate.send(topic,message );
    }

    /**
     * 키와 함꼐 메시지 전송
     *
     * @param key
     * @param message
     */
    public void sendMessageWithKey(String key, String message){
        kafkaTemplate.send(topic,key,message);
    }
}
