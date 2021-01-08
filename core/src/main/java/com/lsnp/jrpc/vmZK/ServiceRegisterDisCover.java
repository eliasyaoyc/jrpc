package com.lsnp.jrpc.vmZK;


import com.lsnp.jrpc.rpc.remoting.Url;

public interface ServiceRegisterDisCover {


  void registerService(String serviceName, Url url);

  void unregisterService(String serviceName);

  Url getServiceUrl(String serviceName);

}
