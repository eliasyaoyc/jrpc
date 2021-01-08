package com.lsnp.jrpc.proxy;

import com.lsnp.jrpc.core.Invoker;
import com.lsnp.jrpc.filter.FilterChain;
import com.lsnp.jrpc.rpc.Request;
import com.lsnp.jrpc.rpc.Response;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProviderInterceptor implements InvocationHandler {

  private Invoker invoker;

  private FilterChain chain;

  public ProviderInterceptor(Invoker invoker) {
    this.chain = new FilterChain(invoker);
    this.invoker = this.chain.buildFilterChain();
  }

  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

    Request req = buildRequest(method, args);

    Response res = invoker.invoke(req);
    return res.getResult();
  }

  private Request buildRequest(Method method, Object[] args) {
    Request req = new Request();
    req.setServiceName(invoker.getConfig().getServiceName());
    req.setArgs(args);
    req.setMethodName(method.getName());
    req.setIp(invoker.getConfig().getServiceUrl().getIp());
    req.setPort(invoker.getConfig().getServiceUrl().getPort());
    req.setArgTypes(method.getParameterTypes());
    req.setMethod(method);

    return req;
  }

}
