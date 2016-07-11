package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;

class zzek$1
  implements Runnable
{
  zzek$1(zzek paramzzek, zzei paramzzei) {}
  
  public void run()
  {
    try
    {
      zzzF.zzzv.destroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not destroy mediation adapter.", localRemoteException);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzek.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */