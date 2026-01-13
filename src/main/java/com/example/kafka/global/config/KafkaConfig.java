package com.example.kafka.global.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Configuration
public class KafkaConfig {

//    /**
//     * Producer 설정을 위한 Factory Bean
//     * - 메시지 생산자의 직렬화 설정 및 서버 연결 설정을 담당
//     * ( Kafka 는 네트워크를 통해 메시지를 전송하는데, Java 객체를 있는 그대로 네트워크로 전송할 수 X. 바이트 스트림으로 변환(직렬화) 필요 )
//     *
//     * @return ProducerFactory<String, String>
//     */
//    @Bean
//    public ProducerFactory<String, String> producerFactory() {
//        Map<String, Object> configProps = new HashMap<>();
//        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);    // 생성자의 메시지 키 값을 "문자열 형태로 직렬화"
//        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);  // 생성자의 메시지 값을 "문자열 형태로 직렬화"
//        return new DefaultKafkaProducerFactory<>(configProps);
//    }
//
//    /**
//     * Consumer 설정을 위한 Factory Bean
//     * - 메시지 소비자의 역직렬화 설정 및 그룹 ID, 오프셋 설정을 담당
//     *
//     * @return ConsumerFactory<String, String>
//     */
//    @Bean
//    public ConsumerFactory<String, String> consumerFactory() {
//        Map<String, Object> configProps = new HashMap<>();
//        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        configProps.put(ConsumerConfig.GROUP_ID_CONFIG, "my-group");
//        configProps.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
//        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        return new DefaultKafkaConsumerFactory<>(configProps);
//    }
//
//    /**
//     * Kafka 메시지를 전송하기 위한 템플릿 Bean
//     * - 실제 애플리케이션에서 메시지 전송시 사용됨
//     *
//     * @return KafkaTemplate<String, String>
//     */
//    @Bean
//    public KafkaTemplate<String, String> kafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }
//
//    /**
//     * KafkaListener 애노테이션이 붙은 메서드 실행시키기 위한 컨테이너 만드는 팩토리
//     * @return
//     */
//    @Bean
//    ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactory());
//        return factory;
//    }
}
