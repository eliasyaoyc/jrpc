package com.lsnp.jrpc.example;


public class DemoImpl implements Demo {

    public String hello(String string) {
        System.out.println("receive client : " + string);
        return "server reply --- >" + string;
    }
}
