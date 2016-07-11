package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;

class zzez$11
  implements Runnable
{
  zzez$11(zzez paramzzez) {}
  
  public void run()
  {
    try
    {
      zzez.zza(zzzR).onAdLeftApplication();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call onAdLeftApplication.", localRemoteException);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzez.11
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */