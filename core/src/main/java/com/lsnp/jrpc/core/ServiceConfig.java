package com.lsnp.jrpc.core;


import com.lsnp.jrpc.rpc.remoting.Url;

public interface ServiceConfig {

  String getServiceName();

  void setService(Class<?> service);

  Url getServiceUrl();
}
