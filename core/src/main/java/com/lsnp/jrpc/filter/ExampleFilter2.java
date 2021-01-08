package com.lsnp.jrpc.filter;


import com.lsnp.jrpc.core.Invoker;
import com.lsnp.jrpc.rpc.Request;
import com.lsnp.jrpc.rpc.Response;

public class ExampleFilter2 implements Filter {

  @Override
  public Response filter(Invoker invoker, Request req) throws Throwable {
    if (req == null) {
      throw new IllegalArgumentException("req  not be null");
    }
    System.out.println("ExampleFilter 2 ");
    return invoker.invoke(req);
  }
}
