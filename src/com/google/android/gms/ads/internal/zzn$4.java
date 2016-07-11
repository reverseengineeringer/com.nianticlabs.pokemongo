package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.formats.zzf;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzcz;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzmi;

class zzn$4
  implements Runnable
{
  zzn$4(zzn paramzzn, String paramString, zzhs paramzzhs) {}
  
  public void run()
  {
    try
    {
      ((zzcz)zzpB.zzot.zzqA.get(zzpE)).zza((zzf)zzpF.zzHB);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not call onCustomTemplateAdLoadedListener.onCustomTemplateAdLoaded().", localRemoteException);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzn.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */