package com.lsnp.jrpc.api.client;

import com.lsnp.jrpc.core.BaseServiceConfig;
import com.lsnp.jrpc.rpc.remoting.Url;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumerConfig extends BaseServiceConfig {

  private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerConfig.class);


  @Override
  public Url getServiceUrl() {
    try {
      return serviceRegisterDisCover.getServiceUrl(getServiceName());

    } catch (Exception e) {
      LOGGER.error(e.getMessage(), e);
      System.exit(1);
    }
    return null;
  }
}
