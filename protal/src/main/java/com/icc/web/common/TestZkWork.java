package com.icc.web.common;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.Op.Create;


public class TestZkWork {
	public static void main(String[] args) {
		CountDownLatch cdl =new CountDownLatch(1);
		ZkClient zkClient = new ZkClient("127.0.0.1:2181");
		if(!zkClient.exists("/tasks/t1")){
			zkClient.createEphemeral("/tasks/t1");
		}
		zkClient.subscribeDataChanges("/tasks/t1", new IZkDataListener() {
			
			@Override
			public void handleDataDeleted(String dataPath) throws Exception {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void handleDataChange(String dataPath, Object data) throws Exception {
				System.out.println(dataPath+":/"+data+":/...............");
				
			}
		});
		for (int i = 0; i < 10; i++) {
			System.out.println("s");
			zkClient.writeData("/tasks/t1", i);
			System.out.println("e");
		}
		try {
			cdl.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
