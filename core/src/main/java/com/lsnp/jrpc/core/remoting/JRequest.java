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
package com.lsnp.jrpc.core.remoting;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * {@link JRequest}
 *
 * @author <a href="mailto:siran0611@gmail.com">Elias.Yao</a>
 * @version ${project.version} - 2021/1/7
 */
public class JRequest implements Serializable {

  private String serviceName;
  private String className;
  private String methodName;
  private Method method;
  private Object[] args;
  private Class<?>[] argTypes;
  private String peer;

  private JRequest(String serviceName, String className, String methodName, Method method, Object[] args,
      Class<?>[] argTypes, String peer) {
    this.serviceName = serviceName;
    this.className = className;
    this.methodName = methodName;
    this.method = method;
    this.args = args;
    this.argTypes = argTypes;
    this.peer = peer;
  }

  public static Builder builder() {
    return new Builder();
  }

  public String getServiceName() {
    return serviceName;
  }

  public String getClassName() {
    return className;
  }

  public String getMethodName() {
    return methodName;
  }

  public Method getMethod() {
    return method;
  }

  public Object[] getArgs() {
    return args;
  }

  public Class<?>[] getArgTypes() {
    return argTypes;
  }

  public String getPeer() {
    return peer;
  }

  // =====================  Builder   =====================
  public static class Builder {

    private String serviceName;
    private String className;
    private String methodName;
    private Method method;
    private Object[] args;
    private Class<?>[] argTypes;
    private String peer;

    public Builder serviceName(String serviceName) {
      this.serviceName = serviceName;
      return this;
    }

    public Builder className(String className) {
      this.className = className;
      return this;
    }

    public Builder methodName(String methodName) {
      this.methodName = methodName;
      return this;
    }

    public Builder method(Method method) {
      this.method = method;
      return this;
    }

    public Builder args(Object[] args) {
      this.args = args;
      return this;
    }

    public Builder argTypes(Class<?>[] argTypes) {
      this.argTypes = argTypes;
      return this;
    }

    public Builder peer(String peer) {
      this.peer = peer;
      return this;
    }

    public JRequest build(String serviceName, String className, String methodName, Method method, Object[] args,
        Class<?>[] argTypes, String peer) {
      return new JRequest(serviceName, className, methodName, method, args, argTypes, peer);
    }
  }
}
