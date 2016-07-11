package crittercism.android;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.ConditionVariable;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.Process;
import com.crittercism.app.CrittercismConfig;
import com.crittercism.app.Transaction;
import com.crittercism.integrations.PluginException;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public final class az
  implements au, aw, ax, f
{
  static az a;
  public dt A = null;
  int B = 0;
  public boolean C = false;
  private String D = null;
  private bs E;
  private bs F;
  private g G = null;
  private at H;
  private boolean I = false;
  private String J = "";
  public boolean b = false;
  public Context c = null;
  public final ConditionVariable d = new ConditionVariable(false);
  public final ConditionVariable e = new ConditionVariable(false);
  public dw f = new dw();
  bs g;
  bs h;
  bs i;
  bs j;
  bs k;
  bs l;
  bs m;
  bs n;
  bs o;
  cv p = null;
  public dg q = null;
  ExecutorService r = Executors.newCachedThreadPool(new dz());
  public ExecutorService s = Executors.newSingleThreadExecutor(new dz());
  public boolean t = false;
  public bb u;
  protected e v = new e(s);
  public dr w;
  dv x = null;
  public bi y;
  public Map z = new HashMap();
  
  public static az A()
  {
    if (a == null) {
      a = new az();
    }
    return a;
  }
  
  private static boolean F()
  {
    boolean bool2 = false;
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < arrayOfStackTraceElement.length)
      {
        StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i1];
        if ((localStackTraceElement.getMethodName().equals("onCreate")) || (localStackTraceElement.getMethodName().equals("onResume"))) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  private void G()
  {
    int i2 = Process.myUid();
    int i3 = Process.myPid();
    Object localObject = (ActivityManager)c.getSystemService("activity");
    Iterator localIterator = ((ActivityManager)localObject).getRunningAppProcesses().iterator();
    int i1 = 0;
    if (localIterator.hasNext())
    {
      if (nextuid != i2) {
        break label128;
      }
      i1 += 1;
    }
    label128:
    for (;;)
    {
      break;
      if (i1 <= 1) {
        t = false;
      }
      do
      {
        return;
        while (!((Iterator)localObject).hasNext()) {
          localObject = ((ActivityManager)localObject).getRunningServices(Integer.MAX_VALUE).iterator();
        }
      } while (nextpid != i3);
      t = true;
      return;
    }
  }
  
  private String H()
  {
    try
    {
      if ((J == null) || (J.equals(""))) {
        J = c.getPackageName();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        dx.c("Call to getPackageName() failed.  Please contact us at support@crittercism.com.");
        J = new String();
      }
    }
    return J;
  }
  
  public final boolean B()
  {
    d.block();
    return f.b();
  }
  
  public final void C()
  {
    dt localdt = A;
    if (A != null) {
      A.d();
    }
  }
  
  public final String D()
  {
    PackageManager localPackageManager = c.getPackageManager();
    String str = H();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (str != null)
    {
      localObject1 = localObject2;
      if (str.length() > 0)
      {
        localObject1 = dp.a(localPackageManager.getInstallerPackageName(str));
        if (localObject1 == null) {
          break label58;
        }
        localObject1 = ((dn)localObject1).a(str).a();
      }
    }
    return (String)localObject1;
    label58:
    dx.c("Could not find app market for this app.  Will try rate-my-app test target in config.");
    return u.getRateMyAppTestTarget();
  }
  
  public final void E()
  {
    if (t) {}
    di local3;
    do
    {
      return;
      local3 = new di()
      {
        public final void a()
        {
          if (jdField_thisf.b()) {
            return;
          }
          cu localcu = new cu(jdField_this);
          JSONObject localJSONObject = jdField_thisx.a();
          a.put("metadata", localJSONObject);
          new dj(localcu, new dc(new db(u.b(), "/android_v2/update_user_metadata").a()), new dd(jdField_thisx)).run();
        }
      };
    } while (q.a(local3));
    r.execute(local3);
  }
  
  public final AlertDialog a(Context paramContext, String paramString1, String paramString2)
  {
    int i1 = 0;
    if (f.b()) {
      dx.b("User has opted out of crittercism.  generateRateMyAppAlertDialog returning null.");
    }
    while (i1 == 0)
    {
      return null;
      if (!(paramContext instanceof Activity)) {
        dx.b("Context object must be an instance of Activity for AlertDialog to form correctly.  generateRateMyAppAlertDialog returning null.");
      } else if ((paramString2 == null) || ((paramString2 != null) && (paramString2.length() == 0))) {
        dx.b("Message has to be a non-empty string.  generateRateMyAppAlertDialog returning null.");
      } else if (Build.VERSION.SDK_INT < 5) {
        dx.b("Rate my app not supported below api level 5");
      } else {
        i1 = 1;
      }
    }
    final String str = D();
    if (str == null)
    {
      dx.b("Cannot create proper URI to open app market.  Returning null.");
      return null;
    }
    paramContext = new AlertDialog.Builder(paramContext);
    paramContext.setTitle(paramString1).setMessage(paramString2);
    try
    {
      paramContext = paramContext.create();
      paramContext.setButton(-1, "Yes", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          try
          {
            az.A().a(str);
            return;
          }
          catch (Exception paramAnonymousDialogInterface)
          {
            dx.c("YES button failed.  Email support@crittercism.com.");
          }
        }
      });
      paramContext.setButton(-2, "No", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          try
          {
            az.A().C();
            return;
          }
          catch (Exception paramAnonymousDialogInterface)
          {
            dx.c("NO button failed.  Email support@crittercism.com.");
          }
        }
      });
      paramContext.setButton(-3, "Maybe Later", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          try
          {
            az.A();
            return;
          }
          catch (Exception paramAnonymousDialogInterface)
          {
            dx.c("MAYBE LATER button failed.  Email support@crittercism.com.");
          }
        }
      });
      return paramContext;
    }
    catch (Exception paramContext)
    {
      dx.b("Failed to create AlertDialog instance from AlertDialog.Builder.  Did you remember to call Looper.prepare() before calling Crittercism.generateRateMyAppAlertDialog()?");
    }
    return null;
  }
  
  public final String a()
  {
    String str2 = D;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public final String a(String paramString1, String paramString2)
  {
    Object localObject = null;
    SharedPreferences localSharedPreferences = c.getSharedPreferences(paramString1, 0);
    paramString1 = (String)localObject;
    if (localSharedPreferences != null) {
      paramString1 = localSharedPreferences.getString(paramString2, null);
    }
    return paramString1;
  }
  
  public final void a(Context paramContext, String paramString, CrittercismConfig paramCrittercismConfig)
  {
    dx.a("Initializing Crittercism 5.0.8 for App ID " + paramString);
    bn localbn = new bn(paramString);
    D = paramString;
    u = new bb(localbn, paramCrittercismConfig);
    c = paramContext;
    H = new at(c, u);
    J = paramContext.getPackageName();
    w = new dr(paramContext);
    G();
    long l1 = 60000000000L;
    if (t) {
      l1 = 12000000000L;
    }
    p = new cv(l1);
    if (!F()) {
      dx.c("Crittercism should be initialized in onCreate() of MainActivity");
    }
    bx.a(H);
    bx.a(c);
    bx.a(new cc());
    bx.a(new bf(c, u));
    for (;;)
    {
      try
      {
        v.a(u.a());
        v.b(u.getPreserveQueryStringPatterns());
        G = new g(this, new URL(u.c() + "/api/apm/network"));
        v.a(G);
        v.a(this);
        new dy(G, "OPTMZ").start();
        if (!h.a(c).exists())
        {
          boolean bool = u.isServiceMonitoringEnabled();
          if (bool) {
            continue;
          }
        }
      }
      catch (Exception paramString)
      {
        new StringBuilder("Exception in startApm: ").append(paramString.getClass().getName());
        dx.b();
        dx.c();
        continue;
        dx.b();
        ((Application)c).registerActivityLifecycleCallbacks(new av(c, this));
        continue;
        dx.a("API Level is less than 14. Automatic breadcrumbs are not supported.");
        continue;
      }
      q = new dg(u, paramContext, this, this, this);
      if (!t) {
        dx.a(new ec(this, s, q, f));
      }
      paramContext = Thread.getDefaultUncaughtExceptionHandler();
      if (!(paramContext instanceof ay)) {
        Thread.setDefaultUncaughtExceptionHandler(new ay(this, paramContext));
      }
      if (Build.VERSION.SDK_INT < 14) {
        continue;
      }
      if ((c instanceof Application)) {
        continue;
      }
      dx.c("Application context not provided. Automatic breadcrumbs will not be recorded.");
      if (!t)
      {
        bg.b(this);
        if (Looper.myLooper() == Looper.getMainLooper()) {
          Looper.myQueue().addIdleHandler(new a((byte)0));
        }
      }
      new dy(q).start();
      b = true;
      return;
      paramString = new d(c);
      I = new i(v, paramString).a();
      new StringBuilder("installedApm = ").append(I);
      dx.b();
    }
  }
  
  public final void a(bh parambh)
  {
    bi localbi = y;
    if (y == null) {}
    do
    {
      return;
      bg.a(parambh);
      bg.i();
    } while (!a);
    y.a(b, TimeUnit.SECONDS);
    y.b();
  }
  
  public final void a(final c paramc)
  {
    paramc = new di()
    {
      public final void a()
      {
        l.a(paramc);
      }
    };
    if (!q.a(paramc)) {
      s.execute(paramc);
    }
  }
  
  public final void a(final ci paramci)
  {
    if (f.b()) {}
    do
    {
      return;
      paramci = new di()
      {
        public final void a()
        {
          m.a(paramci);
        }
      };
    } while (q.a(paramci));
    s.execute(paramci);
  }
  
  public final void a(h paramh)
  {
    if (G == null) {}
    while ((!a) || (c)) {
      return;
    }
    dx.a("Enabling OPTMZ");
    G.a(d, TimeUnit.SECONDS);
    G.a();
  }
  
  public final void a(String paramString)
  {
    Object localObject = A;
    if (A != null) {
      A.d();
    }
    localObject = new Intent("android.intent.action.VIEW");
    ((Intent)localObject).setFlags(268435456);
    ((Intent)localObject).setData(Uri.parse(paramString));
    c.startActivity((Intent)localObject);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = c.getSharedPreferences(paramString1, 0);
    if (paramString1 != null)
    {
      paramString1 = paramString1.edit();
      if (paramString1 != null)
      {
        paramString1.remove(paramString2);
        paramString1.putInt(paramString2, paramInt);
        paramString1.commit();
      }
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = c.getSharedPreferences(paramString1, 0);
    if (paramString1 != null)
    {
      paramString1 = paramString1.edit();
      if (paramString1 != null)
      {
        paramString1.remove(paramString2);
        paramString1.putString(paramString2, paramString3);
        paramString1.commit();
      }
    }
  }
  
  public final void a(String paramString, URL paramURL, long paramLong1, long paramLong2, long paramLong3, int paramInt, Exception paramException, long paramLong4)
  {
    if (paramString == null)
    {
      dx.b("Null HTTP request method provided. Endpoint will not be logged.");
      return;
    }
    String str = paramString.toUpperCase(Locale.US);
    Object localObject = new HashSet();
    ((Set)localObject).add("GET");
    ((Set)localObject).add("POST");
    ((Set)localObject).add("HEAD");
    ((Set)localObject).add("PUT");
    ((Set)localObject).add("DELETE");
    ((Set)localObject).add("TRACE");
    ((Set)localObject).add("OPTIONS");
    ((Set)localObject).add("CONNECT");
    ((Set)localObject).add("PATCH");
    if (!((Set)localObject).contains(str)) {
      dx.c("Logging endpoint with invalid HTTP request method: " + paramString);
    }
    if (paramURL == null)
    {
      dx.b("Null URL provided. Endpoint will not be logged");
      return;
    }
    if ((paramLong2 < 0L) || (paramLong3 < 0L))
    {
      dx.b("Invalid byte values. Bytes need to be non-negative. Endpoint will not be logged.");
      return;
    }
    if (paramInt != 0) {
      if ((paramInt < 100) || (paramInt >= 600)) {
        dx.c("Logging endpoint with invalid HTTP response code: " + Integer.toString(paramInt));
      }
    }
    for (;;)
    {
      paramString = new d(c).a();
      if (paramLong1 >= 0L) {
        break;
      }
      dx.b("Invalid latency. Endpoint will not be logged.");
      return;
      if (paramException == null) {
        dx.c("Logging endpoint with null error and response code of 0.");
      }
    }
    if (paramLong4 < 0L)
    {
      dx.b("Invalid start time. Endpoint will not be logged.");
      return;
    }
    localObject = new c();
    f = str;
    ((c)localObject).a(paramURL.toExternalForm());
    ((c)localObject).b(paramLong2);
    ((c)localObject).d(paramLong3);
    e = paramInt;
    j = paramString;
    ((c)localObject).e(paramLong4);
    ((c)localObject).f(paramLong4 + paramLong1);
    if (bc.b()) {
      ((c)localObject).a(bc.a());
    }
    ((c)localObject).a(paramException);
    v.a((c)localObject, c.a.l);
  }
  
  public final void a(Throwable paramThrowable)
  {
    if (q == null) {
      dx.b("Unable to handle application crash. Crittercism not yet initialized");
    }
    do
    {
      return;
      q.b();
      dq.a(c, true);
    } while (f.b());
    if (t)
    {
      paramThrowable = new bk(paramThrowable, Thread.currentThread().getId());
      paramThrowable = new JSONArray().put(paramThrowable.b());
      new dj(new cu(this).a(br.e.f(), paramThrowable), new dc(new db(u.b(), "/android_v2/handle_crashes").a()), null).run();
      return;
    }
    List localList = bg.a(this, paramThrowable instanceof PluginException);
    paramThrowable = new bk(paramThrowable, Thread.currentThread().getId());
    paramThrowable.a("crashed_session", k);
    if (F.b() > 0) {
      paramThrowable.a("previous_session", F);
    }
    paramThrowable.a(l);
    b = bom).a;
    paramThrowable.a();
    paramThrowable.a(localList);
    j.a(paramThrowable);
    paramThrowable = new df(c);
    paramThrowable.a(g, new da.a(), u.e(), "/v0/appload", null, this, new cs.b());
    paramThrowable.a(h, new da.a(), u.b(), "/android_v2/handle_exceptions", null, this, new cu.a());
    paramThrowable.a(i, new da.a(), u.b(), "/android_v2/handle_ndk_crashes", null, this, new cu.a());
    paramThrowable.a(j, new da.a(), u.b(), "/android_v2/handle_crashes", null, this, new cu.a());
    try
    {
      paramThrowable.a();
      return;
    }
    catch (InterruptedException paramThrowable)
    {
      new StringBuilder("InterruptedException in logCrashException: ").append(paramThrowable.getMessage());
      dx.b();
      dx.c();
      return;
    }
    catch (Throwable paramThrowable)
    {
      new StringBuilder("Unexpected throwable in logCrashException: ").append(paramThrowable.getMessage());
      dx.b();
      dx.c();
    }
  }
  
  public final void a(final JSONObject paramJSONObject)
  {
    if (t) {}
    do
    {
      return;
      paramJSONObject = new di()
      {
        public final void a()
        {
          if (jdField_thisf.b()) {}
          do
          {
            return;
            jdField_thisx.a(paramJSONObject);
          } while (!jdField_thisx.b());
          jdField_this.E();
        }
      };
    } while (q.a(paramJSONObject));
    s.execute(paramJSONObject);
  }
  
  public final int b(String paramString)
  {
    if (t)
    {
      dx.c("Transactions are not supported for services. Returning default value of -1 for " + paramString + ".");
      return -1;
    }
    for (;;)
    {
      synchronized (z)
      {
        paramString = (Transaction)z.get(paramString);
        if (paramString != null)
        {
          i1 = paramString.d();
          return i1;
        }
      }
      int i1 = -1;
    }
  }
  
  public final int b(String paramString1, String paramString2)
  {
    int i1 = 0;
    paramString1 = c.getSharedPreferences(paramString1, 0);
    if (paramString1 != null) {
      i1 = paramString1.getInt(paramString2, 0);
    }
    return i1;
  }
  
  public final String b()
  {
    return H.a;
  }
  
  public final void b(final Throwable paramThrowable)
  {
    if (paramThrowable == null) {}
    for (;;)
    {
      try
      {
        dx.c("Calling logHandledException with a null java.lang.Throwable. Nothing will be reported to Crittercism");
        return;
      }
      finally {}
      if (t)
      {
        paramThrowable = new di()
        {
          public final void a()
          {
            if (f.b()) {
              return;
            }
            synchronized (p)
            {
              if (B < 10)
              {
                Object localObject1 = new bk(paramThrowable, b);
                ((bk)localObject1).a("current_session", k);
                ((bk)localObject1).a(l);
                f = "he";
                if (p.a())
                {
                  localObject1 = new JSONArray().put(((bk)localObject1).b());
                  new dj(new cu(az.a).a(br.b.f(), (JSONArray)localObject1), new dc(new db(u.b(), "/android_v2/handle_exceptions").a()), null).run();
                  localObject1 = az.this;
                  B += 1;
                  p.b();
                }
              }
              return;
            }
          }
        };
        if (!q.a(paramThrowable)) {
          s.execute(paramThrowable);
        }
      }
      else
      {
        paramThrowable = new di()
        {
          public final void a()
          {
            if (f.b()) {}
            do
            {
              do
              {
                return;
                localObject = new bk(paramThrowable, b);
                ((bk)localObject).a("current_session", k);
                f = "he";
              } while (!h.a((ch)localObject));
              az.a.a(new by(c, d));
            } while (!p.a());
            Object localObject = new df(c);
            ((df)localObject).a(h, new da.a(), u.b(), "/android_v2/handle_exceptions", null, az.a, new cu.a());
            ((df)localObject).a(q, r);
            p.b();
          }
        };
        if (!q.a(paramThrowable)) {
          s.execute(paramThrowable);
        }
      }
    }
  }
  
  public final String c()
  {
    String str = "";
    if (w != null) {
      str = w.a();
    }
    return str;
  }
  
  public final boolean c(String paramString1, String paramString2)
  {
    boolean bool = false;
    paramString1 = c.getSharedPreferences(paramString1, 0);
    if (paramString1 != null) {
      bool = paramString1.getBoolean(paramString2, false);
    }
    return bool;
  }
  
  public final String d()
  {
    return "5.0.8";
  }
  
  public final int e()
  {
    int i1 = -1;
    if (f != null) {
      i1 = Integer.valueOf(f.a().a).intValue();
    }
    return i1;
  }
  
  public final String f()
  {
    return bx.fa;
  }
  
  public final int g()
  {
    return bx.oa.intValue();
  }
  
  public final int h()
  {
    return bx.pa.intValue();
  }
  
  public final String i()
  {
    return "Android";
  }
  
  public final String j()
  {
    return Build.MODEL;
  }
  
  public final String k()
  {
    return Build.VERSION.RELEASE;
  }
  
  public final dw l()
  {
    return f;
  }
  
  public final dt m()
  {
    return A;
  }
  
  public final bs n()
  {
    return g;
  }
  
  public final bs o()
  {
    return h;
  }
  
  public final bs p()
  {
    return E;
  }
  
  public final bs q()
  {
    return i;
  }
  
  public final bs r()
  {
    return j;
  }
  
  public final bs s()
  {
    return k;
  }
  
  public final bs t()
  {
    return l;
  }
  
  public final bs u()
  {
    return F;
  }
  
  public final bs v()
  {
    return m;
  }
  
  public final bs w()
  {
    return n;
  }
  
  public final bs x()
  {
    return o;
  }
  
  public final dv y()
  {
    return x;
  }
  
  public final void z()
  {
    if (t) {}
    for (k = new bs(c, br.f).a(c);; k = new bs(c, br.f))
    {
      F = new bs(c, br.h);
      l = new bs(c, br.g);
      m = new bs(c, br.k);
      g = new bs(c, br.a);
      h = new bs(c, br.b);
      E = new bs(c, br.c);
      i = new bs(c, br.d);
      j = new bs(c, br.e);
      n = new bs(c, br.i);
      o = new bs(c, br.j);
      if (!t) {
        x = new dv(c, D);
      }
      return;
    }
  }
  
  static final class a
    implements MessageQueue.IdleHandler
  {
    private boolean a = false;
    
    public final boolean queueIdle()
    {
      try
      {
        if (!a)
        {
          a = true;
          bg.g();
        }
        return true;
      }
      finally {}
    }
  }
}

/* Location:
 * Qualified Name:     crittercism.android.az
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */