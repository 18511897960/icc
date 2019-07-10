package com.icc.web.netty.webSocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

public class ServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if(evt instanceof IdleStateEvent){
            IdleStateEvent event = (IdleStateEvent)evt;
            String eventType = null;
            switch (event.state()){
                case READER_IDLE:
                    eventType = "dkx";
                    break;
                case WRITER_IDLE:
                    eventType = "wkx";
                    break;
                case ALL_IDLE:
                    eventType = "dwkx";
                    break;
            }
            System.out.println(ctx.channel().remoteAddress() + "cssj:" + eventType);
            ctx.channel().close();
        }
    }
}
