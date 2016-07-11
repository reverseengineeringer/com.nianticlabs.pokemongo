package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationServices.zza;

public class zzd
  implements FusedLocationProviderApi
{
  public Location getLastLocation(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient = LocationServices.zzd(paramGoogleApiClient);
    try
    {
      paramGoogleApiClient = paramGoogleApiClient.getLastLocation();
      return paramGoogleApiClient;
    }
    catch (Exception paramGoogleApiClient) {}
    return null;
  }
  
  public LocationAvailability getLocationAvailability(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient = LocationServices.zzd(paramGoogleApiClient);
    try
    {
      paramGoogleApiClient = paramGoogleApiClient.zzwD();
      return paramGoogleApiClient;
    }
    catch (Exception paramGoogleApiClient) {}
    return null;
  }
  
  public PendingResult<Status> removeLocationUpdates(GoogleApiClient paramGoogleApiClient, final PendingIntent paramPendingIntent)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzl paramAnonymouszzl)
        throws RemoteException
      {
        zzg.zza local1 = new zzg.zza()
        {
          public void zza(FusedLocationProviderResult paramAnonymous2FusedLocationProviderResult)
          {
            zzb(paramAnonymous2FusedLocationProviderResult.getStatus());
          }
        };
        paramAnonymouszzl.zza(paramPendingIntent, local1);
      }
    });
  }
  
  public PendingResult<Status> removeLocationUpdates(GoogleApiClient paramGoogleApiClient, final LocationCallback paramLocationCallback)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzl paramAnonymouszzl)
        throws RemoteException
      {
        zzg.zza local1 = new zzg.zza()
        {
          public void zza(FusedLocationProviderResult paramAnonymous2FusedLocationProviderResult)
          {
            zzb(paramAnonymous2FusedLocationProviderResult.getStatus());
          }
        };
        paramAnonymouszzl.zza(paramLocationCallback, local1);
      }
    });
  }
  
  public PendingResult<Status> removeLocationUpdates(GoogleApiClient paramGoogleApiClient, final LocationListener paramLocationListener)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzl paramAnonymouszzl)
        throws RemoteException
      {
        zzg.zza local1 = new zzg.zza()
        {
          public void zza(FusedLocationProviderResult paramAnonymous2FusedLocationProviderResult)
          {
            zzb(paramAnonymous2FusedLocationProviderResult.getStatus());
          }
        };
        paramAnonymouszzl.zza(paramLocationListener, local1);
      }
    });
  }
  
  public PendingResult<Status> requestLocationUpdates(GoogleApiClient paramGoogleApiClient, final LocationRequest paramLocationRequest, final PendingIntent paramPendingIntent)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzl paramAnonymouszzl)
        throws RemoteException
      {
        zzg.zza local1 = new zzg.zza()
        {
          public void zza(FusedLocationProviderResult paramAnonymous2FusedLocationProviderResult)
          {
            zzb(paramAnonymous2FusedLocationProviderResult.getStatus());
          }
        };
        paramAnonymouszzl.zza(paramLocationRequest, paramPendingIntent, local1);
      }
    });
  }
  
  public PendingResult<Status> requestLocationUpdates(GoogleApiClient paramGoogleApiClient, final LocationRequest paramLocationRequest, final LocationCallback paramLocationCallback, final Looper paramLooper)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzl paramAnonymouszzl)
        throws RemoteException
      {
        zzg.zza local1 = new zzg.zza()
        {
          public void zza(FusedLocationProviderResult paramAnonymous2FusedLocationProviderResult)
          {
            zzb(paramAnonymous2FusedLocationProviderResult.getStatus());
          }
        };
        paramAnonymouszzl.zza(LocationRequestInternal.zzb(paramLocationRequest), paramLocationCallback, paramLooper, local1);
      }
    });
  }
  
  public PendingResult<Status> requestLocationUpdates(GoogleApiClient paramGoogleApiClient, final LocationRequest paramLocationRequest, final LocationListener paramLocationListener)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzl paramAnonymouszzl)
        throws RemoteException
      {
        zzg.zza local1 = new zzg.zza()
        {
          public void zza(FusedLocationProviderResult paramAnonymous2FusedLocationProviderResult)
          {
            zzb(paramAnonymous2FusedLocationProviderResult.getStatus());
          }
        };
        paramAnonymouszzl.zza(paramLocationRequest, paramLocationListener, null, local1);
      }
    });
  }
  
  public PendingResult<Status> requestLocationUpdates(GoogleApiClient paramGoogleApiClient, final LocationRequest paramLocationRequest, final LocationListener paramLocationListener, final Looper paramLooper)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzl paramAnonymouszzl)
        throws RemoteException
      {
        zzg.zza local1 = new zzg.zza()
        {
          public void zza(FusedLocationProviderResult paramAnonymous2FusedLocationProviderResult)
          {
            zzb(paramAnonymous2FusedLocationProviderResult.getStatus());
          }
        };
        paramAnonymouszzl.zza(paramLocationRequest, paramLocationListener, paramLooper, local1);
      }
    });
  }
  
  public PendingResult<Status> setMockLocation(GoogleApiClient paramGoogleApiClient, final Location paramLocation)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzl paramAnonymouszzl)
        throws RemoteException
      {
        paramAnonymouszzl.zzc(paramLocation);
        zzb(Status.zzabb);
      }
    });
  }
  
  public PendingResult<Status> setMockMode(GoogleApiClient paramGoogleApiClient, final boolean paramBoolean)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzl paramAnonymouszzl)
        throws RemoteException
      {
        paramAnonymouszzl.zzah(paramBoolean);
        zzb(Status.zzabb);
      }
    });
  }
  
  private static abstract class zza
    extends LocationServices.zza<Status>
  {
    public zza(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    public Status zzd(Status paramStatus)
    {
      return paramStatus;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */