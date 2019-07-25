package com.icc.web.Nio.thread;

import jdk.nashorn.internal.codegen.CompilerConstants;

import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Server {
   static volatile boolean running = true;

   //读取队列
   public static BlockingDeque<Call> deque = new LinkedBlockingDeque<Call>() ;

   //写入队列

    public static Queue<Call> responseCalls = new ConcurrentLinkedQueue<Call>();
    //--Reader


    //--Reader
}
