package com.icc.web.Nio.thread.read;

import javax.net.SocketFactory;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;


/**
 * Created by wangkai8 on 17/1/6.
 */
public class Client {



    Socket socket;
    OutputStream out;
    InputStream in;

    public Client() throws IOException {
        socket = SocketFactory.getDefault().createSocket();
        socket.setTcpNoDelay(true);
        socket.setKeepAlive(true);
        InetSocketAddress server = new InetSocketAddress("localhost", 10000);
        socket.connect(server, 10000);
        out = socket.getOutputStream();
        in = socket.getInputStream();
    }


    public void send(String message) throws IOException {
        byte[] data = message.getBytes();
        DataOutputStream dos = new DataOutputStream(out);
        //头4个字节作为本次内容的长度
        dos.writeInt(data.length);
        //下面为具体的发送内容
        dos.write(data);
        out.flush();
    }

    //启动200个线程向服务器进行通讯，客户端采用阻塞的socket
    public static void main(String[] args) throws IOException {
        int n = 200;
        for(int i = 0; i < n; i++) {
            new Thread() {
                Client client = new Client();

                public void run() {
                    try {
                        client.send(getName() + "_xiaomiemie");

                        DataInputStream inputStream = new DataInputStream(client.in);
                        int dataLength = inputStream.readInt();
                        byte[] data = new byte[dataLength];
                        inputStream.readFully(data);
                        client.socket.close();
                        System.out.println("receive from server: dataLength=" + data.length);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }

}