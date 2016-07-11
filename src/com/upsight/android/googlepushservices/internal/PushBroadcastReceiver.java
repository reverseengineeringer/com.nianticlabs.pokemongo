package com.upsight.android.googlepushservices.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

public final class PushBroadcastReceiver
  extends WakefulBroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    startWakefulService(paramContext, paramIntent.setComponent(new ComponentName(paramContext.getPackageName(), PushIntentService.class.getName())));
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.googlepushservices.internal.PushBroadcastReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */