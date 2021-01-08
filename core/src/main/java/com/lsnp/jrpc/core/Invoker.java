package com.lsnp.jrpc.core;


import com.lsnp.jrpc.rpc.Request;
import com.lsnp.jrpc.rpc.Response;

public interface Invoker {


  Response invoke(Request req) throws Throwable;


  ServiceConfig getConfig();
}
