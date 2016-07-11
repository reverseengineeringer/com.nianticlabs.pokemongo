package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.zza;
import java.util.concurrent.atomic.AtomicInteger;

final class zzj$zzb
  extends Handler
{
  public zzj$zzb(zzj paramzzj, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void zza(Message paramMessage)
  {
    paramMessage = (zzj.zzc)obj;
    paramMessage.zzpg();
    paramMessage.unregister();
  }
  
  private boolean zzb(Message paramMessage)
  {
    return (what == 2) || (what == 1) || (what == 5) || (what == 6);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (zzafK.zzafH.get() != arg1)
    {
      if (zzb(paramMessage)) {
        zza(paramMessage);
      }
      return;
    }
    if (((what == 1) || (what == 5) || (what == 6)) && (!zzafK.isConnecting()))
    {
      zza(paramMessage);
      return;
    }
    if (what == 3)
    {
      paramMessage = new ConnectionResult(arg2, null);
      zzj.zza(zzafK).zza(paramMessage);
      zzafK.onConnectionFailed(paramMessage);
      return;
    }
    if (what == 4)
    {
      zzj.zza(zzafK, 4, null);
      if (zzj.zzb(zzafK) != null) {
        zzj.zzb(zzafK).onConnectionSuspended(arg2);
      }
      zzafK.onConnectionSuspended(arg2);
      zzj.zza(zzafK, 4, 1, null);
      return;
    }
    if ((what == 2) && (!zzafK.isConnected()))
    {
      zza(paramMessage);
      return;
    }
    if (zzb(paramMessage))
    {
      ((zzj.zzc)obj).zzph();
      return;
    }
    Log.wtf("GmsClient", "Don't know how to handle message: " + what, new Exception());
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzj.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */