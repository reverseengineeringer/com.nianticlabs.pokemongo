package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.auth.api.credentials.internal.zzc;
import com.google.android.gms.auth.api.credentials.internal.zze;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.signin.GoogleSignInConfig;
import com.google.android.gms.auth.api.signin.internal.zzb;
import com.google.android.gms.auth.api.signin.zzd;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.zzjz;
import com.google.android.gms.internal.zzka;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzkf;
import com.google.android.gms.internal.zzki;
import com.google.android.gms.internal.zzkm;

public final class Auth
{
  public static final Api<AuthCredentialsOptions> CREDENTIALS_API;
  public static final CredentialsApi CredentialsApi = new zzc();
  public static final Api<zza> PROXY_API;
  public static final ProxyApi ProxyApi;
  public static final Api.zzc<zzki> zzRE = new Api.zzc();
  public static final Api.zzc<zze> zzRF = new Api.zzc();
  public static final Api.zzc<zzkb> zzRG = new Api.zzc();
  public static final Api.zzc<com.google.android.gms.auth.api.signin.internal.zzg> zzRH = new Api.zzc();
  public static final Api.zzc<zzb> zzRI = new Api.zzc();
  public static final Api.zzc<zzkf> zzRJ = new Api.zzc();
  private static final Api.zza<zzki, zza> zzRK = new Api.zza()
  {
    public zzki zza(Context paramAnonymousContext, Looper paramAnonymousLooper, com.google.android.gms.common.internal.zzf paramAnonymouszzf, Auth.zza paramAnonymouszza, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new zzki(paramAnonymousContext, paramAnonymousLooper, paramAnonymouszzf, paramAnonymouszza, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
    }
  };
  private static final Api.zza<zze, AuthCredentialsOptions> zzRL = new Api.zza()
  {
    public zze zza(Context paramAnonymousContext, Looper paramAnonymousLooper, com.google.android.gms.common.internal.zzf paramAnonymouszzf, Auth.AuthCredentialsOptions paramAnonymousAuthCredentialsOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new zze(paramAnonymousContext, paramAnonymousLooper, paramAnonymouszzf, paramAnonymousAuthCredentialsOptions, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
    }
  };
  private static final Api.zza<zzkb, Api.ApiOptions.NoOptions> zzRM = new Api.zza()
  {
    public zzkb zzc(Context paramAnonymousContext, Looper paramAnonymousLooper, com.google.android.gms.common.internal.zzf paramAnonymouszzf, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new zzkb(paramAnonymousContext, paramAnonymousLooper, paramAnonymouszzf, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
    }
  };
  private static final Api.zza<zzkf, Api.ApiOptions.NoOptions> zzRN = new Api.zza()
  {
    public zzkf zzd(Context paramAnonymousContext, Looper paramAnonymousLooper, com.google.android.gms.common.internal.zzf paramAnonymouszzf, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new zzkf(paramAnonymousContext, paramAnonymousLooper, paramAnonymouszzf, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
    }
  };
  private static final Api.zza<com.google.android.gms.auth.api.signin.internal.zzg, com.google.android.gms.auth.api.signin.zzg> zzRO = new Api.zza()
  {
    public com.google.android.gms.auth.api.signin.internal.zzg zza(Context paramAnonymousContext, Looper paramAnonymousLooper, com.google.android.gms.common.internal.zzf paramAnonymouszzf, com.google.android.gms.auth.api.signin.zzg paramAnonymouszzg, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new com.google.android.gms.auth.api.signin.internal.zzg(paramAnonymousContext, paramAnonymousLooper, paramAnonymouszzf, paramAnonymouszzg, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
    }
  };
  private static final Api.zza<zzb, GoogleSignInConfig> zzRP = new Api.zza()
  {
    public zzb zza(Context paramAnonymousContext, Looper paramAnonymousLooper, com.google.android.gms.common.internal.zzf paramAnonymouszzf, GoogleSignInConfig paramAnonymousGoogleSignInConfig, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new zzb(paramAnonymousContext, paramAnonymousLooper, paramAnonymouszzf, paramAnonymousGoogleSignInConfig, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
    }
  };
  public static final Api<com.google.android.gms.auth.api.signin.zzg> zzRQ;
  public static final Api<GoogleSignInConfig> zzRR;
  public static final Api<Api.ApiOptions.NoOptions> zzRS;
  public static final Api<Api.ApiOptions.NoOptions> zzRT;
  public static final zzjz zzRU = new zzka();
  public static final com.google.android.gms.auth.api.signin.zzf zzRV = new com.google.android.gms.auth.api.signin.internal.zzf();
  public static final zzd zzRW = new com.google.android.gms.auth.api.signin.internal.zza();
  public static final com.google.android.gms.auth.api.consent.zza zzRX = new zzke();
  
  static
  {
    PROXY_API = new Api("Auth.PROXY_API", zzRK, zzRE);
    CREDENTIALS_API = new Api("Auth.CREDENTIALS_API", zzRL, zzRF);
    zzRQ = new Api("Auth.SIGN_IN_API", zzRO, zzRH);
    zzRR = new Api("Auth.GOOGLE_SIGN_IN_API", zzRP, zzRI);
    zzRS = new Api("Auth.ACCOUNT_STATUS_API", zzRM, zzRG);
    zzRT = new Api("Auth.CONSENT_API", zzRN, zzRJ);
    ProxyApi = new zzkm();
  }
  
  public static final class AuthCredentialsOptions
    implements Api.ApiOptions.Optional
  {
    private final String zzRY;
    private final PasswordSpecification zzRZ;
    
    public Bundle zzly()
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("consumer_package", zzRY);
      localBundle.putParcelable("password_specification", zzRZ);
      return localBundle;
    }
    
    public static class Builder
    {
      private PasswordSpecification zzRZ = PasswordSpecification.zzSt;
    }
  }
  
  public static final class zza
    implements Api.ApiOptions.Optional
  {
    private final Bundle zzSa;
    
    public Bundle zzlE()
    {
      return new Bundle(zzSa);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.Auth
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */