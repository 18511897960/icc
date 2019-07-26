package com.icc.web.Nio.thread;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * 负责服务器的初始化，实例化serverSocketChannel，和selector,包括serverSocketChannel绑定ip地址和端口,
 * 并向通道注册accept事件。启动多个reader线程，用于后续和客户端连接通讯
 *
 *
 */

public class Listener extends Thread {
    Selector selector;
    Reader[] readers;
    int robin;

    public Listener(int port) throws Exception{
        selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        ServerSocket socket = serverSocketChannel.socket();
        socket.bind(new InetSocketAddress(port));
        serverSocketChannel.register(selector , SelectionKey.OP_ACCEPT);
        for(int i = 0;i < 10 ; i++)
        {
            readers[i] = new Reader(i);
            readers[i].start();
        }
    }

    @Override
    public void run() {
        while (Server.running)
        {   try {
                selector.select();
                Iterator<SelectionKey> selectionKeys = selector.selectedKeys().iterator();
                while (selectionKeys.hasNext()) {
                    SelectionKey key = selectionKeys.next();
                    selectionKeys.remove();
                    if(key.isValid()){
                        if (key.isAcceptable()) {
                            accept(key);
                        }
                    }

                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private void accept(SelectionKey key) throws Exception{
        ServerSocketChannel channel = (ServerSocketChannel) key.channel();
        SocketChannel socketChannel;

            while ((socketChannel = channel.accept()) != null)
            {
                try {
                    socketChannel.configureBlocking(false);
                    socketChannel.socket().setKeepAlive(true);
                    socketChannel.socket().setKeepAlive(true);
                } catch (Exception e) {
                    socketChannel.close();
                    e.printStackTrace();
                    throw(e);
                }
                Reader reader = getReader();
                reader.registerChannel(socketChannel);
            }


    }

    private Reader getReader() {
        //防止超过int的最大值
        if(robin == Integer.MAX_VALUE) {
            robin = 0;
        }
        return readers[(robin ++) % 10];
    }
}
