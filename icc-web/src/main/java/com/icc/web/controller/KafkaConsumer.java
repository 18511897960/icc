package com.icc.web.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
	
	@KafkaListener(topics={"test-0"})
	public void listen(ConsumerRecord<?, ?> record) {
           System.out.println(record.key()+record.value().toString());
        }

    }

