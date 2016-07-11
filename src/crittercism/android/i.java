package crittercism.android;

import android.os.Build.VERSION;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.Socket;
import java.net.SocketImpl;
import java.net.SocketImplFactory;
import java.net.URL;
import java.net.URLStreamHandler;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;

public final class i
{
  public static final v.a a = v.a.b;
  public static b b = b.c;
  private static final List c = new LinkedList();
  private ad d;
  private ab e;
  private ab f;
  private v g;
  private e h;
  private d i;
  private b j = b;
  private v.a k = a;
  
  static
  {
    try
    {
      URL localURL = new URL("https://www.google.com");
      if ((((URLStreamHandler)j.a(j.a(URL.class, URLStreamHandler.class), localURL)).getClass().getName().contains("okhttp")) && (Build.VERSION.SDK_INT >= 19))
      {
        b = b.a;
        return;
      }
      b = b.b;
      return;
    }
    catch (Exception localException)
    {
      b = b.c;
    }
  }
  
  public i(e parame, d paramd)
  {
    h = parame;
    i = paramd;
  }
  
  private static void a(String paramString, Throwable paramThrowable)
  {
    synchronized (c)
    {
      c.add(paramThrowable);
      dx.c(paramString);
      return;
    }
  }
  
  private static void a(javax.net.ssl.SSLSocketFactory paramSSLSocketFactory)
  {
    org.apache.http.conn.ssl.SSLSocketFactory localSSLSocketFactory = org.apache.http.conn.ssl.SSLSocketFactory.getSocketFactory();
    j.a(org.apache.http.conn.ssl.SSLSocketFactory.class, javax.net.ssl.SSLSocketFactory.class).set(localSSLSocketFactory, paramSSLSocketFactory);
  }
  
  private static boolean a(SocketImplFactory paramSocketImplFactory)
  {
    try
    {
      Field localField = j.a(Socket.class, SocketImplFactory.class);
      return false;
    }
    catch (cl paramSocketImplFactory)
    {
      try
      {
        localField.setAccessible(true);
        localField.set(null, paramSocketImplFactory);
        return true;
      }
      catch (IllegalArgumentException paramSocketImplFactory)
      {
        a("Unable to install OPTIMZ for http connections", paramSocketImplFactory);
        return true;
      }
      catch (IllegalAccessException paramSocketImplFactory)
      {
        a("Unable to install OPTIMZ for http connections", paramSocketImplFactory);
        return false;
      }
      catch (NullPointerException paramSocketImplFactory)
      {
        a("Unable to install OPTIMZ for http connections", paramSocketImplFactory);
      }
      paramSocketImplFactory = paramSocketImplFactory;
      a("Unable to install OPTIMZ for http connections", paramSocketImplFactory);
      return false;
    }
  }
  
  public static void d()
  {
    synchronized (c)
    {
      Iterator localIterator = c.iterator();
      if (localIterator.hasNext()) {
        dx.a((Throwable)localIterator.next());
      }
    }
    c.clear();
  }
  
