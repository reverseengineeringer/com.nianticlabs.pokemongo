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
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzlb.zza;
import com.google.android.gms.location.internal.zza;
import com.google.android.gms.location.internal.zzl;

public class ActivityRecognition
{
  public static final Api<Api.ApiOptions.NoOptions> API = new Api("ActivityRecognition.API", zzRl, zzRk);
  public static final ActivityRecognitionApi ActivityRecognitionApi = new zza();
  public static final String CLIENT_NAME = "activity_recognition";
  private static final Api.zzc<zzl> zzRk = new Api.zzc();
  private static final Api.zza<zzl, Api.ApiOptions.NoOptions> zzRl = new Api.zza()
  {
    public zzl zzm(Context paramAnonymousContext, Looper paramAnonymousLooper, zzf paramAnonymouszzf, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new zzl(paramAnonymousContext, paramAnonymousLooper, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener, "activity_recognition");
    }
  };
  
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
 * Qualified Name:     com.google.android.gms.location.ActivityRecognition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */