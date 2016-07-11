package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.zzl;
import com.google.android.gms.location.places.zzl.zzc;
import java.util.Arrays;
import java.util.List;

class zzd$2
  extends zzl.zzc<zze>
{
  zzd$2(zzd paramzzd, Api.zzc paramzzc, GoogleApiClient paramGoogleApiClient, String[] paramArrayOfString)
  {
    super(paramzzc, paramGoogleApiClient);
  }
  
  protected void zza(zze paramzze)
    throws RemoteException
  {
    List localList = Arrays.asList(zzaGX);
    paramzze.zza(new zzl(this, paramzze.getContext()), localList);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.zzd.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */