package crittercism.android;

import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public final class dc
{
  private static SSLSocketFactory a = null;
  private URL b;
  private Map c = new HashMap();
  private int d = 0;
  private boolean e = true;
  private boolean f = true;
  private String g = "POST";
  private boolean h = false;
  private int i = 2500;
  
  static
  {
    try
    {
      Object localObject = SSLContext.getInstance("TLS");
      ((SSLContext)localObject).init(null, null, null);
      localObject = ((SSLContext)localObject).getSocketFactory();
      if (localObject != null)
      {
        if ((localObject instanceof ab))
        {
          a = ((ab)localObject).a();
          return;
        }
        a = (SSLSocketFactory)localObject;
        return;
      }
    }
    catch (GeneralSecurityException localGeneralSecurityException)
    {
      a = null;
    }
  }
  
  public dc(URL paramURL)
  {
    b = paramURL;
    c.put("User-Agent", Arrays.asList(new String[] { "5.0.8" }));
    c.put("Content-Type", Arrays.asList(new String[] { "application/json" }));
    c.put("Accept", Arrays.asList(new String[] { "text/plain", "application/json" }));
  }
  
  public final HttpURLConnection a()
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)b.openConnection();
    Object localObject = c.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      Iterator localIterator = ((List)localEntry.getValue()).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localHttpURLConnection.addRequestProperty((String)localEntry.getKey(), str);
      }
    }
    localHttpURLConnection.setConnectTimeout(i);
    localHttpURLConnection.setReadTimeout(i);
    localHttpURLConnection.setDoInput(e);
    localHttpURLConnection.setDoOutput(f);
    if (h) {
      localHttpURLConnection.setChunkedStreamingMode(d);
    }
    localHttpURLConnection.setRequestMethod(g);
    if ((localHttpURLConnection instanceof HttpsURLConnection))
    {
      localObject = (HttpsURLConnection)localHttpURLConnection;
      if (a != null) {
        ((HttpsURLConnection)localObject).setSSLSocketFactory(a);
      }
    }
    else
    {
      return localHttpURLConnection;
    }
    throw new GeneralSecurityException();
  }
}

/* Location:
 * Qualified Name:     crittercism.android.dc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */