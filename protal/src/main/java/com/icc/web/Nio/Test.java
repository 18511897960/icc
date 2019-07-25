package com.icc.web.Nio;

import java.nio.IntBuffer;
import java.security.SecureRandom;

public class Test {
    public static void main(String[] args) {
        IntBuffer ib = IntBuffer.allocate(10);
        for (int i = 0;i<10;i++) {
            Integer random = new SecureRandom().nextInt();
            ib.put(random);
        }
        ib.flip();
        System.out.println(ib.position());
        ib.get();
        System.out.println(ib.position());
        ib.limit();
        System.out.println(ib.position());
        ib.get(4);
        System.out.println(ib.position());
        ib.asReadOnlyBuffer();
    }
}
