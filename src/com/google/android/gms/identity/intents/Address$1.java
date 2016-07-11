package com.google.android.gms.identity.intents;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzoy;

final class Address$1
  extends Api.zza<zzoy, Address.AddressOptions>
{
  public zzoy zza(Context paramContext, Looper paramLooper, zzf paramzzf, Address.AddressOptions paramAddressOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzx.zzb(paramContext instanceof Activity, "An Activity must be used for Address APIs");
    Address.AddressOptions localAddressOptions = paramAddressOptions;
    if (paramAddressOptions == null) {
      localAddressOptions = new Address.AddressOptions();
    }
    return new zzoy((Activity)paramContext, paramLooper, paramzzf, theme, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.identity.intents.Address.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */