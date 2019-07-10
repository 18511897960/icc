package com.icc.web.netty.Chat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.GlobalEventExecutor;

public class ServerHandler extends SimpleChannelInboundHandler<String> {
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();
        for (Channel ch:channelGroup) {
            if(channel != ch){
                ch.writeAndFlush(channel.id()+":"+msg+"\r\n");
            }else{
                ch.writeAndFlush("[me]"+"\r\n");
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();

    }

    /**
     * 建立连接
     * */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(channelGroup.size());
        channelGroup.writeAndFlush("[服务器]"+channel.id()+":"+channel.remoteAddress()+":connected\n");
        channelGroup.add(channel);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println(channelGroup.size());
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("[服务器]"+channel.id()+":"+channel.remoteAddress()+":disconnected\n");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println("[服务器]"+channel.id()+":"+channel.remoteAddress()+":online");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println("[服务器]"+channel.id()+":"+channel.remoteAddress()+":inOnline");
    }
}
