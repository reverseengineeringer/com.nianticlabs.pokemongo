package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeofencingRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<GeofencingRequest> CREATOR = new zza();
  public static final int INITIAL_TRIGGER_DWELL = 4;
  public static final int INITIAL_TRIGGER_ENTER = 1;
  public static final int INITIAL_TRIGGER_EXIT = 2;
  private final int mVersionCode;
  private final List<ParcelableGeofence> zzaEt;
  private final int zzaEu;
  
  GeofencingRequest(int paramInt1, List<ParcelableGeofence> paramList, int paramInt2)
  {
    mVersionCode = paramInt1;
    zzaEt = paramList;
    zzaEu = paramInt2;
  }
  
  private GeofencingRequest(List<ParcelableGeofence> paramList, int paramInt)
  {
    this(1, paramList, paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<Geofence> getGeofences()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(zzaEt);
    return localArrayList;
  }
  
  public int getInitialTrigger()
  {
    return zzaEu;
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public List<ParcelableGeofence> zzwv()
  {
    return zzaEt;
  }
  
  public static final class Builder
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.GeofencingRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */