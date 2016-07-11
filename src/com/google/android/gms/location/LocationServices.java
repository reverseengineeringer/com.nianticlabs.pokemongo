package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlb.zza;
import com.google.android.gms.location.internal.zzd;
import com.google.android.gms.location.internal.zzl;
import com.google.android.gms.location.internal.zzq;

public class LocationServices
{
  public static final Api<Api.ApiOptions.NoOptions> API = new Api("LocationServices.API", zzRl, zzRk);
  public static final FusedLocationProviderApi FusedLocationApi = new zzd();
  public static final GeofencingApi GeofencingApi = new com.google.android.gms.location.internal.zzf();
  public static final SettingsApi SettingsApi = new zzq();
  private static final Api.zzc<zzl> zzRk = new Api.zzc();
  private static final Api.zza<zzl, Api.ApiOptions.NoOptions> zzRl = new Api.zza()
  {
    public zzl zzm(Context paramAnonymousContext, Looper paramAnonymousLooper, com.google.android.gms.common.internal.zzf paramAnonymouszzf, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new zzl(paramAnonymousContext, paramAnonymousLooper, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener, "locationServices", paramAnonymouszzf);
    }
  };
  
  public static zzl zzd(GoogleApiClient paramGoogleApiClient)
  {
    boolean bool2 = true;
    if (paramGoogleApiClient != null)
    {
      bool1 = true;
      zzx.zzb(bool1, "GoogleApiClient parameter is required.");
      paramGoogleApiClient = (zzl)paramGoogleApiClient.zza(zzRk);
      if (paramGoogleApiClient == null) {
        break label44;
      }
    }
    label44:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzx.zza(bool1, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
      return paramGoogleApiClient;
      bool1 = false;
      break;
    }
  }
  
  public static abstract class zza<R extends Result>
    extends zzlb.zza<R, zzl>
  {
    public zza(GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.LocationServices
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */