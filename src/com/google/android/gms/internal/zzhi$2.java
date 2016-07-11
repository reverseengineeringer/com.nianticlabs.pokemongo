package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;

class zzhi$2
  implements Runnable
{
  zzhi$2(zzhi paramzzhi, zzen paramzzen, AdRequestParcel paramAdRequestParcel, zzhl paramzzhl) {}
  
  public void run()
  {
    try
    {
      zzHk.zza(zze.zzy(zzhi.zzc(zzHl)), zzpe, zzhi.zzd(zzHl), zzHm, zzhi.zza(zzHl));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Fail to initialize adapter " + zzhi.zzb(zzHl), localRemoteException);
      zzHl.zzb(zzhi.zzb(zzHl), 0);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzhi.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */