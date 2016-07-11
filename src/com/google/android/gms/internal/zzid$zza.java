package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class zzid$zza
  extends BroadcastReceiver
{
  private zzid$zza(zzid paramzzid) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.intent.action.USER_PRESENT".equals(paramIntent.getAction())) {
      zzid.zza(zzIH, true);
    }
    while (!"android.intent.action.SCREEN_OFF".equals(paramIntent.getAction())) {
      return;
    }
    zzid.zza(zzIH, false);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzid.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */