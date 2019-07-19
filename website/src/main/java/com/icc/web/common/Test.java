package com.icc.web.common;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class Test {
    public static void main(String[] args) throws Exception{
        DataInputStream stream = new DataInputStream(new FileInputStream(""));
        stream.readDouble();
    }
}

