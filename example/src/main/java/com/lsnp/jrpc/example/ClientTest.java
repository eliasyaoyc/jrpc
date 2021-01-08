package com.lsnp.jrpc.example;


import com.lsnp.jrpc.api.client.Consumer;
import com.lsnp.jrpc.api.client.ConsumerConfig;

public class ClientTest {

  public static void main(String[] args) throws InterruptedException {
    ConsumerConfig luConsumerConfig = new ConsumerConfig();
    luConsumerConfig.setService(Demo.class);
    Consumer<Demo> luConsumer = new Consumer<Demo>(luConsumerConfig);
    Demo demo = luConsumer.ref();

    for (; ; ) {
      System.out.println(demo.hello("hello"));
      Thread.sleep(1111);
    }
  }
}
