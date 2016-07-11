package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.zzb;

class zzhi$1
  implements Runnable
{
  zzhi$1(zzhi paramzzhi, zzen paramzzen, AdRequestParcel paramAdRequestParcel) {}
  
  public void run()
  {
    try
    {
      zzHk.zza(zzpe, zzhi.zza(zzHl));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Fail to load ad from adapter.", localRemoteException);
      zzHl.zzb(zzhi.zzb(zzHl), 0);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzhi.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */