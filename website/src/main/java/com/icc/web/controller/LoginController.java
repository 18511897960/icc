package com.icc.web.controller;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.icc.application.CommonService;
import com.icc.application.UserService;
import com.icc.web.config.KafkaConsumerConfig;
import com.icc.web.config.KafkaProviderConfig;

@RestController
@RequestMapping("login")
public class LoginController {
	static CountDownLatch cdl = new CountDownLatch(3);
	
	@Reference(version="1.0.0",timeout=100000)
	private UserService userService;
	
	@Reference(version="1.0.0",timeout=100000)
	private CommonService commonService;
	
	@Autowired
	private KafkaProviderConfig providerConfig;
	@Autowired
	private KafkaConsumerConfig consumerConfig;
	
	@RequestMapping("test")
	@ResponseBody
	public String login(){
		
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
								 System.out.println(Thread.currentThread().getName()+"-C/"+record.topic() +"/"+ record.partition() +"/"+ record.offset() +"/"+ record.key() +"/"+ record.value());
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
		
//		for (int i = 0; i < 200; i++) {
//			providerConfig.getProviderKafkaTemplate().send("test","test.provideing."+i);
//		}
		String idu = userService.findById(10001L);
		String idc = commonService.findById(10001L);
		return "start";
	}
	
//	public static void main(String[] args) {
//			Integer[] arrStrings = {7,3,17,13,23,27,37,33,47,43,57,53,67,63,73,1,11,21,31,41,0,10,20,30,40,50,6,16,26,36,46,5,15,25,35,45,55,65,75,8,18,28,38,48,58,68,9,19,29,39,49,59,4,14,24,34,44,54,64,51,61,71,69,79,56,66,74,84,60,70,77,87,76,86,2,12,22,32,42,52,62,72,78,88,83,93,85,95,80,90,100,81,91,101,82,92,89,99,94,104,96,106,97,107,117,98,108,110,103,113,105,115,111,121,131,102,112,122,132,109,119,129,139,116,126,114,124,134,127,137,118,128,138,123,133,143,153,125,135,145,120,130,140,150,160,170,141,151,161,171,142,152,162,172,149,159,169,144,154,164,174,136,146,156,166,176,147,157,167,177,148,158,168,178,163,173,183,155,165,175,180,190,181,191,182,192,179,189,184,194,186,196,187,197,188,198,199,193,185,195,}; 
//			Collections.sort(Arrays.asList(arrStrings));
//			for (int i = 0; i < arrStrings.length; i++) {
//				System.out.print(i+",");
//			}
//	}
}



