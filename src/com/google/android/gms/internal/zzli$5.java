package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import java.util.concurrent.atomic.AtomicReference;

class zzli$5
  implements GoogleApiClient.ConnectionCallbacks
{
  zzli$5(zzli paramzzli, AtomicReference paramAtomicReference, zzlo paramzzlo) {}
  
  public void onConnected(Bundle paramBundle)
  {
    zzli.zza(zzacr, (GoogleApiClient)zzacu.get(), zzacv, true);
  }
  
  public void onConnectionSuspended(int paramInt) {}
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzli.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */