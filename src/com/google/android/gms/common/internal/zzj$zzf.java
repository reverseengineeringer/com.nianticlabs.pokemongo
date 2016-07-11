package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.zza;

public class zzj$zzf
  implements GoogleApiClient.zza
{
  public zzj$zzf(zzj paramzzj) {}
  
  public void zza(ConnectionResult paramConnectionResult)
  {
    if (paramConnectionResult.isSuccess()) {
      zzafK.zza(null, zzj.zzd(zzafK));
    }
    while (zzj.zze(zzafK) == null) {
      return;
    }
    zzj.zze(zzafK).onConnectionFailed(paramConnectionResult);
  }
  
  public void zzb(ConnectionResult paramConnectionResult)
  {
    throw new IllegalStateException("Legacy GmsClient received onReportAccountValidation callback.");
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzj.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */