package com.example.kafka.domain.service;

import com.example.kafka.domain.dto.CouponRequest;
import com.example.kafka.domain.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducerService {


    private final String TOPIC = "coupon-requests";

    private final KafkaTemplate<String, CouponRequest> kafkaTemplate;

    /**
     * 쿠폰 발급 요청 메시지 전송
     *
     * @param eventId
     * @param userId
     * @return
     */
    public String requestCoupon(String eventId, String userId) {

    // Kafka로 요청 전송
        CouponRequest request = CouponRequest.builder()
                .eventId(eventId)
                .userId(userId)
                .requestTime(String.valueOf(System.currentTimeMillis()))
                .build();

        kafkaTemplate.send(TOPIC, eventId, request);
        log.info("쿠폰 요청 : userId={}, eventId={}", userId, eventId);

        return "쿠폰 발급 요청이 전송되었습니다.";

    }
}
