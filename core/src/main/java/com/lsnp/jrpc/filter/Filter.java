package com.lsnp.jrpc.filter;


import com.lsnp.jrpc.core.Invoker;
import com.lsnp.jrpc.rpc.Request;
import com.lsnp.jrpc.rpc.Response;

public interface Filter {

  Response filter(Invoker invoker, Request req) throws Throwable;
}
