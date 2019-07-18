package com.icc.application.listener;

import java.util.Collection;
import java.util.regex.Pattern;

import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.icc.application.config.KafkaProviderConfig;

@Component
public class Listener {
	@Autowired
	private KafkaProviderConfig config;
	
	//@KafkaListener(topics={"test"})
	public void receive(ConsumerRecord<?, ?> record) {
        System.out.println("rec"+record.offset()+":"+record.key()+record.value().toString());
//        config.getProviderKafkaTemplate().send("test", 0,"i'm received");
	}
	
}
