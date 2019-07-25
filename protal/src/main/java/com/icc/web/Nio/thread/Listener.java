package com.icc.web.Nio.thread;

import java.io.Reader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class Listener extends Thread{

    Selector selector = null;
    Reader[] readers = null;
    int robin;
    int readNum;

    public Listener(Selector selector) throws Exception {
        this.selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress(8899));
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        readNum = 10;
        readers = new Reader[10];
        for (int i = 0;i < readers.length;i++)
        {
            readers[i] = new Reader;
        }


    }
}
