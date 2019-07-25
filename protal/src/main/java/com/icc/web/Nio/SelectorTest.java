package com.icc.web.Nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class SelectorTest {
    public static void main(String[] args) throws Exception {
        int[] ports = new int[5];
        ports[0] = 5000;
        ports[1] = 5001;
        ports[2] = 5002;
        ports[3] = 5003;
        ports[4] = 5004;

        Selector selector = Selector.open();
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            ServerSocket socket = serverSocketChannel.socket();
            socket.bind(new InetSocketAddress(5000));
            System.out.println("监听端口: " + 5000);
            System.out.println("ipp: " + serverSocketChannel.hashCode());

        while (true)
        {
            int numbers = selector.select();
            System.out.println("numbers: " + numbers);
            System.out.println("keys: " + selector.keys().size());
            System.out.println("skeys: " + selector.selectedKeys().size());
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext())
            {
                SelectionKey next = iterator.next();
                for (SelectionKey k:selector.keys())
                {
                    System.out.println("ip: " + k.channel().hashCode());
                }
                if(next.isAcceptable()){
                    ServerSocketChannel acceptChannel = (ServerSocketChannel) next.channel();
                    SocketChannel accept = acceptChannel.accept();
                    accept.configureBlocking(false);
                    accept.register(selector,SelectionKey.OP_READ);
                    iterator.remove();
                    System.out.println("新建连接 ：" + acceptChannel);
                    System.out.println("keys: " + selector.keys().size());

                    System.out.println("skeys: " + selector.selectedKeys().size());
                }else if(next.isReadable())
                {
                   SocketChannel channel = (SocketChannel) next.channel();
                   int byteRead = 0;
                   while (true)
                   {
                       ByteBuffer byteBuffer = ByteBuffer.allocate(512);
                       byteBuffer.clear();
                       int reads = channel.read(byteBuffer);
                       if(reads <= 0){
                            break;
                       }
                       byteBuffer.flip();
                       channel.write(byteBuffer);
                       System.out.println();
                       byteRead += reads;
                   }
                    System.out.println("byteRead: " + byteRead);
                   iterator.remove();
                }
            }
        }
    }
}
