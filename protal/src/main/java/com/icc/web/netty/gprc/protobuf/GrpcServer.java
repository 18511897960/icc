package com.icc.web.netty.gprc.protobuf;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.logging.Logger;

public class GrpcServer {
    private Server server ;

    private void start() throws IOException {
        this.server = ServerBuilder.forPort(8899).addService(new PersonService()).build().start();
        System.out.println("start");
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("close");
                GrpcServer.this.stop();
            }
        }));
        System.out.println("end");
    }

    private void stop() {
        if(null != this.server){
            this.server.shutdown();
        }
    }

    private void awaitTermination() throws InterruptedException{

        if(null != this.server){
            this.server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException,InterruptedException {
        final GrpcServer server = new GrpcServer();
        server.start();
        server.awaitTermination();
    }
}
