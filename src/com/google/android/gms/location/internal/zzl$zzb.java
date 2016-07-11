package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlb.zzb;
import com.google.android.gms.location.LocationStatusCodes;

final class zzl$zzb
  extends zzh.zza
{
  private zzlb.zzb<Status> zzaFC;
  
  public zzl$zzb(zzlb.zzb<Status> paramzzb)
  {
    zzaFC = paramzzb;
  }
  
  private void zzgZ(int paramInt)
  {
    if (zzaFC == null)
    {
      Log.wtf("LocationClientImpl", "onRemoveGeofencesResult called multiple times");
      return;
    }
    Status localStatus = LocationStatusCodes.zzgW(LocationStatusCodes.zzgV(paramInt));
    zzaFC.zzp(localStatus);
    zzaFC = null;
  }
  
  public void zza(int paramInt, PendingIntent paramPendingIntent)
  {
    zzgZ(paramInt);
  }
  
  public void zza(int paramInt, String[] paramArrayOfString)
  {
    Log.wtf("LocationClientImpl", "Unexpected call to onAddGeofencesResult");
  }
  
  public void zzb(int paramInt, String[] paramArrayOfString)
  {
    zzgZ(paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.zzl.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */