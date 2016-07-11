package crittercism.android;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.net.URL;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;

public final class v
  implements URLStreamHandlerFactory
{
  private static final Object a = new Object();
  private static v b;
  private LinkedList c = new LinkedList();
  private boolean d = false;
  private boolean e = false;
  
  public v(a parama, e parame, d paramd)
  {
    if ((parama == a.c) || (parama == a.a)) {
      c.add(new o(parame, paramd));
    }
    if ((parama == a.c) || (parama == a.b)) {
      c.add(new q(parame, paramd));
    }
  }
  
  public static v a()
  {
    return b;
  }
  
  /* Error */
  private boolean d()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: getstatic 24	crittercism/android/v:a	Ljava/lang/Object;
    //   7: astore_3
    //   8: aload_3
    //   9: monitorenter
    //   10: getstatic 57	crittercism/android/v:b	Lcrittercism/android/v;
    //   13: aload_0
    //   14: if_acmpeq +14 -> 28
    //   17: aload_0
    //   18: getfield 33	crittercism/android/v:d	Z
    //   21: istore_2
    //   22: aload_3
    //   23: monitorexit
    //   24: aload_0
    //   25: monitorexit
    //   26: iload_1
    //   27: ireturn
    //   28: aload_0
    //   29: getfield 33	crittercism/android/v:d	Z
    //   32: ifeq +18 -> 50
    //   35: invokestatic 60	crittercism/android/v:e	()Z
    //   38: ifeq +12 -> 50
    //   41: aload_0
    //   42: iconst_0
    //   43: putfield 33	crittercism/android/v:d	Z
    //   46: aconst_null
    //   47: putstatic 57	crittercism/android/v:b	Lcrittercism/android/v;
    //   50: aload_3
    //   51: monitorexit
    //   52: aload_0
    //   53: getfield 33	crittercism/android/v:d	Z
    //   56: istore_1
    //   57: goto -33 -> 24
    //   60: astore 4
    //   62: aload_3
    //   63: monitorexit
    //   64: aload 4
    //   66: athrow
    //   67: astore_3
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_3
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	v
    //   1	56	1	bool1	boolean
    //   21	1	2	bool2	boolean
    //   67	4	3	localObject2	Object
    //   60	5	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   10	24	60	finally
    //   28	50	60	finally
    //   50	52	60	finally
    //   4	10	67	finally
    //   52	57	67	finally
    //   62	67	67	finally
  }
  
  private static boolean e()
  {
    Field[] arrayOfField = URL.class.getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Field localField = arrayOfField[i];
        if (URLStreamHandlerFactory.class.isAssignableFrom(localField.getType())) {}
        try
        {
          ea localea = ea.f;
          localField.setAccessible(true);
          localField.set(null, null);
          localField.setAccessible(false);
          URL.setURLStreamHandlerFactory(null);
          return true;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          dx.c();
          i += 1;
        }
        catch (SecurityException localSecurityException)
        {
          for (;;)
          {
            dx.c();
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            dx.c();
          }
        }
      }
    }
    return false;
  }
  
  private static boolean f()
  {
    Field[] arrayOfField = URL.class.getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Field localField = arrayOfField[i];
        Object localObject1;
        if (Hashtable.class.isAssignableFrom(localField.getType()))
        {
          Object localObject2 = (ParameterizedType)localField.getGenericType();
          localObject1 = (Class)localObject2.getActualTypeArguments()[0];
          localObject2 = (Class)localObject2.getActualTypeArguments()[1];
          if ((!String.class.isAssignableFrom((Class)localObject1)) || (!URLStreamHandler.class.isAssignableFrom((Class)localObject2))) {}
        }
        try
        {
          localObject1 = ea.g;
          localField.setAccessible(true);
          localObject1 = (Hashtable)localField.get(null);
          if (localObject1 != null) {
            ((Hashtable)localObject1).clear();
          }
          localField.setAccessible(false);
          return true;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          dx.c();
          i += 1;
        }
        catch (SecurityException localSecurityException)
        {
          for (;;)
          {
            dx.c();
          }
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          for (;;)
          {
            dx.c();
          }
        }
      }
    }
    return false;
  }
  
  public final boolean b()
  {
    for (boolean bool = true;; bool = false)
    {
      synchronized (a)
      {
        if (b != null)
        {
          if (b != this) {
            continue;
          }
          return bool;
        }
        if (!d)
        {
          bool = e;
          if (bool) {}
        }
      }
      try
      {
        URL.setURLStreamHandlerFactory(this);
        d = true;
        b = this;
        return d;
        localObject2 = finally;
        throw ((Throwable)localObject2);
      }
      catch (Throwable localThrowable)
      {
        for (;;) {}
      }
    }
  }
  
  public final boolean c()
  {
    boolean bool2 = false;
    for (;;)
    {
      try
      {
        d();
        if (d)
        {
          e = true;
          bool1 = f();
          boolean bool3 = d;
          if ((!bool3) || (bool1)) {
            bool2 = true;
          }
          return bool2;
        }
      }
      finally {}
      boolean bool1 = false;
    }
  }
  
  public final URLStreamHandler createURLStreamHandler(String paramString)
  {
    try
    {
      if (!e)
      {
        Iterator localIterator = c.iterator();
        while (localIterator.hasNext())
        {
          m localm = (m)localIterator.next();
          boolean bool = localm.a().equals(paramString);
          if (bool) {
            return localm;
          }
        }
      }
      return null;
    }
    catch (ThreadDeath paramString)
    {
      throw paramString;
    }
    catch (Throwable paramString)
    {
      e = true;
      dx.a(paramString);
    }
    return null;
  }
  
  public static enum a {}
}

/* Location:
 * Qualified Name:     crittercism.android.v
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */