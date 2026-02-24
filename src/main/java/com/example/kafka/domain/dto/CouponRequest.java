package com.example.kafka.domain.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CouponRequest {
    private String eventId;
    private String userId;
    private String requestTime;
}
