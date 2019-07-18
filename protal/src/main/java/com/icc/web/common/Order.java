package com.icc.web.common;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.icc.abstractClass.ZookeeperLook;

public class Order implements Runnable {
	static CountDownLatch countDownLatch = new CountDownLatch(60);
	private static OrderCodeGenerator ong = new OrderCodeGenerator();
	private Logger logger = LoggerFactory.getLogger(Order.class);
	 private ZookeeperLook lock = new ZkLook(); 
	@Override
	public void run() {
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		createOrder();
		
	}
	private void createOrder() {
		lock.lock("/dubbo/lock");
		logger.info("msg:"+ong.getOrderCode());
		lock.unlock("/dubbo/lock");
		
	}
	
	
	 public static void main(String[] args) {
	        for (int i = 1; i <= 60; i++) {
	            // 按照线程数迭代实例化线程
	            new Thread(new Order()).start();
	            // 创建一个线程，倒计数器减1
	            countDownLatch.countDown();
	        }
	    }
	
}
