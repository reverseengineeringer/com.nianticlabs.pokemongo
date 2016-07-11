package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

class GcmTaskService$zza
  extends Thread
{
  private final Bundle mExtras;
  private final String mTag;
  private final zzb zzaCq;
  
  GcmTaskService$zza(GcmTaskService paramGcmTaskService, String paramString, IBinder paramIBinder, Bundle paramBundle)
  {
    mTag = paramString;
    zzaCq = zzb.zza.zzbR(paramIBinder);
    mExtras = paramBundle;
  }
  
  public void run()
  {
    int i = zzaCr.onRunTask(new TaskParams(mTag, mExtras));
    try
    {
      zzaCq.zzgB(i);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("GcmTaskService", "Error reporting result of operation to scheduler for " + mTag);
      return;
    }
    finally
    {
      GcmTaskService.zza(zzaCr, mTag);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.gcm.GcmTaskService.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */