package com.icc.web.common;

import java.util.concurrent.CountDownLatch;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.icc.abstractClass.ZookeeperLook;

public class ZkLook extends ZookeeperLook{
	private Logger logger = LoggerFactory.getLogger(ZkLook.class);
	  ZkClient zkClient = new ZkClient(HOST);
	 private final static String HOST="127.0.0.1:2181";
	 private CountDownLatch countDownLatch = null;
	 private final static String PATH = "/dubbo/lock";
	@Override
	public boolean tryLock() {
		try {
			zkClient.createEphemeral(PATH);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public void waitLock() {
		IZkDataListener listener = new IZkDataListener() {
			@Override
			public void handleDataDeleted(String PATH) throws Exception {
				countDownLatch.countDown();
			}
			
			@Override
			public void handleDataChange(String dataPath, Object data) throws Exception {
				
			}
		};
		zkClient.subscribeDataChanges(PATH, listener);
		if(zkClient.exists(PATH)){
			
			countDownLatch = new CountDownLatch(1);
			try {
				countDownLatch.await();
			} catch (Exception e) {
				e.printStackTrace();
			}
			zkClient.unsubscribeDataChanges(PATH, listener);
			lock(PATH);
		}
		
	}

	
	
}
