package com.google.android.gms.location;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class GeofencingRequest$Builder
{
  private final List<ParcelableGeofence> zzaEt = new ArrayList();
  private int zzaEu = 5;
  
  public static int zzgM(int paramInt)
  {
    return paramInt & 0x7;
  }
  
  public Builder addGeofence(Geofence paramGeofence)
  {
    zzx.zzb(paramGeofence, "geofence can't be null.");
    zzx.zzb(paramGeofence instanceof ParcelableGeofence, "Geofence must be created using Geofence.Builder.");
    zzaEt.add((ParcelableGeofence)paramGeofence);
    return this;
  }
  
  public Builder addGeofences(List<Geofence> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return this;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Geofence localGeofence = (Geofence)paramList.next();
        if (localGeofence != null) {
          addGeofence(localGeofence);
        }
      }
    }
  }
  
  public GeofencingRequest build()
  {
    if (!zzaEt.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "No geofence has been added to this request.");
      return new GeofencingRequest(zzaEt, zzaEu, null);
    }
  }
  
  public Builder setInitialTrigger(int paramInt)
  {
    zzaEu = zzgM(paramInt);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.GeofencingRequest.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */