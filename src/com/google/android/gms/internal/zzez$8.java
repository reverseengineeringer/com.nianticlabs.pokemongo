package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;

class zzez$8
  implements Runnable
{
  zzez$8(zzez paramzzez) {}
  
  public void run()
  {
    try
    {
      zzez.zza(zzzR).onAdLoaded();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call onAdLoaded.", localRemoteException);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzez.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */