package crittercism.android;

import org.apache.http.util.CharArrayBuffer;

public final class ah
  extends af
{
  private ai d;
  private int e;
  private int f = 0;
  
  public ah(ai paramai, int paramInt)
  {
    super(paramai);
    d = paramai;
    e = paramInt;
  }
  
  public final boolean a(int paramInt)
  {
    if (f >= e + 2) {}
    do
    {
      do
      {
        return false;
        if (paramInt == -1)
        {
          a.b(a());
          a.a(as.d);
          return true;
        }
        c += 1;
        paramInt = (char)paramInt;
        f += 1;
      } while (f <= e);
      if (paramInt == 10)
      {
        d.b(a());
        a.a(d);
        return true;
      }
    } while ((f != e + 2) || (paramInt == 10));
    a.a(as.d);
    return true;
  }
  
  public final boolean a(CharArrayBuffer paramCharArrayBuffer)
  {
    return true;
  }
  
  public final af b()
  {
    return d;
  }
  
  public final af c()
  {
    return null;
  }
  
  protected final int d()
  {
    return 0;
  }
  
  protected final int e()
  {
    return 0;
  }
  
  public final void f()
  {
    a.b(a());
    a.a(as.d);
  }
}

/* Location:
 * Qualified Name:     crittercism.android.ah
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */