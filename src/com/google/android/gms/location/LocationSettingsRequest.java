package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class LocationSettingsRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<LocationSettingsRequest> CREATOR = new zzf();
  private final int mVersionCode;
  private final boolean zzaEL;
  private final boolean zzaEM;
  private final boolean zzaEN;
  private final List<LocationRequest> zzasK;
  
  LocationSettingsRequest(int paramInt, List<LocationRequest> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    mVersionCode = paramInt;
    zzasK = paramList;
    zzaEL = paramBoolean1;
    zzaEM = paramBoolean2;
    zzaEN = paramBoolean3;
  }
  
  private LocationSettingsRequest(List<LocationRequest> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this(2, paramList, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
  
  public List<LocationRequest> zztd()
  {
    return Collections.unmodifiableList(zzasK);
  }
  
  public boolean zzwx()
  {
    return zzaEL;
  }
  
  public boolean zzwy()
  {
    return zzaEM;
  }
  
  public boolean zzwz()
  {
    return zzaEN;
  }
  
  public static final class Builder
  {
    private boolean zzaEL = false;
    private boolean zzaEM = false;
    private boolean zzaEN = false;
    private final ArrayList<LocationRequest> zzaEO = new ArrayList();
    
    public Builder addAllLocationRequests(Collection<LocationRequest> paramCollection)
    {
      zzaEO.addAll(paramCollection);
      return this;
    }
    
    public Builder addLocationRequest(LocationRequest paramLocationRequest)
    {
      zzaEO.add(paramLocationRequest);
      return this;
    }
    
    public LocationSettingsRequest build()
    {
      return new LocationSettingsRequest(zzaEO, zzaEL, zzaEM, zzaEN, null);
    }
    
    public Builder setAlwaysShow(boolean paramBoolean)
    {
      zzaEL = paramBoolean;
      return this;
    }
    
    public Builder setNeedBle(boolean paramBoolean)
    {
      zzaEM = paramBoolean;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.LocationSettingsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */