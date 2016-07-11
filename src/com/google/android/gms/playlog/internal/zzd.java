package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.zzqd.zza;

public class zzd
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  private zzf zzaRE;
  private final zzqd.zza zzaRP;
  private boolean zzaRQ;
  
  public zzd(zzqd.zza paramzza)
  {
    zzaRP = paramzza;
    zzaRE = null;
    zzaRQ = true;
  }
  
  public void onConnected(Bundle paramBundle)
  {
    zzaRE.zzap(false);
    if ((zzaRQ) && (zzaRP != null)) {
      zzaRP.zzBr();
    }
    zzaRQ = false;
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    zzaRE.zzap(true);
    if ((zzaRQ) && (zzaRP != null))
    {
      if (!paramConnectionResult.hasResolution()) {
        break label48;
      }
      zzaRP.zzf(paramConnectionResult.getResolution());
    }
    for (;;)
    {
      zzaRQ = false;
      return;
      label48:
      zzaRP.zzBs();
    }
  }
  
  public void onConnectionSuspended(int paramInt)
  {
    zzaRE.zzap(true);
  }
  
  public void zza(zzf paramzzf)
  {
    zzaRE = paramzzf;
  }
  
  public void zzao(boolean paramBoolean)
  {
    zzaRQ = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.playlog.internal.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */