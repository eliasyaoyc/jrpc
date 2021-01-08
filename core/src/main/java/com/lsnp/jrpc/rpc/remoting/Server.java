package com.lsnp.jrpc.rpc.remoting;

import com.alipay.remoting.rpc.RpcServer;


public class Server {

  private static RpcServer rpcServer;

  private volatile boolean flag;

  public static Server create(int port) {
    return new Server("127.0.0.1", port, false);
  }

  Server(String ip, int port, boolean manageConnection) {
    rpcServer = new RpcServer(ip, port, manageConnection);
    rpcServer.registerUserProcessor(new UserProcessor());
  }

  public void start() {
    if (flag) {
      return;
    }
    rpcServer.start();
    flag = true;
  }

  public void stop() {
    rpcServer.stop();
  }

  public RpcServer getServer() {
    return rpcServer;
  }

  public void registerUserProcessor(com.alipay.remoting.rpc.protocol.UserProcessor userProcessor) {
    rpcServer.registerUserProcessor(userProcessor);
  }


}
