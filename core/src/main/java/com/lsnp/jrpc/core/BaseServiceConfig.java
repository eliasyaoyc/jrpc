package com.lsnp.jrpc.core;


import com.lsnp.jrpc.vmZK.LocalFileRegister;
import com.lsnp.jrpc.vmZK.ServiceRegisterDisCover;


public abstract class BaseServiceConfig implements ServiceConfig {

  protected ServiceRegisterDisCover serviceRegisterDisCover = new LocalFileRegister();

  private Class<?> service;

  public String getServiceName() {
    return service.getName();
  }

  public void setService(Class<?> service) {
    this.service = service;
  }

  public Class getService() {
    return service;
  }
}
