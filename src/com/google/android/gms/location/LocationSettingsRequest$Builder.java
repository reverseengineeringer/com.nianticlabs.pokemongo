package com.google.android.gms.location;

import java.util.ArrayList;
import java.util.Collection;

public final class LocationSettingsRequest$Builder
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

/* Location:
 * Qualified Name:     com.google.android.gms.location.LocationSettingsRequest.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */