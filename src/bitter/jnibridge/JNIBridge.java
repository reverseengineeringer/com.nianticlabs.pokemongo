package bitter.jnibridge;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JNIBridge
{
  static native void delete(long paramLong);
  
  static void disableInterfaceProxy(Object paramObject)
  {
    ((a)Proxy.getInvocationHandler(paramObject)).a();
  }
  
  static native Object invoke(long paramLong, Class paramClass, Method paramMethod, Object[] paramArrayOfObject);
  
  static Object newInterfaceProxy(long paramLong, Class[] paramArrayOfClass)
  {
    return Proxy.newProxyInstance(JNIBridge.class.getClassLoader(), paramArrayOfClass, new a(paramLong));
  }
  
  private static final class a
    implements InvocationHandler
  {
    private Object a = new Object[0];
    private long b;
    
    public a(long paramLong)
    {
      b = paramLong;
    }
    
    public final void a()
    {
      synchronized (a)
      {
        b = 0L;
        return;
      }
    }
    
    public final void finalize()
    {
      synchronized (a)
      {
        if (b == 0L) {
          return;
        }
        JNIBridge.delete(b);
        return;
      }
    }
    
    public final Object invoke(Object arg1, Method paramMethod, Object[] paramArrayOfObject)
    {
      synchronized (a)
      {
        if (b == 0L) {
          return null;
        }
        paramMethod = JNIBridge.invoke(b, paramMethod.getDeclaringClass(), paramMethod, paramArrayOfObject);
        return paramMethod;
      }
    }
  }
}

/* Location:
 * Qualified Name:     bitter.jnibridge.JNIBridge
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */