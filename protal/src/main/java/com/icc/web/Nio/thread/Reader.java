package com.icc.web.Nio.thread;

import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;

public class Reader extends Thread {

    Selector Rselector ;
    boolean adding;
    Reader(int i) throws Exception
    {
        setName("Reader-" + i);
        Rselector = Selector.open();
        System.out.println(getName()+" start ...");

    }

    @Override
    public void run() {
        while (Server.running)
        {
            try {
                Rselector.select();

                while (adding)
                {
                    synchronized (this)
                    {
                        wait(1000);
                    }
                }

                Iterator<SelectionKey> iterator = Rselector.selectedKeys().iterator();
                while (iterator.hasNext())
                {
                    SelectionKey nextKey = iterator.next();
                    iterator.remove();
                    if (nextKey.isValid())
                    {
                        if(nextKey.isReadable())
                        {
                            doRead(nextKey);

                        }
                    }
                }
            } catch (Exception e)
            {
                e.printStackTrace();
            }finally {

            }
        }
    }

    private void doRead(SelectionKey nextKey) throws Exception {
        Connection connection = (Connection) nextKey.attachment();
        if(null != connection)
        {
            return;
        }
        int n;
        try {
            n = connection.process();
        } catch (Exception e) {
            e.printStackTrace();
            n = -1;
        }
        if(-1 == n)
        {
            connection.close();
        }

    }

    public void put()
    {
        adding = true;
        Rselector.wakeup();
    }

    public synchronized void remove()
    {
        adding = false;
        this.notifyAll();
    }
}