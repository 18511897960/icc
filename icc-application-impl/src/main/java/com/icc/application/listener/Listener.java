package com.icc.application.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.icc.application.config.KafkaProviderConfig;

@Component
public class Listener {
	@Autowired
	private KafkaProviderConfig config;
	
	@KafkaListener(topics={"test"})
	public void receive(ConsumerRecord<?, ?> record) {
        System.out.println("rec:"+record.key()+record.value().toString());
        config.getProviderKafkaTemplate().send("test", 0,"i'm received");
	}
}
