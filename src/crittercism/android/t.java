package crittercism.android;

import java.io.IOException;
import java.io.InputStream;

public final class t
  extends InputStream
{
  private final InputStream a;
  private final e b;
  private final c c;
  
  public t(InputStream paramInputStream, e parame, c paramc)
  {
    if (paramInputStream == null) {
      throw new NullPointerException("delegate was null");
    }
    if (parame == null) {
      throw new NullPointerException("dispatch was null");
    }
    if (paramc == null) {
      throw new NullPointerException("stats were null");
    }
    a = paramInputStream;
    b = parame;
    c = paramc;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    try
    {
      if (c != null)
      {
        if (paramInt1 == -1)
        {
          b.a(c);
          return;
        }
        c.a(paramInt2);
        return;
      }
    }
    catch (ThreadDeath localThreadDeath)
    {
      throw localThreadDeath;
    }
    catch (Throwable localThrowable)
    {
      dx.a(localThrowable);
    }
  }
  
  private void a(Exception paramException)
  {
    try
    {
      c.a(paramException);
      b.a(c);
      return;
    }
    catch (ThreadDeath paramException)
    {
      throw paramException;
    }
    catch (Throwable paramException)
    {
      dx.a(paramException);
    }
  }
  
  public final int available()
  {
    return a.available();
  }
  
  public final void close()
  {
    a.close();
  }
  
  public final void mark(int paramInt)
  {
    a.mark(paramInt);
  }
  
  public final boolean markSupported()
  {
    return a.markSupported();
  }
  
  public final int read()
  {
    try
    {
      int i = a.read();
      a(i, 1);
      return i;
    }
    catch (IOException localIOException)
    {
      a(localIOException);
      throw localIOException;
    }
  }
  
  public final int read(byte[] paramArrayOfByte)
  {
    try
    {
      int i = a.read(paramArrayOfByte);
      a(i, i);
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
      paramInt1 = a.read(paramArrayOfByte, paramInt1, paramInt2);
      a(paramInt1, paramInt1);
      return paramInt1;
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
      a.reset();
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
    paramLong = a.skip(paramLong);
    try
    {
      if (c != null) {
        c.a(paramLong);
      }
      return paramLong;
    }
    catch (ThreadDeath localThreadDeath)
    {
      throw localThreadDeath;
    }
    catch (Throwable localThrowable)
    {
      dx.a(localThrowable);
    }
    return paramLong;
  }
}

/* Location:
 * Qualified Name:     crittercism.android.t
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */