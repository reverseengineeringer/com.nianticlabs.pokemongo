package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

class zzli$7
  implements ResultCallback<Status>
{
  zzli$7(zzli paramzzli, zzlo paramzzlo, boolean paramBoolean, GoogleApiClient paramGoogleApiClient) {}
  
  public void zzo(Status paramStatus)
  {
    if ((paramStatus.isSuccess()) && (zzacr.isConnected())) {
      zzacr.reconnect();
    }
    zzacv.zzb(paramStatus);
    if (zzacw) {
      zzWT.disconnect();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzli.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */