package com.icc.web.netty.gprc.protobuf;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class GrpcClient {
    public static void main(String[] args) throws Exception{
        ManagedChannel channel = ManagedChannelBuilder.
                forAddress("localhost",8899).usePlaintext().build();
        /*PersonServiceGrpc.PersonServiceBlockingStub stub = PersonServiceGrpc.newBlockingStub(channel);
        ResponseHeader response = stub.find(RequestHeader.newBuilder().setId(31).build());
        System.out.println("client message:" + response.getId());
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);*/
        System.out.println("--------------------------------");

        /*PersonServiceGrpc.PersonServiceBlockingStub stubResponse = PersonServiceGrpc.newBlockingStub(channel);
        Iterator<ResponseHeader> i =  stubResponse.findResponseStream(RequestHeader.newBuilder().setId(41).build());
        while (i.hasNext()){
            System.out.println(i.next());
        }
        channel.shutdown().awaitTermination(5,TimeUnit.SECONDS);*/

       /* System.out.println("--------------------------------");
        //服务端返回数据监听
        StreamObserver<ResponseHeaderList> observer = new StreamObserver<ResponseHeaderList>() {
            @Override
            public void onNext(ResponseHeaderList value) {
                for (ResponseHeader o:value.getResponseList()) {
                    System.out.println("id:" + o.getId());
                }
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                System.out.println("Completed");
            }
        };
        //客户端发送数据

        PersonServiceGrpc.PersonServiceStub stub = PersonServiceGrpc.newStub(channel);
        StreamObserver<RequestHeader> stream = stub.findRequestStream(observer);
        stream.onNext(RequestHeader.newBuilder().setId(101).build());
        stream.onNext(RequestHeader.newBuilder().setId(102).build());
        stream.onNext(RequestHeader.newBuilder().setId(103).build());
        stream.onNext(RequestHeader.newBuilder().setId(104).build());
        stream.onCompleted();
        Thread.sleep(50000);
        channel.shutdown().awaitTermination(5,TimeUnit.SECONDS);*/

        System.out.println("--------------------------------");

        StreamObserver<ResponseHeader> observer = new StreamObserver<ResponseHeader>() {
            @Override
            public void onNext(ResponseHeader value) {
                System.out.println("id:" + value.getId());
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                System.out.println("Completed");
            }
        };

        PersonServiceGrpc.PersonServiceStub stub = PersonServiceGrpc.newStub(channel);
        StreamObserver<RequestHeader> RR = stub.findReqResStream(observer);
        for(int i = 0;i<10;i++){
            RR.onNext(RequestHeader.newBuilder().setId(20001).build());
            Thread.sleep(1000);
        }
    }
}
