package com.lsnp.jrpc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;


public class ProxyFactory {

  public static Object getProxy(Class<?> origin, InvocationHandler h) {
    return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{origin},
        h);
  }


}
