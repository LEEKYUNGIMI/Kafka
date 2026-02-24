package com.example.kafka.domain.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "coupons")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coupon {

    @Id
    private String id;

    @Field(type = FieldType.Keyword)
    private String couponCode;

    @Field(type = FieldType.Keyword)
    private String eventId;

    @Field(type = FieldType.Keyword)
    private String userId;

    @Field(type = FieldType.Keyword)
    private Integer issueOrder;

    @Field(type = FieldType.Date)
    private String issuedAt;

    @Field(type = FieldType.Keyword)
    private String status;  // ISSUED, USED, EXPIRED
}
