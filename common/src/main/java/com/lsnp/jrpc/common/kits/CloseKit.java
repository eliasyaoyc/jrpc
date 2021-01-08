package com.lsnp.jrpc.common.kits;

import java.io.Closeable;
import java.io.IOException;


public class CloseKit {

  public static void close(Closeable closeable) {
    try {
      if (closeable != null) {
        closeable.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
