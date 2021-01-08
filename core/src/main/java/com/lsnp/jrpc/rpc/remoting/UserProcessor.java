package com.lsnp.jrpc.rpc.remoting;

import com.alipay.remoting.AsyncContext;
import com.alipay.remoting.BizContext;
import com.alipay.remoting.rpc.protocol.AbstractUserProcessor;
import com.lsnp.jrpc.api.server.Provider;
import com.lsnp.jrpc.api.server.ProviderManager;
import com.lsnp.jrpc.rpc.Request;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SuppressWarnings("unchecked")
public class UserProcessor extends AbstractUserProcessor<Request> {

  /** Just for Test */
  public static Map<String, Method> methods = new ConcurrentHashMap<String, Method>();
  /** Just for Test */
  public static Map<String, Object> targets = new ConcurrentHashMap<String, Object>();


  public UserProcessor() {
  }

  public void handleRequest(BizContext bizCtx, AsyncContext asyncCtx, Request request) {
    // NOOP
  }

  public Object handleRequest(BizContext bizCtx, Request request) throws Exception {
    Provider provider = ProviderManager.getProvider(request.getServiceName());
    request.setMethod(provider.getConfig().getService().getDeclaredMethod(request.getMethodName(), request.getArgTypes()));

    return request.getMethod().invoke(provider.getConfig().getRefProxy(), request.getArgs());
  }

  public String interest() {
    return Request.class.getName();
  }
}