  private boolean e()
  {
    a locala = new a(this);
    Thread localThread = new Thread(locala);
    localThread.start();
    try
    {
      localThread.join();
      return locala.a();
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  private boolean f()
  {
    try
    {
      g = new v(k, h, i);
      boolean bool = g.b();
      return bool;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return false;
  }
  
  private static javax.net.ssl.SSLSocketFactory g()
  {
    org.apache.http.conn.ssl.SSLSocketFactory localSSLSocketFactory = org.apache.http.conn.ssl.SSLSocketFactory.getSocketFactory();
    return (javax.net.ssl.SSLSocketFactory)j.a(org.apache.http.conn.ssl.SSLSocketFactory.class, javax.net.ssl.SSLSocketFactory.class).get(localSSLSocketFactory);
  }
  
  private boolean h()
  {
    SocketImpl localSocketImpl = null;
    SocketImplFactory localSocketImplFactory;
    try
    {
      localSocketImplFactory = (SocketImplFactory)j.a(j.a(Socket.class, SocketImplFactory.class), null);
      if (localSocketImplFactory != null) {
        break label112;
      }
      try
      {
        localSocketImpl = (SocketImpl)j.a(j.a(Socket.class, SocketImpl.class), new Socket());
        if (localSocketImpl == null) {
          throw new cl("SocketImpl was null");
        }
      }
      catch (cl localcl1)
      {
        a("Unable to install OPTIMZ for http connections", localcl1);
        return false;
      }
      localObject = localcl2.getClass();
    }
    catch (cl localcl2)
    {
      a("Unable to install OPTIMZ for http connections", localcl2);
      return false;
    }
    Object localObject;
    if (localSocketImplFactory != null) {}
    for (;;)
    {
      try
      {
        localObject = new ad(localSocketImplFactory, h, i);
        a((SocketImplFactory)localObject);
        d = ((ad)localObject);
        return true;
      }
      catch (cl localcl3)
      {
        a("Unable to install OPTIMZ for http connections", localcl3);
        return false;
        a("Unable to install OPTIMZ for http connections", new NullPointerException("Null SocketImpl"));
        return false;
      }
      catch (IOException localIOException)
      {
        label112:
        a("Unable to install OPTIMZ for http connections", localIOException);
      }
      if (!(localSocketImplFactory instanceof ad)) {
        break;
      }
      return true;
      if (localObject == null) {
        continue;
      }
      localObject = new ad((Class)localObject, h, i);
      Socket.setSocketImplFactory((SocketImplFactory)localObject);
    }
    return false;
  }
  
  public final boolean a()
  {
    boolean bool3 = false;
    if (!ac.c())
    {
      a("Unable to install OPTMZ", ac.d());
      return bool3;
    }
    label125:
    label156:
    label175:
    for (;;)
    {
      boolean bool1;
      try
      {
        ac.e();
        bool1 = h() | false;
        if (Build.VERSION.SDK_INT >= 19)
        {
          bool2 = bool1 | e();
          if (Build.VERSION.SDK_INT < 17) {
            break label175;
          }
          bool2 |= y.a(h, i);
          if (j != b.a) {
            break label156;
          }
          javax.net.ssl.SSLSocketFactory localSSLSocketFactory = HttpsURLConnection.getDefaultSSLSocketFactory();
          if (!(localSSLSocketFactory instanceof ab)) {
            break label125;
          }
          e = ((ab)localSSLSocketFactory);
          return bool2 | true;
        }
      }
      catch (ck localck)
      {
        dx.a(localck.toString(), localck);
        return false;
      }
      boolean bool2 = bool1 | c();
      continue;
      e = new ab(localck, h, i);
      HttpsURLConnection.setDefaultSSLSocketFactory(e);
      continue;
      bool3 = bool2;
      if (j != b.b) {
        break;
      }
      return bool2 | f();
    }
  }
  
  public final void b()
  {
    try
    {
      javax.net.ssl.SSLSocketFactory localSSLSocketFactory = g();
      if ((localSSLSocketFactory instanceof ab)) {
        a(((ab)localSSLSocketFactory).a());
      }
      f = null;
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      a("Unable to install OPTIMZ for SSL HttpClient connections", localIllegalArgumentException);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      a("Unable to install OPTIMZ for SSL HttpClient connections", localIllegalAccessException);
      return;
    }
    catch (cl localcl)
    {
      a("Unable to install OPTIMZ for SSL HttpClient connections", localcl);
    }
  }
  
  public final boolean c()
  {
    do
    {
      try
      {
        javax.net.ssl.SSLSocketFactory localSSLSocketFactory = g();
        if (localSSLSocketFactory == null)
        {
          a("Unable to install OPTIMZ for SSL HttpClient connections", new NullPointerException("Delegate factory was null"));
          return false;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException1)
      {
        a("Unable to install OPTIMZ for SSL HttpClient connections", localIllegalArgumentException1);
        return false;
      }
      catch (IllegalAccessException localIllegalAccessException1)
      {
        a("Unable to install OPTIMZ for SSL HttpClient connections", localIllegalAccessException1);
        return false;
      }
      catch (ClassCastException localClassCastException)
      {
        a("Unable to install OPTIMZ for SSL HttpClient connections", localClassCastException);
        return false;
      }
      catch (cl localcl1)
      {
        a("Unable to install OPTIMZ for SSL HttpClient connections", localcl1);
        return false;
      }
    } while ((localcl1 instanceof ab));
    ab localab = new ab(localcl1, h, i);
    try
    {
      a(localab);
      f = localab;
      return true;
    }
    catch (IllegalArgumentException localIllegalArgumentException2)
    {
      a("Unable to install OPTIMZ for SSL HttpClient connections", localIllegalArgumentException2);
      return false;
    }
    catch (IllegalAccessException localIllegalAccessException2)
    {
      a("Unable to install OPTIMZ for SSL HttpClient connections", localIllegalAccessException2);
      return false;
    }
    catch (cl localcl2)
    {
      a("Unable to install OPTIMZ for SSL HttpClient connections", localcl2);
    }
    return false;
  }
  
  static final class a
    implements Runnable
  {
    private boolean a;
    private boolean b = false;
    private i c;
    
    public a(i parami)
    {
      c = parami;
      a = true;
    }
    
    public final boolean a()
    {
      return b;
    }
    
    public final void run()
    {
      if (a)
      {
        b = c.c();
        return;
      }
      c.b();
    }
  }
  
  public static enum b {}
}

/* Location:
 * Qualified Name:     crittercism.android.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */