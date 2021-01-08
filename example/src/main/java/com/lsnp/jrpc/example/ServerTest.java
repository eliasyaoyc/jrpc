package com.lsnp.jrpc.example;


import com.lsnp.jrpc.api.server.Provider;
import com.lsnp.jrpc.api.server.ProviderConfig;
import com.lsnp.jrpc.common.exceptions.JException;
import com.lsnp.jrpc.rpc.remoting.Url;
import com.lsnp.jrpc.rpc.remoting.UserProcessor;


public class ServerTest {

  public static void main(String[] args) throws NoSuchMethodException, JException {
    UserProcessor.methods.put("hello", Demo.class.getMethod("hello", String.class));
    UserProcessor.targets.put("Demo", new DemoImpl());
    ProviderConfig luProviderConfig = new ProviderConfig();

    luProviderConfig.setService(Demo.class);
    luProviderConfig.setRef(DemoImpl.class);
    luProviderConfig.setServiceUrl(new Url("127.0.0.1", 8081));

    Provider luProvider = new Provider(luProviderConfig);

    luProvider.export();
  }
}
