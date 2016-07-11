package crittercism.android;

import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

public final class q
  extends m
{
  private static final String[] f = { "libcore.net.http.HttpsURLConnectionImpl", "org.apache.harmony.luni.internal.net.www.protocol.https.HttpsURLConnectionImpl", "org.apache.harmony.luni.internal.net.www.protocol.https.HttpsURLConnection" };
  
  public q(e parame, d paramd)
  {
    super(parame, paramd, f);
  }
  
  protected final String a()
  {
    return "https";
  }
  
  protected final int getDefaultPort()
  {
    return 443;
  }
  
  protected final URLConnection openConnection(URL paramURL)
  {
    paramURL = (HttpsURLConnection)super.openConnection(paramURL);
    try
    {
      s locals = new s(paramURL, c, d);
      return locals;
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
    paramURL = (HttpsURLConnection)super.openConnection(paramURL, paramProxy);
    try
    {
      paramProxy = new s(paramURL, c, d);
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
 * Qualified Name:     crittercism.android.q
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */