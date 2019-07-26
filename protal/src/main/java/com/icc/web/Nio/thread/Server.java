package com.icc.web.Nio.thread;


import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by
 */
public class Server {
    //server启动标志
    public static boolean running = true;

    public static int LIMIT = 64 * 1024;

    //缓存 -> server 数据
    private static BlockingDeque<Call> readQeque = new LinkedBlockingDeque<Call>();

    //缓存 <- server 数据
    private static Queue<Call> writeQeque = new ConcurrentLinkedQueue<Call>();

    public static void main(String[] args) throws Exception {
        Server server = new Server();
        server.start();
    }

    public static int readChannel(SocketChannel channel, ByteBuffer buffer) throws Exception{
        return buffer.remaining() < LIMIT ? channel.read(buffer) : channelIO(channel , null , buffer);
    }

    public static int writeChannel(SocketChannel channel, ByteBuffer buffer) throws Exception{
        return buffer.remaining() < LIMIT ? channel.read(buffer) : channelIO(null , channel , buffer);
    }

    private static int channelIO(SocketChannel read , SocketChannel write, ByteBuffer buffer) throws Exception{
        int remining = buffer.remaining();
        int ret = 0;
        while (buffer.remaining() > 0)
        {

            int size = Math.min(buffer.remaining() , LIMIT);
            buffer.limit(buffer.position() + size);
            ret = read == null ? write.write(buffer) : read.read(buffer);
        }

        return (remining - buffer.remaining() ) > 0 ? (remining - buffer.remaining() ) : ret;
    }

    private void start() throws Exception {
        Listener listener = new Listener(15000);
    }
}