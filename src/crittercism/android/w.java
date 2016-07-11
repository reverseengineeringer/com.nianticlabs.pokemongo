package crittercism.android;

import java.io.OutputStream;

public final class w
  extends OutputStream
  implements al
{
  private ae a;
  private OutputStream b;
  private c c;
  private af d;
  
  public w(ae paramae, OutputStream paramOutputStream)
  {
    if (paramae == null) {
      throw new NullPointerException("socket was null");
    }
    if (paramOutputStream == null) {
      throw new NullPointerException("output stream was null");
    }
    a = paramae;
    b = paramOutputStream;
    d = b();
    if (d == null) {
      throw new NullPointerException("parser was null");
    }
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      d.a(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    catch (ThreadDeath paramArrayOfByte)
    {
      throw paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      dx.a(paramArrayOfByte);
      d = as.d;
    }
  }
  
  private c d()
  {
    if (c == null) {
      c = a.a();
    }
    c localc = c;
    return c;
  }
  
  public final af a()
  {
    return d;
  }
  
  public final void a(int paramInt) {}
  
  public final void a(af paramaf)
  {
    d = paramaf;
  }
  
  public final void a(String paramString)
  {
    c localc = d();
    if (localc != null) {
      localc.b(paramString);
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    c localc = d();
    localc.b();
    f = paramString1;
    i = null;
    paramString1 = h;
    if (paramString2 != null) {
      c = paramString2;
    }
    a.a(localc);
  }
  
  public final boolean a(OutputStream paramOutputStream)
  {
    return b == paramOutputStream;
  }
  
  public final af b()
  {
    return new an(this);
  }
  
  public final void b(int paramInt)
  {
    c localc = c;
    c = null;
    if (localc != null) {
      localc.d(paramInt);
    }
  }
  
  public final String c()
  {
    c localc = d();
    String str = null;
    if (localc != null) {
      str = f;
    }
    return str;
  }
  
  public final void close()
  {
    b.close();
  }
  
  public final void flush()
  {
    b.flush();
  }
  
  public final void write(int paramInt)
  {
    b.write(paramInt);
    try
    {
      d.a(paramInt);
      return;
    }
    catch (ThreadDeath localThreadDeath)
    {
      throw localThreadDeath;
    }
    catch (Throwable localThrowable)
    {
      dx.a(localThrowable);
      d = as.d;
    }
  }
  
  public final void write(byte[] paramArrayOfByte)
  {
    b.write(paramArrayOfByte);
    if (paramArrayOfByte != null) {
      a(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    b.write(paramArrayOfByte, paramInt1, paramInt2);
    if (paramArrayOfByte != null) {
      a(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
}

/* Location:
 * Qualified Name:     crittercism.android.w
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */