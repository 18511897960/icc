package com.icc.web.netty.gprc.protobuf;

import com.icc.web.netty.gprc.protobuf.PersonServiceGrpc;
import com.icc.web.netty.gprc.protobuf.RequestHeader;
import com.icc.web.netty.gprc.protobuf.ResponseHeader;
import com.icc.web.netty.gprc.protobuf.ResponseHeaderList;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonService extends PersonServiceGrpc.PersonServiceImplBase {
    @Override
    public void find(RequestHeader request, StreamObserver<ResponseHeader> responseObserver) {
        System.out.println("接收到客户端请求信息：" + request.getId());
        responseObserver.onNext(ResponseHeader.newBuilder().setId(13).build());
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<RequestHeader> findReqResStream(final StreamObserver<ResponseHeader> responseObserver) {
        return new StreamObserver<RequestHeader>() {
            @Override
            public void onNext(RequestHeader requestHeader) {
                System.out.println("id="+666);
                responseObserver.onNext(ResponseHeader.newBuilder().setId(10001).build());

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<RequestHeader> findRequestStream(final StreamObserver<ResponseHeaderList> responseObserver) {
        return new StreamObserver<RequestHeader>() {
            @Override
            public void onNext(RequestHeader requestHeader) {
                System.out.println("接收信息：" + requestHeader.getId());

            }
            @Override
            public void onError(Throwable throwable) {

            }
            @Override
            public void onCompleted() {
                ResponseHeaderList responseHeaderList = ResponseHeaderList.newBuilder()
                        .addResponse(ResponseHeader.newBuilder().setId(200).build())
                        .addResponse(ResponseHeader.newBuilder().setId(300).build())
                        .build();
                responseObserver.onNext(responseHeaderList);
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public void findResponseStream(RequestHeader request, StreamObserver<ResponseHeader> responseObserver) {
        System.out.println("findResponseStream:" + request.getId());
        responseObserver.onNext(ResponseHeader.newBuilder().setId(1).build());
        responseObserver.onNext(ResponseHeader.newBuilder().setId(2).build());
        responseObserver.onNext(ResponseHeader.newBuilder().setId(3).build());
        responseObserver.onNext(ResponseHeader.newBuilder().setId(4).build());
        responseObserver.onCompleted();

    }
}
