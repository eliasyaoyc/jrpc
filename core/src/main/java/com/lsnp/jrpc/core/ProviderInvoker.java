package com.lsnp.jrpc.core;


import com.lsnp.jrpc.api.server.ProviderConfig;
import com.lsnp.jrpc.rpc.Request;
import com.lsnp.jrpc.rpc.Response;
import java.lang.reflect.InvocationTargetException;

@SuppressWarnings("unchecked")
public class ProviderInvoker implements Invoker {

  private Object realObj;
  private ServiceConfig config;

  public ProviderInvoker(Object realObj, ProviderConfig config) {
    this.realObj = realObj;
    this.config = config;
  }

  public Response invoke(Request req) {
    try {
      return new Response(req.getMethod().invoke(realObj, req.getArgs()));
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
    return null;
  }

  public ServiceConfig getConfig() {
    return config;
  }

}
