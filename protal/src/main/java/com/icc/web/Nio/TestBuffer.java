package com.icc.web.Nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

public class TestBuffer {
    public static void main(String[] args) throws Exception{
        IntBuffer buffer = IntBuffer.allocate(10);
        int [] integers = {1,2,3,4};
        buffer.put(integers);
        System.out.println((int) buffer.get(0));
        System.out.println("position"+buffer.position());
        System.out.println("limit"+buffer.limit());
        System.out.println(buffer.get(5));
        System.out.println(buffer.remaining());
        buffer.flip();
        System.out.println("position"+buffer.position());
        System.out.println("limit"+buffer.limit());
        buffer.flip();
        System.out.println("position"+buffer.position());
        System.out.println("limit"+buffer.limit());
        buffer.hasRemaining();


    }
}
