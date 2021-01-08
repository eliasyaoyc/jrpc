package com.lsnp.jrpc.rpc;

import java.io.Serializable;


public class Response implements Serializable {

  private Object result;

  public Response(Object result) {
    this.result = result;
  }

  public Object getResult() {
    return result;
  }

  public void setResult(Object result) {
    this.result = result;
  }
}
