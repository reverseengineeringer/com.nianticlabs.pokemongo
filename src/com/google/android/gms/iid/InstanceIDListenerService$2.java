package com.google.android.gms.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

class InstanceIDListenerService$2
  extends BroadcastReceiver
{
  InstanceIDListenerService$2(InstanceIDListenerService paramInstanceIDListenerService) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (Log.isLoggable("InstanceID", 3))
    {
      paramIntent.getStringExtra("registration_id");
      Log.d("InstanceID", "Received GSF callback using dynamic receiver: " + paramIntent.getExtras());
    }
    zzaDJ.zzn(paramIntent);
    zzaDJ.stop();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.iid.InstanceIDListenerService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */