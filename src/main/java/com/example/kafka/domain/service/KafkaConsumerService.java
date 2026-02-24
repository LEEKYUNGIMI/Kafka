package com.example.kafka.domain.service;

import com.example.kafka.domain.dto.CouponRequest;
import com.example.kafka.domain.model.Coupon;
import com.example.kafka.domain.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumerService {

    private static final int MAX_COUPON = 100; // 최대 발급 가능한 쿠폰 수

    private final CouponRepository couponRepository;

    @KafkaListener(topics = "coupon-requests", groupId = "coupon-group")
    public void consume(CouponRequest request){
        String eventId = request.getEventId();
        String userId = request.getUserId();

        // 이미 쿠폰을 발급받았는지 체크
        if (couponRepository.findByEventIdAndUserId(eventId, userId).isPresent()) {
            log.info("이미 발급된 쿠폰 - userId={}, eventId={}", userId, eventId);
            return;
        }
        // 선착순 쿠폰 마감 체크
        if (couponRepository.countByEventId(eventId) >= MAX_COUPON){
            log.info("쿠폰 소진 - eventId={}", eventId);
            return;
        }

        Coupon coupon = Coupon.builder()
                .eventId(eventId)
                .userId(userId)
                .build();
        couponRepository.save(coupon);

        log.info("쿠폰 발급 완료 - userId={}, eventId={}", userId, eventId);
    }
}
