package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;

public final class zzmr
{
  private static IntentFilter zzail = new IntentFilter("android.intent.action.BATTERY_CHANGED");
  
  public static int zzao(Context paramContext)
  {
    int k = 1;
    if ((paramContext == null) || (paramContext.getApplicationContext() == null)) {
      return -1;
    }
    Intent localIntent = paramContext.getApplicationContext().registerReceiver(null, zzail);
    label44:
    boolean bool;
    label64:
    int j;
    if (localIntent == null)
    {
      i = 0;
      if ((i & 0x7) == 0) {
        break label95;
      }
      i = 1;
      if (!zzmx.zzqC()) {
        break label100;
      }
      bool = ((PowerManager)paramContext.getSystemService("power")).isInteractive();
      if (!bool) {
        break label117;
      }
      j = 1;
      label71:
      if (i == 0) {
        break label122;
      }
    }
    label95:
    label100:
    label117:
    label122:
    for (int i = k;; i = 0)
    {
      return j << 1 | i;
      i = localIntent.getIntExtra("plugged", 0);
      break;
      i = 0;
      break label44;
      bool = ((PowerManager)paramContext.getSystemService("power")).isScreenOn();
      break label64;
      j = 0;
      break label71;
    }
  }
  
  public static float zzap(Context paramContext)
  {
    paramContext = paramContext.getApplicationContext().registerReceiver(null, zzail);
    float f = NaN.0F;
    if (paramContext != null)
    {
      int i = paramContext.getIntExtra("level", -1);
      int j = paramContext.getIntExtra("scale", -1);
      f = i / j;
    }
    return f;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzmr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */