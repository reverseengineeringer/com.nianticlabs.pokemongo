package crittercism.android;

import org.apache.http.util.CharArrayBuffer;

public final class ai
  extends af
{
  private int d = -1;
  
  public ai(af paramaf)
  {
    super(paramaf);
  }
  
  public final boolean a(CharArrayBuffer paramCharArrayBuffer)
  {
    int i = paramCharArrayBuffer.indexOf(59);
    int j = paramCharArrayBuffer.length();
    if (i > 0) {}
    for (;;)
    {
      try
      {
        d = Integer.parseInt(paramCharArrayBuffer.substringTrimmed(0, i), 16);
        return true;
      }
      catch (NumberFormatException paramCharArrayBuffer)
      {
        return false;
      }
      i = j;
    }
  }
  
  public final af b()
  {
    int i = d;
    if (d == 0) {
      return new aq(this);
    }
    b.clear();
    return new ah(this, d);
  }
  
  public final af c()
  {
    return as.d;
  }
  
  protected final int d()
  {
    return 16;
  }
  
  protected final int e()
  {
    return 256;
  }
  
  public final void f()
  {
    a.b(a());
    a.a(as.d);
  }
}

/* Location:
 * Qualified Name:     crittercism.android.ai
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */