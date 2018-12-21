package com.icc.web.controller;

import org.springframework.kafka.core.KafkaTemplate;

import com.icc.web.config.KafkaProviderConfig;

public class Test {
	public static void main(String[] args) {
		KafkaProviderConfig config = new KafkaProviderConfig();
		KafkaTemplate<String, String> template = config.getProviderKafkaTemplate();
		for (int i = 0; i < 100; i++) {
			template.send("test-0","provider:"+i);
		}
	}
}
