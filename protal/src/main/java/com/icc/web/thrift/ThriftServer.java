package com.icc.web.thrift;

import com.icc.web.thrift.generated.DataService;
import com.icc.web.thrift.impl.PersionService;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFastFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportFactory;

public class ThriftServer {
    public static void main(String[] args) throws  Exception{
        TNonblockingServerSocket socket = new TNonblockingServerSocket(8899);
        THsHaServer.Args targ = new THsHaServer.Args(socket).minWorkerThreads(2).maxWorkerThreads(4);
        DataService.Processor<PersionService> processor = new DataService.Processor<>(new PersionService());
        //传送格式（协议）
        targ.protocolFactory(new TCompactProtocol.Factory());
        //传输方式
        targ.transportFactory(new TFastFramedTransport.Factory());
        targ.processorFactory(new TProcessorFactory(processor));
        System.out.println("server start");
        TServer server = new THsHaServer(targ);
        server.serve();
            }
}
