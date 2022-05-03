package com.example.kafkapartitioner.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaSampleProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        log.info("send message : " + message);
        kafkaTemplate.send("dean", message);
    }

    public void sendMessageWithPartition(int partition, String key, String value) {
        log.info("send message : {}, {}, {}", partition, key, value);
        kafkaTemplate.send("dean", partition, key, value);
    }

}
