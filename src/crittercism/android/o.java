package crittercism.android;

import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public final class o
  extends m
{
  private static final String[] f = { "libcore.net.http.HttpURLConnectionImpl", "org.apache.harmony.luni.internal.net.www.protocol.http.HttpURLConnectionImpl", "org.apache.harmony.luni.internal.net.www.protocol.http.HttpURLConnection" };
  
  public o(e parame, d paramd)
  {
    super(parame, paramd, f);
  }
  
  protected final String a()
  {
    return "http";
  }
  
  protected final int getDefaultPort()
  {
    return 80;
  }
  
  protected final URLConnection openConnection(URL paramURL)
  {
    paramURL = (HttpURLConnection)super.openConnection(paramURL);
    try
    {
      r localr = new r(paramURL, c, d);
      return localr;
    }
    catch (ThreadDeath paramURL)
    {
      throw paramURL;
    }
    catch (Throwable localThrowable)
    {
      dx.a(localThrowable);
    }
    return paramURL;
  }
  
  protected final URLConnection openConnection(URL paramURL, Proxy paramProxy)
  {
    paramURL = (HttpURLConnection)super.openConnection(paramURL, paramProxy);
    try
    {
      paramProxy = new r(paramURL, c, d);
      return paramProxy;
    }
    catch (ThreadDeath paramURL)
    {
      throw paramURL;
    }
    catch (Throwable paramProxy)
    {
      dx.a(paramProxy);
    }
    return paramURL;
  }
}

/* Location:
 * Qualified Name:     crittercism.android.o
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */