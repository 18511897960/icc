package com.icc.web.Nio.thread;

import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;

public class Connection {
    //跳过开头
     boolean skipHeader;
    //读取客户端内容通道
     SocketChannel channel;

     ByteBuffer writeBuffer;

    //读取内容buffer
     ByteBuffer readBuffer;

    //处理向客户端写任务的对象
     Responder responder = null;
    //TODO 等待初始化，为定位到具体初始化位置。


    //缓冲器读写策略的阀值
    private static int NIO_BUFFER_LIMIT = 64 * 1024;

    public int process() throws Exception
    {
        int count;
        //第一次获取，要读的内容的长度，并将值存于writeBuffer缓冲器中，int值，就4个字节
        if(!skipHeader)
        {
            count = channelRead(channel,writeBuffer);
            if(count < 0 || writeBuffer.remaining() > 0)
            {
                return count;
            }
        }
        skipHeader = true;
        //如果readBuffer为null就为readBuffer初始化，分配的字节长度为writeBuffer读到的值
        if(null == readBuffer ){
            writeBuffer.flip();
            int length = writeBuffer.getInt();
            readBuffer = ByteBuffer.allocate(length);
        }

        count = channelRead(channel,readBuffer);
        //如果读取的数据不为0,并且没有剩余的长度，说明读取完成，执行下一步操作
        if(count >= 0 && readBuffer.remaining() == 0 ){
            continueProcess();
        }
        return count;
    }

    /**
     * process the dataBuffer
     */
    private void continueProcess() {
        readBuffer.flip();
        byte[] array = readBuffer.array();
        Call call = new Call(this,array,responder);
        try {
            Server.deque.put(call);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    //当前buffer剩余的长度少于64M,就将数据直接读入buffer，如果大于64M，则循环读入（估计是为了防止一次性读太多，引起系统的开销过大，所以循环读）
    public int channelRead(ReadableByteChannel channel , ByteBuffer buffer )throws Exception
    {
        return buffer.remaining() <= NIO_BUFFER_LIMIT ? channel.read(buffer) : channelIO(channel,null,buffer);
    }

    public int channelWrite(WritableByteChannel writableChannel,ByteBuffer buffer) throws Exception
    {
        return writeBuffer.remaining() <= NIO_BUFFER_LIMIT ? channel.read(buffer) : channelIO(null,writableChannel,buffer);
    }

    public void close() throws Exception{
        if(this.channel != null)
        {
            this.channel.close();
        }
    }

    public int channelIO (ReadableByteChannel readChannel, WritableByteChannel writeChannel , ByteBuffer buffer) throws Exception
    {
        int remaining = buffer.remaining();
        int limit = buffer.limit();
        int ret = 0;
        try {
            while (buffer.remaining() > 0) {
                int ioLength = Math.min(buffer.remaining(), NIO_BUFFER_LIMIT);
                buffer.limit(buffer.position() + ioLength);
                ret = readChannel == null ? writeChannel.write(buffer) : readChannel.read(buffer);
                if (ret < ioLength) {
                    break;
                }
            }
        } finally {
            buffer.limit(limit);
        }
        int byteRead = remaining - buffer.remaining();
        return byteRead > 0 ? byteRead : ret;

    }


}
