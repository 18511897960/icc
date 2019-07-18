package com.icc.web.thrift;

import com.icc.web.thrift.generated.DataService;
import com.icc.web.thrift.generated.Person;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFastFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class ThriftClient {
    public static void main(String[] args) throws  Exception{
        TTransport tTransport = new TFastFramedTransport(new TSocket("localhost",8899),600);
        TProtocol protocol = new TCompactProtocol(tTransport);
        DataService.Client client = new DataService.Client(protocol);
        try {
            tTransport.open();
            Person person = client.get(1);
            System.out.println(person.toString());
            Person person1 = new Person();
            person1.setId(2);
            person1.setName("ls");
            person1.setAddr("addr1");
            client.savePerson(person1);
        } finally {
            tTransport.close();
        }
    }
}
