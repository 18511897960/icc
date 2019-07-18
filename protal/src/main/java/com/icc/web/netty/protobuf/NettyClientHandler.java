package com.icc.web.netty.protobuf;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

public class NettyClientHandler extends SimpleChannelInboundHandler<DataInfo.MessageType> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.MessageType msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        int randomInt = new Random().nextInt(3);
        System.out.println(randomInt);
        DataInfo.MessageType messageType = null;
        if(randomInt == 0) {
            messageType = DataInfo.MessageType.newBuilder().setDataType(DataInfo.MessageType.DataType.PersonType)
                    .setPerson(DataInfo.Person.newBuilder().setId(1).setName("Perion").setAge("ze").build())
                    .build();
        }else if(randomInt == 1) {
            messageType = DataInfo.MessageType.newBuilder().setDataType(DataInfo.MessageType.DataType.ChildType)
                    .setChild(DataInfo.Child.newBuilder().setId(1).setName("Child").setAge("ze").build())
                    .build();
        }else {
            messageType = DataInfo.MessageType.newBuilder().setDataType(DataInfo.MessageType.DataType.StudentType)
                    .setStudent(DataInfo.Student.newBuilder().setId(1).setName("Student").setAge("ze").build())
                    .build();
        }

        ctx.channel().writeAndFlush(messageType);
    }
}
