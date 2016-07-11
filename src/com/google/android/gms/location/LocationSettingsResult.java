package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LocationSettingsResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<LocationSettingsResult> CREATOR = new zzg();
  private final int mVersionCode;
  private final Status zzSC;
  private final LocationSettingsStates zzaEP;
  
  LocationSettingsResult(int paramInt, Status paramStatus, LocationSettingsStates paramLocationSettingsStates)
  {
    mVersionCode = paramInt;
    zzSC = paramStatus;
    zzaEP = paramLocationSettingsStates;
  }
  
  public LocationSettingsResult(Status paramStatus)
  {
    this(1, paramStatus, null);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public LocationSettingsStates getLocationSettingsStates()
  {
    return zzaEP;
  }
  
  public Status getStatus()
  {
    return zzSC;
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.LocationSettingsResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */