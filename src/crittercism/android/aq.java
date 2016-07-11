package crittercism.android;

import org.apache.http.util.CharArrayBuffer;

public final class aq
  extends af
{
  private boolean d = false;
  
  public aq(af paramaf)
  {
    super(paramaf);
  }
  
  public final boolean a(CharArrayBuffer paramCharArrayBuffer)
  {
    boolean bool = false;
    if (paramCharArrayBuffer.substringTrimmed(0, paramCharArrayBuffer.length()).length() == 0) {
      bool = true;
    }
    d = bool;
    return true;
  }
  
  public final af b()
  {
    if (d)
    {
      a.b(a());
      return a.b();
    }
    b.clear();
    return this;
  }
  
  public final af c()
  {
    b.clear();
    return new ar(this);
  }
  
  protected final int d()
  {
    return 8;
  }
  
  protected final int e()
  {
    return 128;
  }
}

/* Location:
 * Qualified Name:     crittercism.android.aq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */