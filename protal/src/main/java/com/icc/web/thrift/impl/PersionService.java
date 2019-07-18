package com.icc.web.thrift.impl;

import com.icc.web.thrift.generated.DataException;
import com.icc.web.thrift.generated.DataService;
import com.icc.web.thrift.generated.Person;
import org.apache.thrift.TException;

public class PersionService implements DataService.Iface {
    @Override
    public Person get(int id) throws DataException, TException {
        Person person = new Person();
        person.setId(1);
        person.setAddr("addr");
        person.setName("zz");
        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println(person.toString());
    }
}
