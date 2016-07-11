package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.zzf;
import com.google.android.gms.location.places.zzf.zza;

class zzq$1
  extends zzf.zza<zze>
{
  zzq$1(zzq paramzzq, Api.zzc paramzzc, GoogleApiClient paramGoogleApiClient, int paramInt1, int paramInt2)
  {
    super(paramzzc, paramGoogleApiClient);
  }
  
  protected void zza(zze paramzze)
    throws RemoteException
  {
    paramzze.zza(new zzf(this), zzq.zza(zzaHP), zzaHN, zzaHO, zzq.zzb(zzaHP));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.zzq.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */