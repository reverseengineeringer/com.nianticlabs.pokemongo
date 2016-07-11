package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.zza;

public final class zzj$zzi
  extends zzj<T>.zza
{
  public zzj$zzi(zzj paramzzj, int paramInt, Bundle paramBundle)
  {
    super(paramzzj, paramInt, paramBundle);
  }
  
  protected void zzh(ConnectionResult paramConnectionResult)
  {
    zzj.zza(zzafK).zzb(paramConnectionResult);
    zzafK.onConnectionFailed(paramConnectionResult);
  }
  
  protected boolean zzpf()
  {
    zzj.zza(zzafK).zzb(ConnectionResult.zzZY);
    return true;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzj.zzi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */