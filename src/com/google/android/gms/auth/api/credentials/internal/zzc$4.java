package com.google.android.gms.auth.api.credentials.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

class zzc$4
  extends zzd<Status>
{
  zzc$4(zzc paramzzc, GoogleApiClient paramGoogleApiClient)
  {
    super(paramGoogleApiClient);
  }
  
  protected void zza(Context paramContext, zzh paramzzh)
    throws RemoteException
  {
    paramzzh.zza(new zzc.zza(this));
  }
  
  protected Status zzd(Status paramStatus)
  {
    return paramStatus;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.internal.zzc.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */