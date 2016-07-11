package crittercism.android;

import org.apache.http.Header;
import org.apache.http.ParseException;
import org.apache.http.message.BasicLineParser;
import org.apache.http.util.CharArrayBuffer;

public abstract class ak
  extends af
{
  boolean d = false;
  int e;
  boolean f = false;
  private boolean g = false;
  private boolean h = false;
  
  public ak(af paramaf)
  {
    super(paramaf);
  }
  
  public final boolean a(CharArrayBuffer paramCharArrayBuffer)
  {
    int i = b.length();
    if ((i == 0) || ((i == 1) && (b.charAt(0) == '\r')))
    {
      i = 1;
      if (i == 0) {
        break label48;
      }
      h = true;
    }
    for (;;)
    {
      return true;
      i = 0;
      break;
      try
      {
        label48:
        paramCharArrayBuffer = BasicLineParser.DEFAULT.parseHeader(paramCharArrayBuffer);
        if ((!d) && (paramCharArrayBuffer.getName().equalsIgnoreCase("content-length")))
        {
          i = Integer.parseInt(paramCharArrayBuffer.getValue());
          if (i < 0) {
            return false;
          }
          d = true;
          e = i;
          return true;
        }
        if (paramCharArrayBuffer.getName().equalsIgnoreCase("transfer-encoding"))
        {
          f = paramCharArrayBuffer.getValue().equalsIgnoreCase("chunked");
          return true;
        }
        if ((!g) && (paramCharArrayBuffer.getName().equalsIgnoreCase("host")))
        {
          paramCharArrayBuffer = paramCharArrayBuffer.getValue();
          if (paramCharArrayBuffer != null)
          {
            g = true;
            a.a(paramCharArrayBuffer);
            return true;
          }
        }
      }
      catch (ParseException paramCharArrayBuffer)
      {
        return false;
      }
      catch (NumberFormatException paramCharArrayBuffer) {}
    }
    return false;
  }
  
  public final af b()
  {
    if (h) {
      return g();
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
    return 32;
  }
  
  protected final int e()
  {
    return 128;
  }
  
  protected abstract af g();
}

/* Location:
 * Qualified Name:     crittercism.android.ak
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */