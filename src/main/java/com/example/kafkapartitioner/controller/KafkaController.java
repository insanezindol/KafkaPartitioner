package com.example.kafkapartitioner.controller;

import com.example.kafkapartitioner.service.KafkaSampleProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
@Slf4j
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaSampleProducerService kafkaSampleProducerService;

    @GetMapping("/sendMessage")
    public ResponseEntity sendMessage(@RequestParam String message) {
        log.info("sendMessage");
        kafkaSampleProducerService.sendMessage(message);
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/sendMessageWithPartition")
    public ResponseEntity sendMessageWithPartition(@RequestParam int patition, @RequestParam String key, @RequestParam String value) {
        log.info("sendMessageWithPartition");
        kafkaSampleProducerService.sendMessageWithPartition(patition, key, value);
        return ResponseEntity.ok("OK");
    }

}
