package com.lsnp.jrpc.api.server;


import com.lsnp.jrpc.rpc.remoting.Server;

@SuppressWarnings("unchecked")
public class Provider<T> {

  private ProviderConfig<T> config;

  public Provider(ProviderConfig config) {
    this.config = config;
  }

  public void export() {
    config.registerService(config.getService(), config.getServiceUrl());

    ProviderManager.putProvider(config.getServiceName(), this);

    Server.create(8081).start();
  }

  public ProviderConfig getConfig() {
    return config;
  }

}
