package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.formats.zze;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzcx;

class zzn$3
  implements Runnable
{
  zzn$3(zzn paramzzn, zze paramzze) {}
  
  public void run()
  {
    try
    {
      zzpB.zzot.zzqy.zza(zzpD);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call OnContentAdLoadedListener.onContentAdLoaded().", localRemoteException);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzn.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */