package com.icc.web.Nio;

import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;

public class Test4 {
    public static void main(String[] args) {
        Set<Map.Entry<String, Charset>> entries = Charset.availableCharsets().entrySet();
        for (Map.Entry<String, Charset> map:entries) {
            System.out.println("key: " + map.getKey() + ", value: "+ map.getValue());
        }
    }
}
