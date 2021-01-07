/**
 * MIT License
 *
 * <p>Copyright (c) 2021 mixmicro
 *
 * <p>Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * <p>The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * <p>THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.lsnp.jrpc.core.register;

import com.google.common.collect.Maps;
import com.lsnp.jrpc.common.exceptions.JException;
import com.lsnp.jrpc.common.kits.IdentifyKit;
import com.lsnp.jrpc.core.Url;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nonnull;

/**
 * {@link JMemRegister}
 *
 * @author <a href="mailto:siran0611@gmail.com">Elias.Yao</a>
 * @version ${project.version} - 2021/1/7
 */
public class JMemRegister implements JRegister {

  private static Map<String, Url /* serviceName+version, url*/> registerCenter;

  @Override
  public void init() {
    this.registerCenter = Maps.newConcurrentMap();
  }

  @Override
  public void startup() {
    // pretend to start. just a joke as stupid as HanKe.
  }

  @Override
  public void shutdown() {
    this.registerCenter.clear();
  }

  @Override
  public void registerService(@Nonnull String serviceName, @Nonnull String version, @Nonnull Url url) {
    String key = IdentifyKit.generateKey(serviceName, version);
    registerCenter.put(key, url);
  }

  @Override
  public void unregisterService(@Nonnull String serviceName, @Nonnull String version) {
    registerCenter.remove(IdentifyKit.generateKey(serviceName, version));
  }

  @Override
  public Optional<Url> getServiceUrl(@Nonnull String serviceName, @Nonnull String version) {
    return Optional.ofNullable(registerCenter.get(IdentifyKit.generateKey(serviceName, version)));
  }
}
