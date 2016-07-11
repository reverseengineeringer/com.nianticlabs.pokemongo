package crittercism.android;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;

public final class av
  implements Application.ActivityLifecycleCallbacks
{
  private int a = 0;
  private boolean b = false;
  private boolean c = false;
  private boolean d = false;
  private Context e;
  private az f;
  private bd g;
  
  public av(Context paramContext, az paramaz)
  {
    e = paramContext;
    f = paramaz;
    g = new bd(paramContext, paramaz);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity)
  {
    if (paramActivity != null) {}
    try
    {
      if (c)
      {
        paramActivity.unregisterReceiver(g);
        c = false;
      }
      return;
    }
    catch (ThreadDeath paramActivity)
    {
      throw paramActivity;
    }
    catch (Throwable paramActivity)
    {
      dx.a(paramActivity);
    }
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    if (paramActivity != null) {
      for (;;)
      {
        try
        {
          Object localObject;
          if (b)
          {
            dx.b();
            b = false;
            a += 1;
            localObject = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
            ((IntentFilter)localObject).addAction("android.net.wifi.WIFI_STATE_CHANGED");
            paramActivity.registerReceiver(g, (IntentFilter)localObject);
            c = true;
            return;
          }
          if (a == 0)
          {
            f.a(new bl(bl.a.a));
            bg.f();
            if (d) {
              continue;
            }
            d = true;
            localObject = new d(e).a();
            if (localObject == b.c) {
              continue;
            }
            if (localObject == b.d)
            {
              f.a(new ce(ce.a.b));
              continue;
            }
          }
        }
        catch (ThreadDeath paramActivity)
        {
          throw paramActivity;
          f.a(new ce(ce.a.a));
          continue;
        }
        catch (Throwable paramActivity)
        {
          dx.a(paramActivity);
          return;
        }
        f.a(new bj(bj.a.a, paramActivity.getClass().getName()));
      }
    }
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity)
  {
    if (paramActivity != null) {
      try
      {
        a -= 1;
        if (paramActivity.isChangingConfigurations())
        {
          dx.b();
          b = true;
          return;
        }
        if (a == 0)
        {
          f.a(new bl(bl.a.b));
          bg.a(f);
          return;
        }
      }
      catch (ThreadDeath paramActivity)
      {
        throw paramActivity;
        f.a(new bj(bj.a.b, paramActivity.getClass().getName()));
        return;
      }
      catch (Throwable paramActivity)
      {
        dx.a(paramActivity);
      }
    }
  }
}

/* Location:
 * Qualified Name:     crittercism.android.av
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */