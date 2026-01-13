package com.example.kafka.domain.controller;

import com.example.kafka.domain.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/kafka")
public class KafkaController {

    private final KafkaProducerService kafkaProducerService;

    /**
     * 지정 토픽으로 메시지 전송
     *
     * @param message
     * @return
     */
    @PostMapping("/sand")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        kafkaProducerService.sendMessage(message);
        return ResponseEntity.ok("메시지 전송 완료");
    }

    /**
     * 지정 토픽으로 키와 함께 메시지 전송
     *
     * @param key
     * @param message
     * @reutrn
     */
    @PostMapping("/send/withKey")
    public ResponseEntity<String> sendMessageWithKey(@RequestParam("key") String key, @RequestParam("message") String message) {
        kafkaProducerService.sendMessageWithKey(key, message);
        return ResponseEntity.ok("키와 함께 메시지 전송 완료");
    }
}
