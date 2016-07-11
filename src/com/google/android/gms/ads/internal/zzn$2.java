package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.formats.zzd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzcw;

class zzn$2
  implements Runnable
{
  zzn$2(zzn paramzzn, zzd paramzzd) {}
  
  public void run()
  {
    try
    {
      zzpB.zzot.zzqx.zza(zzpC);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", localRemoteException);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzn.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */