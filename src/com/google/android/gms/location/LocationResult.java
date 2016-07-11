package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class LocationResult
  implements SafeParcelable
{
  public static final Parcelable.Creator<LocationResult> CREATOR = new zze();
  static final List<Location> zzaEJ = ;
  private final int mVersionCode;
  private final List<Location> zzaEK;
  
  LocationResult(int paramInt, List<Location> paramList)
  {
    mVersionCode = paramInt;
    zzaEK = paramList;
  }
  
  public static LocationResult create(List<Location> paramList)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = zzaEJ;
    }
    return new LocationResult(2, (List)localObject);
  }
  
  public static LocationResult extractResult(Intent paramIntent)
  {
    if (!hasResult(paramIntent)) {
      return null;
    }
    return (LocationResult)paramIntent.getExtras().getParcelable("com.google.android.gms.location.EXTRA_LOCATION_RESULT");
  }
  
  public static boolean hasResult(Intent paramIntent)
  {
    if (paramIntent == null) {
      return false;
    }
    return paramIntent.hasExtra("com.google.android.gms.location.EXTRA_LOCATION_RESULT");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof LocationResult)) {
      return false;
    }
    paramObject = (LocationResult)paramObject;
    if (zzaEK.size() != zzaEK.size()) {
      return false;
    }
    paramObject = zzaEK.iterator();
    Iterator localIterator = zzaEK.iterator();
    while (((Iterator)paramObject).hasNext())
    {
      Location localLocation1 = (Location)localIterator.next();
      Location localLocation2 = (Location)((Iterator)paramObject).next();
      if (localLocation1.getTime() != localLocation2.getTime()) {
        return false;
      }
    }
    return true;
  }
  
  public Location getLastLocation()
  {
    int i = zzaEK.size();
    if (i == 0) {
      return null;
    }
    return (Location)zzaEK.get(i - 1);
  }
  
  public List<Location> getLocations()
  {
    return zzaEK;
  }
  
  int getVersionCode()
  {
    return mVersionCode;
  }
  
  public int hashCode()
  {
    Iterator localIterator = zzaEK.iterator();
    long l;
    for (int i = 17; localIterator.hasNext(); i = (int)(l ^ l >>> 32) + i * 31) {
      l = ((Location)localIterator.next()).getTime();
    }
    return i;
  }
  
  public String toString()
  {
    return "LocationResult[locations: " + zzaEK + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.LocationResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */