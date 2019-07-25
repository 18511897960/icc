package com.icc.web.Nio;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

public class Test3 {
    public static void main(String[] args) throws Exception{
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8899));
        int messageLength = 2 + 3 + 4;
        ByteBuffer [] buffers = new ByteBuffer[3];
        buffers[0] = ByteBuffer.allocate(2);
        buffers[1] = ByteBuffer.allocate(3);
        buffers[2] = ByteBuffer.allocate(4);
        SocketChannel socketChannel = serverSocketChannel.accept();
        Selector selector = Selector.open();

        while (true)
        {
//            int byteRead = 0;
//            while (byteRead < messageLength)
//            {
//                long r = socketChannel.read(buffers);
//                byteRead += r;
//                System.out.println("byteRead:" + byteRead);
//                Arrays.asList(buffers).stream()
//                        .map(buffer -> "postion:"+buffer.position() +", limit:" + buffer.limit())
//                        .forEach(System.out::println);
//            }
//            Arrays.asList(buffers).forEach(buffer -> {
//
//            });

        }
    }
}
