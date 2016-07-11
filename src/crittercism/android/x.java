package crittercism.android;

import java.io.IOException;
import java.io.InputStream;

public final class x
  extends InputStream
  implements al
{
  private ae a;
  private c b;
  private InputStream c;
  private e d;
  private af e;
  
  public x(ae paramae, InputStream paramInputStream, e parame)
  {
    if (paramae == null) {
      throw new NullPointerException("socket was null");
    }
    if (paramInputStream == null) {
      throw new NullPointerException("delegate was null");
    }
    if (parame == null) {
      throw new NullPointerException("dispatch was null");
    }
    a = paramae;
    c = paramInputStream;
    d = parame;
    e = b();
    if (e == null) {
      throw new NullPointerException("parser was null");
    }
  }
  
  private void a(Exception paramException)
  {
    try
    {
      c localc = e();
      localc.a(paramException);
      d.a(localc, c.a.h);
      return;
    }
    catch (ThreadDeath paramException)
    {
      throw paramException;
    }
    catch (Throwable paramException)
    {
      dx.a(paramException);
      return;
    }
    catch (IllegalStateException paramException) {}
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      e.a(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    catch (ThreadDeath paramArrayOfByte)
    {
      throw paramArrayOfByte;
    }
    catch (IllegalStateException paramArrayOfByte)
    {
      e = as.d;
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      e = as.d;
      dx.a(paramArrayOfByte);
    }
  }
  
  private c e()
  {
    if (b == null) {
      b = a.b();
    }
    if (b == null) {
      throw new IllegalStateException("No statistics were queued up.");
    }
    return b;
  }
  
  public final af a()
  {
    return e;
  }
  
  public final void a(int paramInt)
  {
    c localc = e();
    localc.c();
    e = paramInt;
  }
  
  public final void a(af paramaf)
  {
    e = paramaf;
  }
  
  public final void a(String paramString) {}
  
  public final void a(String paramString1, String paramString2) {}
  
  public final boolean a(InputStream paramInputStream)
  {
    return c == paramInputStream;
  }
  
  public final int available()
  {
    return c.available();
  }
  
  public final af b()
  {
    return new ap(this);
  }
  
  public final void b(int paramInt)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    c localc = b;
    if (b != null)
    {
      int i = b.e;
      localObject1 = localObject2;
      if (i >= 100)
      {
        localObject1 = localObject2;
        if (i < 200)
        {
          localObject1 = new c(b.a());
          ((c)localObject1).e(b.a);
          ((c)localObject1).d(b.d);
          f = b.f;
        }
      }
      b.b(paramInt);
      d.a(b, c.a.g);
    }
    b = ((c)localObject1);
  }
  
  public final String c()
  {
    return ef;
  }
  
  public final void close()
  {
    try
    {
      e.f();
      c.close();
      return;
    }
    catch (ThreadDeath localThreadDeath)
    {
      throw localThreadDeath;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        dx.a(localThrowable);
      }
    }
  }
  
  public final void d()
  {
    if (b != null)
    {
      cn localcn = b.g;
      cm localcm = cm.a;
      if ((a != co.d.ordinal()) || (b != localcm.a())) {
        break label64;
      }
    }
    label64:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (e != null)) {
        e.f();
      }
      return;
    }
  }
  
  public final void mark(int paramInt)
  {
    c.mark(paramInt);
  }
  
  public final boolean markSupported()
  {
    return c.markSupported();
  }
  
  public final int read()
  {
    try
    {
      int i = c.read();
      return i;
    }
    catch (IOException localIOException)
    {
      try
      {
        e.a(i);
        return i;
      }
      catch (ThreadDeath localThreadDeath)
      {
        throw localThreadDeath;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        e = as.d;
        return i;
      }
      catch (Throwable localThrowable)
      {
        e = as.d;
        dx.a(localThrowable);
      }
      localIOException = localIOException;
      a(localIOException);
      throw localIOException;
    }
  }
  
  public final int read(byte[] paramArrayOfByte)
  {
    try
    {
      int i = c.read(paramArrayOfByte);
      a(paramArrayOfByte, 0, i);
      return i;
    }
    catch (IOException paramArrayOfByte)
    {
      a(paramArrayOfByte);
      throw paramArrayOfByte;
    }
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramInt2 = c.read(paramArrayOfByte, paramInt1, paramInt2);
      a(paramArrayOfByte, paramInt1, paramInt2);
      return paramInt2;
    }
    catch (IOException paramArrayOfByte)
    {
      a(paramArrayOfByte);
      throw paramArrayOfByte;
    }
  }
  
  public final void reset()
  {
    try
    {
      c.reset();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final long skip(long paramLong)
  {
    return c.skip(paramLong);
  }
}

/* Location:
 * Qualified Name:     crittercism.android.x
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */