package com.icc.web.netty.protobuf;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.*;

public class ServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new ProtobufDecoder(DataInfo.MessageType.getDefaultInstance()));
        pipeline.addLast(new ProtobufEncoder());
//        pipeline.addLast(new ProtobufDecoderNano());
//        pipeline.addLast(new ProtobufEncoderNano());
        pipeline.addLast(new ProtobufVarint32FrameDecoder());
        pipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
        pipeline.addLast(new NettyServerHandler());
    }
}
