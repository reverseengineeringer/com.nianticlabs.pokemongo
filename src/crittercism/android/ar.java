package crittercism.android;

import org.apache.http.util.CharArrayBuffer;

public final class ar
  extends af
{
  private af d;
  
  public ar(af paramaf)
  {
    super(paramaf);
    d = paramaf;
  }
  
  public final boolean a(int paramInt)
  {
    if (paramInt == -1)
    {
      a.a(as.d);
      return true;
    }
    c += 1;
    if ((char)paramInt == '\n')
    {
      d.b(a());
      a.a(d);
      return true;
    }
    return false;
  }
  
  public final boolean a(CharArrayBuffer paramCharArrayBuffer)
  {
    return true;
  }
  
  public final af b()
  {
    return this;
  }
  
  public final af c()
  {
    return this;
  }
  
  protected final int d()
  {
    return 0;
  }
  
  protected final int e()
  {
    return 0;
  }
}

/* Location:
 * Qualified Name:     crittercism.android.ar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */