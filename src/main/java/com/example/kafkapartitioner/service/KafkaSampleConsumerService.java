package com.example.kafkapartitioner.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaSampleConsumerService {

    @KafkaListener(topicPartitions = @TopicPartition(topic = "dean", partitions = {"0", "1"}), groupId = "dean-group-id")
    public void consume1(@Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition, @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key, @Payload String value) {
        log.info("receive message : 1 : {} : {} : {}", partition, key, value);
    }

    @KafkaListener(topicPartitions = @TopicPartition(topic = "dean", partitions = {"2", "3"}), groupId = "dean-group-id")
    public void consume2(@Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition, @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key, @Payload String value) {
        log.info("receive message : 2 : {} : {} : {}", partition, key, value);
    }

}
