package com.lsnp.jrpc.core;


import com.lsnp.jrpc.api.client.ConsumerConfig;
import com.lsnp.jrpc.rpc.Request;
import com.lsnp.jrpc.rpc.Response;
import com.lsnp.jrpc.rpc.remoting.Client;

public class ConsumerInvoker implements Invoker {

  private Client client;
  private ConsumerConfig consumerConfig;

  public ConsumerInvoker(ConsumerConfig consumerConfig) {
    this.consumerConfig = consumerConfig;
    this.client = Client.create();
  }

  public Response invoke(Request req) {
    preHandlerRequest(req);
    Response res = client.invoke(req);
    postHandlerResponse(res);
    return res;
  }

  public ServiceConfig getConfig() {
    return consumerConfig;
  }


  protected void preHandlerRequest(Request req) {
  }

  protected void postHandlerResponse(Response res) {

  }

}
