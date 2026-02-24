package com.example.kafka.domain.repository;

import com.example.kafka.domain.model.Coupon;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

public interface CouponRepository extends ElasticsearchRepository<Coupon, String> {

    Optional<Coupon> findByEventIdAndUserId(String eventId, String userId);

    long countByEventId(String eventId);


}
