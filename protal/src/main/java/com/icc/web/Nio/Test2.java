package com.icc.web.Nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class Test2 {
    public static void main(String[] args) throws Exception {
        RandomAccessFile file = new RandomAccessFile("input.txt","rw");
        System.out.println();
        FileChannel channel = file.getChannel();
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
        map.put(0,(byte)'a');
        map.put(1,(byte)'b');
        System.out.println((char) map.get(0));
        file.close();
    }

}
