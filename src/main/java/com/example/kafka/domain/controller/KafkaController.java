package com.example.kafka.domain.controller;

import com.example.kafka.domain.repository.CouponRepository;
import com.example.kafka.domain.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/coupons")
public class KafkaController {

    private final KafkaProducerService kafkaProducerService;
    private final CouponRepository couponRepository;

    /**
     * 쿠폰 발급 요청
     *
     * @param eventId, userId
     * @return
     */
    @PostMapping("/request")
    public ResponseEntity<String> sendMessage(@RequestParam String eventId, @RequestParam String userId) {
        String result = kafkaProducerService.requestCoupon(eventId, userId);
        return ResponseEntity.ok(Map.of("message", result).toString());
    }

    /**
     * 내 쿠폰 조회
     *
     * @param message
     * @return
     */


}
