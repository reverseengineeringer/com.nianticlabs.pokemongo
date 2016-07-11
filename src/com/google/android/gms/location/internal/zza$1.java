package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

class zza$1
  extends zza.zza
{
  zza$1(zza paramzza, GoogleApiClient paramGoogleApiClient, long paramLong, PendingIntent paramPendingIntent)
  {
    super(paramGoogleApiClient);
  }
  
  protected void zza(zzl paramzzl)
    throws RemoteException
  {
    paramzzl.zza(zzaEX, zzaEY);
    zzb(Status.zzabb);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.zza.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */