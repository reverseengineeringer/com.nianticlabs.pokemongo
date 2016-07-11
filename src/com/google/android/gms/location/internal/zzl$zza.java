package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlb.zzb;
import com.google.android.gms.location.LocationStatusCodes;

final class zzl$zza
  extends zzh.zza
{
  private zzlb.zzb<Status> zzaFC;
  
  public zzl$zza(zzlb.zzb<Status> paramzzb)
  {
    zzaFC = paramzzb;
  }
  
  public void zza(int paramInt, PendingIntent paramPendingIntent)
  {
    Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByPendingIntentResult");
  }
  
  public void zza(int paramInt, String[] paramArrayOfString)
  {
    if (zzaFC == null)
    {
      Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
      return;
    }
    paramArrayOfString = LocationStatusCodes.zzgW(LocationStatusCodes.zzgV(paramInt));
    zzaFC.zzp(paramArrayOfString);
    zzaFC = null;
  }
  
  public void zzb(int paramInt, String[] paramArrayOfString)
  {
    Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByRequestIdsResult");
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.zzl.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */