package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import java.util.concurrent.locks.Lock;

class zzli$4
  implements GoogleApiClient.OnConnectionFailedListener
{
  zzli$4(zzli paramzzli, Api paramApi, int paramInt) {}
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    zzli.zzb(zzacr).lock();
    try
    {
      zzli.zzc(zzacr).zza(paramConnectionResult, zzacs, zzact);
      return;
    }
    finally
    {
      zzli.zzb(zzacr).unlock();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzli.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */