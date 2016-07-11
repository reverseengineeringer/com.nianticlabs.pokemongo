package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.GeofencingRequest.Builder;
import com.google.android.gms.location.LocationServices.zza;
import java.util.List;

public class zzf
  implements GeofencingApi
{
  public PendingResult<Status> addGeofences(GoogleApiClient paramGoogleApiClient, final GeofencingRequest paramGeofencingRequest, final PendingIntent paramPendingIntent)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzl paramAnonymouszzl)
        throws RemoteException
      {
        paramAnonymouszzl.zza(paramGeofencingRequest, paramPendingIntent, this);
      }
    });
  }
  
  @Deprecated
  public PendingResult<Status> addGeofences(GoogleApiClient paramGoogleApiClient, List<Geofence> paramList, PendingIntent paramPendingIntent)
  {
    GeofencingRequest.Builder localBuilder = new GeofencingRequest.Builder();
    localBuilder.addGeofences(paramList);
    localBuilder.setInitialTrigger(5);
    return addGeofences(paramGoogleApiClient, localBuilder.build(), paramPendingIntent);
  }
  
  public PendingResult<Status> removeGeofences(GoogleApiClient paramGoogleApiClient, final PendingIntent paramPendingIntent)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzl paramAnonymouszzl)
        throws RemoteException
      {
        paramAnonymouszzl.zza(paramPendingIntent, this);
      }
    });
  }
  
  public PendingResult<Status> removeGeofences(GoogleApiClient paramGoogleApiClient, final List<String> paramList)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzl paramAnonymouszzl)
        throws RemoteException
      {
        paramAnonymouszzl.zza(paramList, this);
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
 * Qualified Name:     com.google.android.gms.location.internal.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */