package com.lsnp.jrpc.api.server;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class ProviderManager {

  private static Map<String, Provider> cache = new ConcurrentHashMap<String, Provider>();

  public static Provider getProvider(String name) {
    return cache.get(name);
  }

  public static void putProvider(String name, Provider luProvider) {
    cache.put(name, luProvider);
  }


}
