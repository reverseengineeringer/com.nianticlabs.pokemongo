package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import java.util.concurrent.locks.Lock;

class zzli$2
  implements GoogleApiClient.ConnectionCallbacks
{
  zzli$2(zzli paramzzli) {}
  
  public void onConnected(Bundle paramBundle)
  {
    zzli.zzb(zzacr).lock();
    try
    {
      zzli.zzc(zzacr).onConnected(paramBundle);
      return;
    }
    finally
    {
      zzli.zzb(zzacr).unlock();
    }
  }
  
  public void onConnectionSuspended(int paramInt)
  {
    zzli.zzb(zzacr).lock();
    try
    {
      zzli.zzc(zzacr).onConnectionSuspended(paramInt);
      return;
    }
    finally
    {
      zzli.zzb(zzacr).unlock();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzli.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */