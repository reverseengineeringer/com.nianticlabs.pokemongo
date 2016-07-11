package crittercism.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public final class bd
  extends BroadcastReceiver
{
  private az a;
  private String b;
  private b c;
  
  public bd(Context paramContext, az paramaz)
  {
    a = paramaz;
    paramContext = new d(paramContext);
    b = paramContext.b();
    c = paramContext.a();
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    new StringBuilder("CrittercismReceiver: INTENT ACTION = ").append(paramIntent.getAction());
    dx.b();
    paramContext = new d(paramContext);
    paramIntent = paramContext.a();
    if ((c != paramIntent) && (paramIntent != b.c))
    {
      if (paramIntent == b.d)
      {
        a.a(new ce(ce.a.b));
        c = paramIntent;
      }
    }
    else
    {
      paramContext = paramContext.b();
      if (!paramContext.equals(b))
      {
        if ((!b.equals("unknown")) && (!b.equals("disconnected"))) {
          break label200;
        }
        if ((!paramContext.equals("unknown")) && (!paramContext.equals("disconnected"))) {
          a.a(new ce(ce.a.c, paramContext));
        }
      }
    }
    for (;;)
    {
      b = paramContext;
      return;
      if ((c != b.d) && (c != b.c)) {
        break;
      }
      a.a(new ce(ce.a.a));
      break;
      label200:
      if (paramContext.equals("disconnected")) {
        a.a(new ce(ce.a.d, b));
      } else if (!paramContext.equals("unknown")) {
        a.a(new ce(ce.a.e, b, paramContext));
      }
    }
  }
}

/* Location:
 * Qualified Name:     crittercism.android.bd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */