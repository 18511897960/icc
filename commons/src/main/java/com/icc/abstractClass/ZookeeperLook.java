package com.icc.abstractClass;

import org.I0Itec.zkclient.ZkClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ZookeeperLook{
	private Logger logger = LoggerFactory.getLogger(ZookeeperLook.class);
	    private ZkClient zkClient = new ZkClient(HOST);
		private final static String HOST="127.0.0.1:2181";
		
		public void lock(String path) {
			if(tryLock()){
				logger.info(Thread.currentThread().getName()+".get.lock.....");
			}else{
				waitLock();
			}
		}
		
		public void unlock(String path) {
			zkClient.delete(path);
		}
		
		public abstract boolean tryLock() ;
		
		public abstract void waitLock();
}
