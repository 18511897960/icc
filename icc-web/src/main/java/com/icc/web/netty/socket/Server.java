package com.icc.web.netty.socket;

import com.sun.corba.se.internal.CosNaming.BootstrapServer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class Server {
    public static void main(String[] args) throws Exception {
        NioEventLoopGroup serverGroup = new NioEventLoopGroup();
        NioEventLoopGroup clientGroup = new NioEventLoopGroup();
        try{
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(serverGroup,clientGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new SocketServerInitalizer());

            ChannelFuture future = bootstrap.bind(8899).sync();
            future.channel().closeFuture().sync();

        }finally {
            clientGroup.shutdownGracefully();
            serverGroup.shutdownGracefully();

        }

    }
}
