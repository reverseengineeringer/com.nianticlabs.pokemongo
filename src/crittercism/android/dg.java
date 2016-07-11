package crittercism.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.ConditionVariable;
import com.crittercism.app.CrittercismNDK;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class dg
  extends di
{
  public ConditionVariable a = new ConditionVariable();
  public bm b = null;
  private ConditionVariable c = new ConditionVariable();
  private bb d;
  private Context e;
  private aw f;
  private ax g;
  private au h;
  private List i = new ArrayList();
  private boolean j = false;
  private boolean k;
  private Exception l = null;
  
  public dg(bb parambb, Context paramContext, aw paramaw, ax paramax, au paramau)
  {
    d = parambb;
    e = paramContext;
    f = paramaw;
    g = paramax;
    h = paramau;
    k = false;
  }
  
  private void a(File paramFile)
  {
    boolean bool = k;
    az localaz = az.A();
    if (t) {
      return;
    }
    if ((paramFile != null) && (paramFile.exists())) {
      paramFile.isFile();
    }
    Object localObject = f;
    localObject = f.s();
    bs localbs1 = f.t();
    bs localbs2 = f.u();
    bs localbs3 = f.v();
    bs localbs4 = f.q();
    if (paramFile != null)
    {
      dq.a = true;
      e.open();
      localbs4.a(new cd(paramFile, (bs)localObject, localbs2, localbs1, localbs3));
      paramFile.delete();
      f.w().a();
    }
    for (;;)
    {
      localbs2.a();
      localbs1.a();
      localbs3.a();
      ((bs)localObject).a(localbs2);
      return;
      e.open();
      bg.a(f);
    }
  }
  
  private void c()
  {
    try
    {
      j = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private boolean d()
  {
    try
    {
      boolean bool = j;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private File e()
  {
    int m = 0;
    Object localObject1 = new File(e.getFilesDir().getAbsolutePath() + "/" + d.g());
    if ((!((File)localObject1).exists()) || (!((File)localObject1).isDirectory())) {}
    for (;;)
    {
      return null;
      localObject1 = ((File)localObject1).listFiles();
      if (localObject1 != null) {
        if (localObject1.length == 1)
        {
          localObject1 = localObject1[0];
          ((File)localObject1).isFile();
          if (((File)localObject1).isFile()) {
            return (File)localObject1;
          }
        }
        else if (localObject1.length > 1)
        {
          int n = localObject1.length;
          while (m < n)
          {
            Object localObject2 = localObject1[m];
            ((File)localObject2).isFile();
            ((File)localObject2).delete();
            m += 1;
          }
        }
      }
    }
  }
  
  private void f()
  {
    if (At) {}
    dv localdv;
    do
    {
      return;
      boolean bool = k;
      bs localbs1 = f.n();
      bs localbs2 = f.o();
      bs localbs3 = f.p();
      bs localbs4 = f.q();
      bs localbs5 = f.r();
      localdv = f.y();
      d.b();
      b = new bm(h);
      if (!d.delaySendingAppLoad())
      {
        localbs1.a(b);
        df localdf = new df(e);
        localdf.a(localbs1, new ct.a(), d.e(), "/v0/appload", d.b(), h, new cs.b());
        localdf.a(localbs2, new da.a(), d.b(), "/android_v2/handle_exceptions", null, h, new cu.a());
        localdf.a(localbs4, new da.a(), d.b(), "/android_v2/handle_ndk_crashes", null, h, new cu.a());
        localdf.a(localbs5, new da.a(), d.b(), "/android_v2/handle_crashes", null, h, new cu.a());
        localdf.a(localbs3, new da.a(), d.b(), "/android_v2/handle_exceptions", null, new ba(h, d), new cu.a());
        localdf.a();
      }
    } while (!localdv.b());
    az.A().E();
  }
  
  public final void a()
  {
    Object localObject5;
    boolean bool;
    try
    {
      dx.b();
      Object localObject1 = new File(e.getFilesDir().getAbsolutePath() + "/com.crittercism/pending");
      if ((((File)localObject1).exists()) && (!((File)localObject1).isDirectory()))
      {
        dx.b();
        localObject5 = az.A();
        w.a();
        localObject1 = h.l();
        d.open();
        localObject5 = g;
        localObject6 = e;
        ((dw)localObject1).a((ax)localObject5);
        dq.a = dq.a(e).booleanValue();
        dq.a(e, false);
        if (!((dw)localObject1).b())
        {
          localObject5 = new dt(e);
          int m = ((dt)localObject5).a();
          a.edit().putInt("numAppLoads", m + 1).commit();
          AA = ((dt)localObject5);
          ((dw)localObject1).a().a(g, cq.j.a(), cq.j.b());
        }
        k = ((dw)localObject1).b();
        localObject5 = e();
        if (!k) {
          break label531;
        }
        bool = k;
        if (!At)
        {
          if ((localObject5 != null) && (((File)localObject5).exists())) {
            ((File)localObject5).isFile();
          }
          new bs(e, br.a).a();
          new bs(e, br.b).a();
          new bs(e, br.c).a();
          new bs(e, br.d).a();
          new bs(e, br.e).a();
          new bs(e, br.f).a();
          new bs(e, br.h).a();
          new bs(e, br.g).a();
          new bs(e, br.k).a();
          if (localObject5 != null) {
            ((File)localObject5).delete();
          }
        }
        h.b(e);
        c();
        localObject1 = i.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((Runnable)((Iterator)localObject1).next()).run();
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        new StringBuilder("Exception in run(): ").append(localException.getMessage());
        dx.b();
        dx.c();
        l = localException;
        return;
        eb.a(localException);
      }
    }
    finally
    {
      c.open();
    }
    label531:
    Object localObject6 = e;
    Object localObject3 = new h((Context)localObject6);
    localObject6 = ((Context)localObject6).getSharedPreferences("com.crittercism.optmz.config", 0);
    if (((SharedPreferences)localObject6).contains("interval"))
    {
      d = ((SharedPreferences)localObject6).getInt("interval", 10);
      if (!((SharedPreferences)localObject6).contains("kill")) {
        break label972;
      }
      c = ((SharedPreferences)localObject6).getBoolean("kill", false);
      if (!((SharedPreferences)localObject6).contains("persist")) {
        break label977;
      }
      b = ((SharedPreferences)localObject6).getBoolean("persist", false);
      if (!((SharedPreferences)localObject6).contains("enabled")) {
        break label982;
      }
      a = ((SharedPreferences)localObject6).getBoolean("enabled", false);
    }
    for (;;)
    {
      if (localObject3 != null) {
        az.A().a((h)localObject3);
      }
      bool = k;
      f.z();
      Object localObject7;
      bs localbs1;
      bs localbs2;
      if (!At)
      {
        localObject3 = bh.a(e);
        localObject6 = f.x();
        localObject7 = f.s();
        localbs1 = f.t();
        localbs2 = f.v();
      }
      try
      {
        URL localURL = new URL(d.d() + "/api/v1/transactions");
        localObject6 = new bi(e, h, (bs)localObject6, (bs)localObject7, localbs1, localbs2, localURL);
        localObject7 = az.A();
        y = ((bi)localObject6);
        new dy((Runnable)localObject6, "TXN Thread").start();
        ((az)localObject7).a((bh)localObject3);
        a((File)localObject5);
        a.open();
        f.s().a(cf.a);
        if ((!At) && (d.isNdkCrashReportingEnabled())) {
          dx.b();
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        try
        {
          CrittercismNDK.installNdkLib(e, d.g());
          f();
          break;
          localMalformedURLException = localMalformedURLException;
          dx.a();
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            new StringBuilder("Exception installing ndk library: ").append(localThrowable.getClass().getName());
            dx.b();
          }
        }
      }
      c.open();
      return;
      Object localObject4 = null;
      continue;
      label972:
      localObject4 = null;
      continue;
      label977:
      localObject4 = null;
      continue;
      label982:
      localObject4 = null;
    }
  }
  
  /* Error */
  public final boolean a(Runnable paramRunnable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 501	crittercism/android/dg:d	()Z
    //   6: ifne +20 -> 26
    //   9: aload_0
    //   10: getfield 43	crittercism/android/dg:i	Ljava/util/List;
    //   13: aload_1
    //   14: invokeinterface 505 2 0
    //   19: pop
    //   20: iconst_1
    //   21: istore_2
    //   22: aload_0
    //   23: monitorexit
    //   24: iload_2
    //   25: ireturn
    //   26: iconst_0
    //   27: istore_2
    //   28: goto -6 -> 22
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	dg
    //   0	36	1	paramRunnable	Runnable
    //   21	7	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	20	31	finally
  }
  
  public final void b()
  {
    c.block();
  }
}

/* Location:
 * Qualified Name:     crittercism.android.dg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */