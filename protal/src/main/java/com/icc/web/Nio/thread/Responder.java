package com.icc.web.Nio.thread;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class Responder extends Thread {
    //缓冲器读写策略的阀值
    private static int NIO_BUFFER_LIMIT = 64 * 1024;
    Selector selector;

    Responder() throws Exception
    {
        selector = Selector.open();
    }

    @Override
    public void run()
    {
        //循环处理写事件
        while (Server.running)
        {
            try {
                //取出Call并注册写事件
                pollCallAndRegisterChannel();
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey next = iterator.next();
                    iterator.remove();
                    if (next.isValid() && next.isWritable()) {
                        doAsyncWrite(next);
                    }
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private void doAsyncWrite(SelectionKey key) throws Exception{
        Call call = (Call) key.attachment();
        if(call.connection.channel != key.channel()){
            throw new IOException("bad channel");
        }
        int numBytes = channelWrite(call.connection.channel,call.response);
        try{
            key.interestOps(0);
        }catch (CancelledKeyException e){
            //LOG.warn("Exception while changing ops : " + e);
        }
    }

    private void pollCallAndRegisterChannel() {
        Iterator<Call> iterator = Server.responseCalls.iterator();
        while (iterator.hasNext())
        {
            Call call = iterator.next();
            iterator.remove();
            SelectionKey selectionKey = call.connection.channel.keyFor(selector);
            try{
                if(selectionKey == null)
                {
                    call.connection.channel.register(selector,SelectionKey.OP_WRITE);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
