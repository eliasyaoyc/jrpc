package com.lsnp.jrpc.filter;


import com.lsnp.jrpc.core.Invoker;
import com.lsnp.jrpc.core.ServiceConfig;
import com.lsnp.jrpc.rpc.Request;
import com.lsnp.jrpc.rpc.Response;

public class FilterWrapper implements Invoker {

  private Filter next;

  private Invoker invoker;

  private ServiceConfig config;

  public FilterWrapper(Filter next, Invoker invoker) {
    this.next = next;
    this.invoker = invoker;
    this.config = invoker.getConfig();
  }


  @Override
  public Response invoke(Request args) throws Throwable {
    if (next != null) {
      return next.filter(invoker, args);
    } else {
      return invoker.invoke(args);
    }
  }

  public ServiceConfig getConfig() {
    return config;
  }
}
