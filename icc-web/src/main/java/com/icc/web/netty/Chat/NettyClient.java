package com.icc.web.netty.Chat;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class NettyClient {
    public static void main(String[] args) throws Exception{
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group).channel(NioSocketChannel.class)
                    .handler(new ClientInitializer());
            Channel future = bootstrap.connect("localhost",8899).sync().channel();
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            while (true){
                future.writeAndFlush(buffer.readLine()+"\r\n");
            }
//            future.channel().closeFuture().sync();
        }finally {
            group.shutdownGracefully();
        }
    }
}
