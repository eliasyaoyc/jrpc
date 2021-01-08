package com.lsnp.jrpc.api.client;


import com.lsnp.jrpc.core.ConsumerInvoker;
import com.lsnp.jrpc.proxy.ConsumerInterceptor;
import com.lsnp.jrpc.proxy.ProxyFactory;

public class Consumer<T> {

  private ConsumerConfig config;

  private T proxy;

  public Consumer(ConsumerConfig config) {
    this.config = config;
  }

  @SuppressWarnings("unchecked")
  public T ref() {

    if (proxy != null) {
      return proxy;
    }
    proxy = (T) ProxyFactory.getProxy(config.getService(), new ConsumerInterceptor(new ConsumerInvoker(config)));
    return proxy;
  }

}
