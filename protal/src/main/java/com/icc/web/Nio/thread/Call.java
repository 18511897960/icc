package com.icc.web.Nio.thread;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Call {

     Connection connection;

     Responder responder;

     byte[] request;

     ByteBuffer response;
    public Call(Connection connection, byte[] array, Responder responder) {
        this.connection = connection;
        this.request = array;
        this.responder = responder;
    }
}
