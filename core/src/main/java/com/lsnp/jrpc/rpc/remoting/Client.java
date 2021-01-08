package com.lsnp.jrpc.rpc.remoting;

import com.alipay.remoting.exception.RemotingException;
import com.alipay.remoting.rpc.RpcClient;
import com.lsnp.jrpc.rpc.Request;
import com.lsnp.jrpc.rpc.Response;

public class Client {

  private final static RpcClient client = new RpcClient();

  static {
    client.init();
  }

  public static Client create() {
    return new Client();
  }

  private Client() {
  }

  public Response invoke(Request req) {
    try {

      Object result = client.invokeSync(req.getUrl(), req, 2000);
      return new Response(result);

    } catch (RemotingException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    throw new RuntimeException("invoke error");
  }


}
