package com.google.android.gms.identity.intents;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlb.zza;
import com.google.android.gms.internal.zzoy;

public final class Address
{
  public static final Api<AddressOptions> API = new Api("Address.API", zzRl, zzRk);
  static final Api.zzc<zzoy> zzRk = new Api.zzc();
  private static final Api.zza<zzoy, AddressOptions> zzRl = new Api.zza()
  {
    public zzoy zza(Context paramAnonymousContext, Looper paramAnonymousLooper, zzf paramAnonymouszzf, Address.AddressOptions paramAnonymousAddressOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      zzx.zzb(paramAnonymousContext instanceof Activity, "An Activity must be used for Address APIs");
      Address.AddressOptions localAddressOptions = paramAnonymousAddressOptions;
      if (paramAnonymousAddressOptions == null) {
        localAddressOptions = new Address.AddressOptions();
      }
      return new zzoy((Activity)paramAnonymousContext, paramAnonymousLooper, paramAnonymouszzf, theme, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
    }
  };
  
  public static void requestUserAddress(GoogleApiClient paramGoogleApiClient, final UserAddressRequest paramUserAddressRequest, final int paramInt)
  {
    paramGoogleApiClient.zza(new zza(paramGoogleApiClient)
    {
      protected void zza(zzoy paramAnonymouszzoy)
        throws RemoteException
      {
        paramAnonymouszzoy.zza(paramUserAddressRequest, paramInt);
        zzb(Status.zzabb);
      }
    });
  }
  
  public static final class AddressOptions
    implements Api.ApiOptions.HasOptions
  {
    public final int theme;
    
    public AddressOptions()
    {
      theme = 0;
    }
    
    public AddressOptions(int paramInt)
    {
      theme = paramInt;
    }
  }
  
  private static abstract class zza
    extends zzlb.zza<Status, zzoy>
  {
    public zza(GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
    
    public Status zzd(Status paramStatus)
    {
      return paramStatus;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.identity.intents.Address
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */