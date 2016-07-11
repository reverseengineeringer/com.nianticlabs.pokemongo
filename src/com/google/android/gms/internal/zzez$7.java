package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;

class zzez$7
  implements Runnable
{
  zzez$7(zzez paramzzez) {}
  
  public void run()
  {
    try
    {
      zzez.zza(zzzR).onAdOpened();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call onAdOpened.", localRemoteException);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzez.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */