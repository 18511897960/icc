package com.icc.web.Nio.thread;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

//用来处理客户端的可读事件
public class Reader extends Thread {
    Selector selector;
    boolean skipHeader;
    ByteBuffer readBuffer;

    public Reader(int i) throws Exception {
        setName("Reader-" + i);
        selector = Selector.open();
    }

    public void registerChannel(SocketChannel socketChannel) throws Exception {

        socketChannel.register(selector, SelectionKey.OP_READ);
    }

    @Override
    public void run() {
        while (Server.running) {
            try {
                selector.select();
                Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
                while (keys.hasNext()) {
                    SelectionKey key = keys.next();
                    if (key.isValid() && key.isReadable()) {
                        read(key);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }

    private void read(SelectionKey key) throws Exception {
        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer messageLengthBuffer = ByteBuffer.allocate(4);
        try {
            int reads;
            if (!skipHeader) {
                reads = Server.readChannel(channel, messageLengthBuffer);
                skipHeader = true;
            }

            if(null == readBuffer) {
                messageLengthBuffer.flip();
                int length = messageLengthBuffer.getInt();
                readBuffer = ByteBuffer.allocate(length);
            }
            reads = Server.readChannel(channel,readBuffer);

        } catch (Exception e) {
            channel.close();
            e.printStackTrace();
        }
        channel.close();
    }
}