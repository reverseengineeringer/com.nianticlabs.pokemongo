package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.location.places.PlacesOptions;
import com.google.android.gms.location.places.PlacesOptions.Builder;

public class zze$zza
  extends Api.zza<zze, PlacesOptions>
{
  private final String zzaHd;
  private final String zzaHe;
  
  public zze$zza(String paramString1, String paramString2)
  {
    zzaHd = paramString1;
    zzaHe = paramString2;
  }
  
  public zze zza(Context paramContext, Looper paramLooper, zzf paramzzf, PlacesOptions paramPlacesOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    String str1;
    String str2;
    if (zzaHd != null)
    {
      str1 = zzaHd;
      if (zzaHe == null) {
        break label73;
      }
      str2 = zzaHe;
      label26:
      if (paramPlacesOptions != null) {
        break label82;
      }
      paramPlacesOptions = new PlacesOptions.Builder().build();
    }
    label73:
    label82:
    for (;;)
    {
      return new zze(paramContext, paramLooper, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener, str1, str2, paramPlacesOptions);
      str1 = paramContext.getPackageName();
      break;
      str2 = paramContext.getPackageName();
      break label26;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.zze.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */