package com.google.android.gms.location.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlb.zzb;
import com.google.android.gms.location.LocationSettingsResult;

final class zzl$zzc
  extends zzj.zza
{
  private zzlb.zzb<LocationSettingsResult> zzaFC;
  
  public zzl$zzc(zzlb.zzb<LocationSettingsResult> paramzzb)
  {
    if (paramzzb != null) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "listener can't be null.");
      zzaFC = paramzzb;
      return;
    }
  }
  
  public void zza(LocationSettingsResult paramLocationSettingsResult)
    throws RemoteException
  {
    zzaFC.zzp(paramLocationSettingsResult);
    zzaFC = null;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.zzl.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */