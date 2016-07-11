package com.google.android.gms.common.api;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.google.android.gms.internal.zzlp;

class GoogleApiClient$Builder$1
  implements Runnable
{
  GoogleApiClient$Builder$1(GoogleApiClient.Builder paramBuilder, GoogleApiClient paramGoogleApiClient) {}
  
  public void run()
  {
    if ((GoogleApiClient.Builder.zza(zzaaU).isFinishing()) || (GoogleApiClient.Builder.zza(zzaaU).getSupportFragmentManager().isDestroyed())) {
      return;
    }
    GoogleApiClient.Builder.zza(zzaaU, zzlp.zzb(GoogleApiClient.Builder.zza(zzaaU)), zzWT);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.GoogleApiClient.Builder.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */