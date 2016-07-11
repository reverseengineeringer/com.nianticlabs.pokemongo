package crittercism.android;

import java.io.OutputStream;

public final class u
  extends OutputStream
{
  private final OutputStream a;
  private final c b;
  
  public u(OutputStream paramOutputStream, c paramc)
  {
    if (paramOutputStream == null) {
      throw new NullPointerException("delegate was null");
    }
    if (paramc == null) {
      throw new NullPointerException("stats were null");
    }
    a = paramOutputStream;
    b = paramc;
  }
  
  public final void close()
  {
    a.close();
  }
  
  public final void flush()
  {
    a.flush();
  }
  
  public final void write(int paramInt)
  {
    try
    {
      if (b != null)
      {
        b.b();
        b.c(1L);
      }
      a.write(paramInt);
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
  
  public final void write(byte[] paramArrayOfByte)
  {
    if (b != null)
    {
      b.b();
      if (paramArrayOfByte != null) {
        b.c(paramArrayOfByte.length);
      }
    }
    a.write(paramArrayOfByte);
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (b != null)
    {
      b.b();
      if (paramArrayOfByte != null) {
        b.c(paramInt2);
      }
    }
    a.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}

/* Location:
 * Qualified Name:     crittercism.android.u
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */