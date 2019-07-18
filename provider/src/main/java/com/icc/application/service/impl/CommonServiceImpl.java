package com.icc.application.service.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.icc.application.CommonService;
import com.icc.application.UserService;
import com.icc.application.config.KafkaConsumerConfig;
import com.icc.application.config.KafkaProviderConfig;

@Service(version="1.0.0")
public class CommonServiceImpl implements CommonService{
	static CountDownLatch cdl = new CountDownLatch(3);
	@Autowired
	private KafkaProviderConfig providerConfig;
	@Autowired
	private KafkaConsumerConfig consumerConfig;
	@Override
	public String findById(Long id) {
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						cdl.await();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					KafkaConsumer<String, String> consumer = new KafkaConsumer<>(consumerConfig.consumerConfigs());
					
					consumer.subscribe(Collections.singletonList("test"),new ConsumerRebalanceListener() {
						
						@Override
						public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
							System.out
									.println(Thread.currentThread().getName()+"/"+"LoginController.login().new Runnable() {...}.run().new ConsumerRebalanceListener() {...}.onPartitionsRevoked()");
							if(partitions != null){
								for(TopicPartition tp : partitions){
									System.out.println(Thread.currentThread().getName()+"/"+tp.topic()+"/"+tp.partition());
								}
							}
						}
						
						@Override
						public void onPartitionsAssigned(Collection<TopicPartition> partitions) {
							System.out
									.println(Thread.currentThread().getName()+"/"+"LoginController.login().new Runnable() {...}.run().new ConsumerRebalanceListener() {...}.onPartitionsAssigned()");
							
							if(partitions != null){
								for(TopicPartition tp : partitions){
									System.out.println(tp.topic()+"/"+tp.partition());
								}
							}
						}
					});
					try {
						while (true) {
							ConsumerRecords<String, String> records = consumer.poll(1);
//							Set<TopicPartition> set = consumer.assignment();
//							 for (TopicPartition tp : set) {
//				                  System.out.println(Thread.currentThread().getName()+"/"+tp.topic()+tp.partition());
//				              }
							 for (ConsumerRecord<String, String> record : records) {
								 System.out.println(Thread.currentThread().getName()+"-PCOMMONSERVICE/"+record.topic() +"/"+ record.partition() +"/"+ record.offset() +"/"+ record.key() +"/"+ record.value());
							 }
						}
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						consumer.close();
					}
					
				}
			},"Thread-consumer-"+i).start();
			cdl.countDown();
		}
		return id+"";
	}

}
