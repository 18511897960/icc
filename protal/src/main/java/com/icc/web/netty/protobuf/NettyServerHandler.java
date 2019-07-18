package com.icc.web.netty.protobuf;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class NettyServerHandler extends SimpleChannelInboundHandler<DataInfo.MessageType> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.MessageType msg) throws Exception {
        System.out.println(msg.toString());
    }
}
