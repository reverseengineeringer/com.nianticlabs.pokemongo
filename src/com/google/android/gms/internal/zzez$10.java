package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.AdRequest.ErrorCode;
import com.google.android.gms.ads.internal.util.client.zzb;

class zzez$10
  implements Runnable
{
  zzez$10(zzez paramzzez, AdRequest.ErrorCode paramErrorCode) {}
  
  public void run()
  {
    try
    {
      zzez.zza(zzzR).onAdFailedToLoad(zzfa.zza(zzzS));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call onAdFailedToLoad.", localRemoteException);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzez.10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */