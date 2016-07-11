package crittercism.android;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.KeyManagementException;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContextSpi;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public final class z
  extends SSLContextSpi
{
  private static Method[] a = new Method[7];
  private static boolean b = false;
  private SSLContextSpi c;
  private e d;
  private d e;
  
  static
  {
    try
    {
      a[0] = SSLContextSpi.class.getDeclaredMethod("engineCreateSSLEngine", new Class[0]);
      a[1] = SSLContextSpi.class.getDeclaredMethod("engineCreateSSLEngine", new Class[] { String.class, Integer.TYPE });
      a[2] = SSLContextSpi.class.getDeclaredMethod("engineGetClientSessionContext", new Class[0]);
      a[3] = SSLContextSpi.class.getDeclaredMethod("engineGetServerSessionContext", new Class[0]);
      a[4] = SSLContextSpi.class.getDeclaredMethod("engineGetServerSocketFactory", new Class[0]);
      a[5] = SSLContextSpi.class.getDeclaredMethod("engineGetSocketFactory", new Class[0]);
      a[6] = SSLContextSpi.class.getDeclaredMethod("engineInit", new Class[] { KeyManager[].class, TrustManager[].class, SecureRandom.class });
      j.a(a);
      z localz = new z(new z(), null, null);
      localz.engineCreateSSLEngine();
      localz.engineCreateSSLEngine(null, 0);
      localz.engineGetClientSessionContext();
      localz.engineGetServerSessionContext();
      localz.engineGetServerSocketFactory();
      localz.engineGetSocketFactory();
      localz.engineInit(null, null, null);
      b = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      dx.c();
      b = false;
    }
  }
  
  private z() {}
  
  private z(SSLContextSpi paramSSLContextSpi, e parame, d paramd)
  {
    c = paramSSLContextSpi;
    d = parame;
    e = paramd;
  }
  
  public static z a(SSLContextSpi paramSSLContextSpi, e parame, d paramd)
  {
    if (!b) {
      return null;
    }
    return new z(paramSSLContextSpi, parame, paramd);
  }
  
  private Object a(int paramInt, Object... paramVarArgs)
  {
    if (c == null) {
      return null;
    }
    try
    {
      paramVarArgs = a[paramInt].invoke(c, paramVarArgs);
      return paramVarArgs;
    }
    catch (IllegalArgumentException paramVarArgs)
    {
      throw new ck(paramVarArgs);
    }
    catch (IllegalAccessException paramVarArgs)
    {
      throw new ck(paramVarArgs);
    }
    catch (InvocationTargetException paramVarArgs)
    {
      Throwable localThrowable = paramVarArgs.getTargetException();
      if (localThrowable == null) {
        throw new ck(paramVarArgs);
      }
      if ((localThrowable instanceof Exception)) {
        throw ((Exception)localThrowable);
      }
      if ((localThrowable instanceof Error)) {
        throw ((Error)localThrowable);
      }
      throw new ck(paramVarArgs);
    }
    catch (ClassCastException paramVarArgs)
    {
      throw new ck(paramVarArgs);
    }
  }
  
  private Object a(Object... paramVarArgs)
  {
    try
    {
      paramVarArgs = a(6, paramVarArgs);
      return paramVarArgs;
    }
    catch (RuntimeException paramVarArgs)
    {
      throw paramVarArgs;
    }
    catch (KeyManagementException paramVarArgs)
    {
      throw paramVarArgs;
    }
    catch (Exception paramVarArgs)
    {
      throw new ck(paramVarArgs);
    }
  }
  
  public static boolean a()
  {
    return b;
  }
  
  private Object b(int paramInt, Object... paramVarArgs)
  {
    try
    {
      paramVarArgs = a(paramInt, paramVarArgs);
      return paramVarArgs;
    }
    catch (RuntimeException paramVarArgs)
    {
      throw paramVarArgs;
    }
    catch (Exception paramVarArgs)
    {
      throw new ck(paramVarArgs);
    }
  }
  
  protected final SSLEngine engineCreateSSLEngine()
  {
    return (SSLEngine)b(0, new Object[0]);
  }
  
  protected final SSLEngine engineCreateSSLEngine(String paramString, int paramInt)
  {
    return (SSLEngine)b(1, new Object[] { paramString, Integer.valueOf(paramInt) });
  }
  
  protected final SSLSessionContext engineGetClientSessionContext()
  {
    return (SSLSessionContext)b(2, new Object[0]);
  }
  
  protected final SSLSessionContext engineGetServerSessionContext()
  {
    return (SSLSessionContext)b(3, new Object[0]);
  }
  
  protected final SSLServerSocketFactory engineGetServerSocketFactory()
  {
    return (SSLServerSocketFactory)b(4, new Object[0]);
  }
  
  protected final SSLSocketFactory engineGetSocketFactory()
  {
    SSLSocketFactory localSSLSocketFactory = (SSLSocketFactory)b(5, new Object[0]);
    Object localObject = localSSLSocketFactory;
    if (localSSLSocketFactory != null) {}
    try
    {
      localObject = new ab(localSSLSocketFactory, d, e);
      return (SSLSocketFactory)localObject;
    }
    catch (ThreadDeath localThreadDeath)
    {
      throw localThreadDeath;
    }
    catch (Throwable localThrowable)
    {
      dx.a(localThrowable);
    }
    return localSSLSocketFactory;
  }
  
  protected final void engineInit(KeyManager[] paramArrayOfKeyManager, TrustManager[] paramArrayOfTrustManager, SecureRandom paramSecureRandom)
  {
    a(new Object[] { paramArrayOfKeyManager, paramArrayOfTrustManager, paramSecureRandom });
  }
  
  public final boolean equals(Object paramObject)
  {
    SSLContextSpi localSSLContextSpi = c;
    return c.equals(paramObject);
  }
  
  public final int hashCode()
  {
    SSLContextSpi localSSLContextSpi = c;
    return c.hashCode();
  }
  
  public final String toString()
  {
    SSLContextSpi localSSLContextSpi = c;
    return c.toString();
  }
}

/* Location:
 * Qualified Name:     crittercism.android.z
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */