package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlb.zzb;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.List;

public class zzl
  extends zzb
{
  private final zzk zzaFB = new zzk(paramContext, zzaFb);
  
  public zzl(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString)
  {
    this(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramString, zzf.zzak(paramContext));
  }
  
  public zzl(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString, zzf paramzzf)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramString, paramzzf);
  }
  
  public void disconnect()
  {
    synchronized (zzaFB)
    {
      boolean bool = isConnected();
      if (bool) {}
      try
      {
        zzaFB.removeAllListeners();
        zzaFB.zzwE();
        super.disconnect();
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", localException);
        }
      }
    }
  }
  
  public Location getLastLocation()
  {
    return zzaFB.getLastLocation();
  }
  
  public void zza(long paramLong, PendingIntent paramPendingIntent)
    throws RemoteException
  {
    zzpb();
    zzx.zzw(paramPendingIntent);
    if (paramLong >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "detectionIntervalMillis must be >= 0");
      ((zzi)zzpc()).zza(paramLong, true, paramPendingIntent);
      return;
    }
  }
  
  public void zza(PendingIntent paramPendingIntent)
    throws RemoteException
  {
    zzpb();
    zzx.zzw(paramPendingIntent);
    ((zzi)zzpc()).zza(paramPendingIntent);
  }
  
  public void zza(PendingIntent paramPendingIntent, zzlb.zzb<Status> paramzzb)
    throws RemoteException
  {
    zzpb();
    zzx.zzb(paramPendingIntent, "PendingIntent must be specified.");
    zzx.zzb(paramzzb, "ResultHolder not provided.");
    paramzzb = new zzb(paramzzb);
    ((zzi)zzpc()).zza(paramPendingIntent, paramzzb, getContext().getPackageName());
  }
  
  public void zza(PendingIntent paramPendingIntent, zzg paramzzg)
    throws RemoteException
  {
    zzaFB.zza(paramPendingIntent, paramzzg);
  }
  
  public void zza(GeofencingRequest paramGeofencingRequest, PendingIntent paramPendingIntent, zzlb.zzb<Status> paramzzb)
    throws RemoteException
  {
    zzpb();
    zzx.zzb(paramGeofencingRequest, "geofencingRequest can't be null.");
    zzx.zzb(paramPendingIntent, "PendingIntent must be specified.");
    zzx.zzb(paramzzb, "ResultHolder not provided.");
    paramzzb = new zza(paramzzb);
    ((zzi)zzpc()).zza(paramGeofencingRequest, paramPendingIntent, paramzzb);
  }
  
  public void zza(LocationCallback paramLocationCallback, zzg paramzzg)
    throws RemoteException
  {
    zzaFB.zza(paramLocationCallback, paramzzg);
  }
  
  public void zza(LocationListener paramLocationListener, zzg paramzzg)
    throws RemoteException
  {
    zzaFB.zza(paramLocationListener, paramzzg);
  }
  
  public void zza(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent, zzg paramzzg)
    throws RemoteException
  {
    zzaFB.zza(paramLocationRequest, paramPendingIntent, paramzzg);
  }
  
  public void zza(LocationRequest paramLocationRequest, LocationListener paramLocationListener, Looper paramLooper, zzg paramzzg)
    throws RemoteException
  {
    synchronized (zzaFB)
    {
      zzaFB.zza(paramLocationRequest, paramLocationListener, paramLooper, paramzzg);
      return;
    }
  }
  
  public void zza(LocationSettingsRequest paramLocationSettingsRequest, zzlb.zzb<LocationSettingsResult> paramzzb, String paramString)
    throws RemoteException
  {
    boolean bool2 = true;
    zzpb();
    if (paramLocationSettingsRequest != null)
    {
      bool1 = true;
      zzx.zzb(bool1, "locationSettingsRequest can't be null nor empty.");
      if (paramzzb == null) {
        break label67;
      }
    }
    label67:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzx.zzb(bool1, "listener can't be null.");
      paramzzb = new zzc(paramzzb);
      ((zzi)zzpc()).zza(paramLocationSettingsRequest, paramzzb, paramString);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void zza(LocationRequestInternal paramLocationRequestInternal, LocationCallback paramLocationCallback, Looper paramLooper, zzg paramzzg)
    throws RemoteException
  {
    synchronized (zzaFB)
    {
      zzaFB.zza(paramLocationRequestInternal, paramLocationCallback, paramLooper, paramzzg);
      return;
    }
  }
  
  public void zza(List<String> paramList, zzlb.zzb<Status> paramzzb)
    throws RemoteException
  {
    zzpb();
    if ((paramList != null) && (paramList.size() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "geofenceRequestIds can't be null nor empty.");
      zzx.zzb(paramzzb, "ResultHolder not provided.");
      paramList = (String[])paramList.toArray(new String[0]);
      paramzzb = new zzb(paramzzb);
      ((zzi)zzpc()).zza(paramList, paramzzb, getContext().getPackageName());
      return;
    }
  }
  
  public void zzah(boolean paramBoolean)
    throws RemoteException
  {
    zzaFB.zzah(paramBoolean);
  }
  
  public void zzc(Location paramLocation)
    throws RemoteException
  {
    zzaFB.zzc(paramLocation);
  }
  
  public boolean zzpe()
  {
    return true;
  }
  
  public LocationAvailability zzwD()
  {
    return zzaFB.zzwD();
  }
  
  private static final class zza
    extends zzh.zza
  {
    private zzlb.zzb<Status> zzaFC;
    
    public zza(zzlb.zzb<Status> paramzzb)
    {
      zzaFC = paramzzb;
    }
    
    public void zza(int paramInt, PendingIntent paramPendingIntent)
    {
      Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByPendingIntentResult");
    }
    
    public void zza(int paramInt, String[] paramArrayOfString)
    {
      if (zzaFC == null)
      {
        Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
        return;
      }
      paramArrayOfString = LocationStatusCodes.zzgW(LocationStatusCodes.zzgV(paramInt));
      zzaFC.zzp(paramArrayOfString);
      zzaFC = null;
    }
    
    public void zzb(int paramInt, String[] paramArrayOfString)
    {
      Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByRequestIdsResult");
    }
  }
  
  private static final class zzb
    extends zzh.zza
  {
    private zzlb.zzb<Status> zzaFC;
    
    public zzb(zzlb.zzb<Status> paramzzb)
    {
      zzaFC = paramzzb;
    }
    
    private void zzgZ(int paramInt)
    {
      if (zzaFC == null)
      {
        Log.wtf("LocationClientImpl", "onRemoveGeofencesResult called multiple times");
        return;
      }
      Status localStatus = LocationStatusCodes.zzgW(LocationStatusCodes.zzgV(paramInt));
      zzaFC.zzp(localStatus);
      zzaFC = null;
    }
    
    public void zza(int paramInt, PendingIntent paramPendingIntent)
    {
      zzgZ(paramInt);
    }
    
    public void zza(int paramInt, String[] paramArrayOfString)
    {
      Log.wtf("LocationClientImpl", "Unexpected call to onAddGeofencesResult");
    }
    
    public void zzb(int paramInt, String[] paramArrayOfString)
    {
      zzgZ(paramInt);
    }
  }
  
  private static final class zzc
    extends zzj.zza
  {
    private zzlb.zzb<LocationSettingsResult> zzaFC;
    
    public zzc(zzlb.zzb<LocationSettingsResult> paramzzb)
    {
      if (paramzzb != null) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "listener can't be null.");
        zzaFC = paramzzb;
        return;
      }
    }
    
    public void zza(LocationSettingsResult paramLocationSettingsResult)
      throws RemoteException
    {
      zzaFC.zzp(paramLocationSettingsResult);
      zzaFC = null;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.zzl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */