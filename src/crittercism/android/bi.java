package crittercism.android;

import android.content.Context;
import android.os.ConditionVariable;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class bi
  extends di
  implements bt
{
  private long a = System.currentTimeMillis();
  private volatile long b = 10000L;
  private ConditionVariable c = new ConditionVariable(false);
  private ConditionVariable d = new ConditionVariable(false);
  private au e;
  private bs f;
  private bs g;
  private bs h;
  private bs i;
  private URL j;
  private Context k;
  private volatile boolean l = false;
  
  public bi(Context arg1, au paramau, bs parambs1, bs parambs2, bs parambs3, bs parambs4, URL paramURL)
  {
    k = ???;
    f = parambs1;
    g = parambs2;
    h = parambs3;
    i = parambs4;
    e = paramau;
    j = paramURL;
    paramau = f;
    if (this != null) {}
    synchronized (c)
    {
      c.add(this);
      return;
    }
  }
  
  private JSONObject a(JSONArray paramJSONArray)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("appID", e.a());
      localJSONObject2.put("deviceID", e.c());
      localJSONObject2.put("crPlatform", "android");
      localJSONObject2.put("crVersion", e.d());
      localJSONObject2.put("deviceModel", e.j());
      localJSONObject2.put("osName", "android");
      localJSONObject2.put("osVersion", e.k());
      localJSONObject2.put("carrier", e.f());
      localJSONObject2.put("mobileCountryCode", e.g());
      localJSONObject2.put("mobileNetworkCode", e.h());
      localJSONObject2.put("appVersion", e.b());
      localJSONObject2.put("locale", bx.ka);
      localJSONObject1.put("appState", localJSONObject2);
      localJSONObject1.put("transactions", paramJSONArray);
      if (b(paramJSONArray))
      {
        localJSONObject1.put("breadcrumbs", bog).a);
        localJSONObject1.put("endpoints", boh).a);
        localJSONObject1.put("systemBreadcrumbs", boi).a);
      }
      return localJSONObject1;
    }
    catch (JSONException paramJSONArray) {}
    return null;
  }
  
  private static boolean b(JSONArray paramJSONArray)
  {
    boolean bool2 = false;
    int m = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      Object localObject;
      if (m < paramJSONArray.length())
      {
        localObject = paramJSONArray.optJSONArray(m);
        if (localObject == null) {
          break label79;
        }
      }
      try
      {
        localObject = new bg((JSONArray)localObject).k();
        if ((localObject != bg.a.c) && (localObject != bg.a.i))
        {
          bg.a locala = bg.a.h;
          if (localObject != locala)
          {
            bool1 = true;
            return bool1;
          }
        }
      }
      catch (JSONException localJSONException)
      {
        dx.a(localJSONException);
        m += 1;
      }
      catch (ParseException localParseException)
      {
        for (;;)
        {
          label79:
          dx.a(localParseException);
        }
      }
    }
  }
  
  public final void a()
  {
    for (;;)
    {
      if (!l)
      {
        c.block();
        d.block();
        if (!l) {}
      }
      else
      {
        return;
      }
      long l1 = b - (System.currentTimeMillis() - a);
      if (l1 > 0L) {}
      try
      {
        Thread.sleep(l1);
        a = System.currentTimeMillis();
        Object localObject1 = f.a(k);
        f.a((bs)localObject1);
        Object localObject2 = boa;
        eb.a(a);
        if ((((JSONArray)localObject2).length() <= 0) || (a((JSONArray)localObject2) == null)) {
          continue;
        }
        localObject1 = a((JSONArray)localObject2);
        try
        {
          localObject2 = new dc(j).a();
          OutputStream localOutputStream = ((HttpURLConnection)localObject2).getOutputStream();
          localOutputStream.write(((JSONObject)localObject1).toString().getBytes("UTF8"));
          localOutputStream.close();
          ((HttpURLConnection)localObject2).getResponseCode();
          ((HttpURLConnection)localObject2).disconnect();
        }
        catch (IOException localIOException)
        {
          new StringBuilder("Request failed for ").append(j);
          dx.a();
        }
        catch (GeneralSecurityException localGeneralSecurityException)
        {
          new StringBuilder("Request failed for ").append(j);
          dx.a();
          dx.a(localGeneralSecurityException);
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;) {}
      }
    }
  }
  
  public final void a(int paramInt, TimeUnit paramTimeUnit)
  {
    b = paramTimeUnit.toMillis(paramInt);
  }
  
  public final void b()
  {
    c.open();
  }
  
  public final void c()
  {
    bs localbs = f;
    d.open();
  }
  
  public final void d()
  {
    bs localbs = f;
    d.close();
  }
}

/* Location:
 * Qualified Name:     crittercism.android.bi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */