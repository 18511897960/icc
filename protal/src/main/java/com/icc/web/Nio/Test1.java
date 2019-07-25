package com.icc.web.Nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ScatteringByteChannel;

public class Test1 {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream("D://input.txt");
        FileOutputStream outputStream = new FileOutputStream("D://output.txt");
        FileChannel inputChannel = inputStream.getChannel();
        FileChannel outputChannel = outputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(5);
        ByteBuffer.allocateDirect(5);


        while (true)
        {
            buffer.clear();
            int reads = inputChannel.read(buffer);
            System.out.println("reads: " + reads);
            if(-1 == reads){
                break;
            }
            buffer.flip();
            outputChannel.write(buffer);
            System.out.println("postion: "+buffer.position());
            System.out.println("limit: "+buffer.limit());
        }
        inputStream.close();
        outputStream.close();

    }
}
