package com.google.android.gms.identity.intents;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzoy;

final class Address$2
  extends Address.zza
{
  Address$2(GoogleApiClient paramGoogleApiClient, UserAddressRequest paramUserAddressRequest, int paramInt)
  {
    super(paramGoogleApiClient);
  }
  
  protected void zza(zzoy paramzzoy)
    throws RemoteException
  {
    paramzzoy.zza(zzaDf, zzaDg);
    zzb(Status.zzabb);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.identity.intents.Address.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */