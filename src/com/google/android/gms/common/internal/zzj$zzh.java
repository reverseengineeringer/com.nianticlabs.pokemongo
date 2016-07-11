package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.zza;

public final class zzj$zzh
  extends zzj<T>.zza
{
  public zzj$zzh(zzj paramzzj)
  {
    super(paramzzj, 0, null);
  }
  
  protected void zzh(ConnectionResult paramConnectionResult)
  {
    zzj.zza(zzafK).zza(paramConnectionResult);
    zzafK.onConnectionFailed(paramConnectionResult);
  }
  
  protected boolean zzpf()
  {
    zzj.zza(zzafK).zza(ConnectionResult.zzZY);
    return true;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzj.zzh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */