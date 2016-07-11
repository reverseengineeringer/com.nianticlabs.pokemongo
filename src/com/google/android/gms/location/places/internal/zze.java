package com.google.android.gms.location.places.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.PlacesOptions;
import com.google.android.gms.location.places.PlacesOptions.Builder;
import com.google.android.gms.location.places.zzl;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;
import java.util.Locale;

public class zze
  extends zzj<zzg>
{
  private final PlacesParams zzaHb;
  private final Locale zzaHc = Locale.getDefault();
  
  public zze(Context paramContext, Looper paramLooper, com.google.android.gms.common.internal.zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString1, String paramString2, PlacesOptions paramPlacesOptions)
  {
    super(paramContext, paramLooper, 65, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    paramContext = null;
    if (paramzzf.getAccount() != null) {
      paramContext = getAccountname;
    }
    zzaHb = new PlacesParams(paramString1, zzaHc, paramContext, zzaGG, paramString2);
  }
  
  public void zza(com.google.android.gms.location.places.zzf paramzzf, String paramString)
    throws RemoteException
  {
    zzx.zzb(paramString, "placeId cannot be null");
    ((zzg)zzpc()).zza(paramString, zzaHb, paramzzf);
  }
  
  public void zza(com.google.android.gms.location.places.zzf paramzzf, String paramString, int paramInt1, int paramInt2, int paramInt3)
    throws RemoteException
  {
    boolean bool2 = true;
    zzx.zzb(paramString, "fifeUrl cannot be null");
    if (paramInt1 > 0)
    {
      bool1 = true;
      zzx.zzb(bool1, "width should be > 0");
      if (paramInt1 <= 0) {
        break label69;
      }
    }
    label69:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzx.zzb(bool1, "height should be > 0");
      ((zzg)zzpc()).zza(paramString, paramInt1, paramInt2, paramInt3, zzaHb, paramzzf);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void zza(zzl paramzzl, AddPlaceRequest paramAddPlaceRequest)
    throws RemoteException
  {
    zzx.zzb(paramAddPlaceRequest, "userAddedPlace == null");
    ((zzg)zzpc()).zza(paramAddPlaceRequest, zzaHb, paramzzl);
  }
  
  public void zza(zzl paramzzl, String paramString, LatLngBounds paramLatLngBounds, AutocompleteFilter paramAutocompleteFilter)
    throws RemoteException
  {
    zzx.zzb(paramString, "query == null");
    zzx.zzb(paramzzl, "callback == null");
    if (paramAutocompleteFilter == null) {
      paramAutocompleteFilter = AutocompleteFilter.create(null);
    }
    for (;;)
    {
      ((zzg)zzpc()).zza(paramString, paramLatLngBounds, paramAutocompleteFilter, zzaHb, paramzzl);
      return;
    }
  }
  
  public void zza(zzl paramzzl, List<String> paramList)
    throws RemoteException
  {
    ((zzg)zzpc()).zzb(paramList, zzaHb, paramzzl);
  }
  
  protected zzg zzcd(IBinder paramIBinder)
  {
    return zzg.zza.zzcf(paramIBinder);
  }
  
  protected String zzfK()
  {
    return "com.google.android.gms.location.places.GeoDataApi";
  }
  
  protected String zzfL()
  {
    return "com.google.android.gms.location.places.internal.IGooglePlacesService";
  }
  
  public static class zza
    extends Api.zza<zze, PlacesOptions>
  {
    private final String zzaHd;
    private final String zzaHe;
    
    public zza(String paramString1, String paramString2)
    {
      zzaHd = paramString1;
      zzaHe = paramString2;
    }
    
    public zze zza(Context paramContext, Looper paramLooper, com.google.android.gms.common.internal.zzf paramzzf, PlacesOptions paramPlacesOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */