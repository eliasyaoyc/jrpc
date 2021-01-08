package com.lsnp.jrpc.api.server;


import com.lsnp.jrpc.core.BaseServiceConfig;
import com.lsnp.jrpc.core.ProviderInvoker;
import com.lsnp.jrpc.proxy.ProviderInterceptor;
import com.lsnp.jrpc.proxy.ProxyFactory;
import com.lsnp.jrpc.rpc.remoting.Url;

public class ProviderConfig<T> extends BaseServiceConfig {

  private Object ref;

  private Object refProxy;

  public Object getRef() {
    return ref;
  }


  public void setRef(Class ref) {
    try {
      this.ref = ref.newInstance();
      this.refProxy = ProxyFactory.getProxy(getService(), new ProviderInterceptor(new ProviderInvoker(this.ref, this)));
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
  }

  public void setRef(Object ref) {
    this.ref = ref;
    this.refProxy = ProxyFactory.getProxy(getService(), new ProviderInterceptor(new ProviderInvoker(this.ref, this)));
  }

  public Object getRefProxy() {
    return refProxy;
  }

  public void setRefProxy(Object refProxy) {
    this.refProxy = refProxy;
  }

  public Url getServiceUrl() {
    return serviceRegisterDisCover.getServiceUrl(getServiceName());
  }

  public void setServiceUrl(Url url) {
    serviceRegisterDisCover.registerService(getServiceName(), url);
  }

  void registerService(Class<T> serviceClass, Url url) {
    serviceRegisterDisCover.registerService(serviceClass.getName(), url);
  }

  void registerService(Class<T> serviceClass) {
    registerService(serviceClass, new Url());
  }
}
