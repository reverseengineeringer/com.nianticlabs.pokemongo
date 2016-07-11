package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;

public final class LocationSettingsStates
  implements SafeParcelable
{
  public static final Parcelable.Creator<LocationSettingsStates> CREATOR = new zzh();
  private final int mVersionCode;
  private final boolean zzaEQ;
  private final boolean zzaER;
  private final boolean zzaES;
  private final boolean zzaET;
  private final boolean zzaEU;
  private final boolean zzaEV;
  private final boolean zzaEW;
  
  LocationSettingsStates(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    mVersionCode = paramInt;
    zzaEQ = paramBoolean1;
    zzaER = paramBoolean2;
    zzaES = paramBoolean3;
    zzaET = paramBoolean4;
    zzaEU = paramBoolean5;
    zzaEV = paramBoolean6;
    zzaEW = paramBoolean7;
  }
  
  public static LocationSettingsStates fromIntent(Intent paramIntent)
  {
    return (LocationSettingsStates)zzc.zza(paramIntent, "com.google.android.gms.location.LOCATION_SETTINGS_STATES", CREATOR);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public boolean isBlePresent()
  {
    return zzaEV;
  }
  
  public boolean isBleUsable()
  {
    return zzaES;
  }
  
  public boolean isGpsPresent()
  {
    return zzaET;
  }
  
  public boolean isGpsUsable()
  {
    return zzaEQ;
  }
  
  public boolean isLocationPresent()
  {
    return (zzaET) || (zzaEU);
  }
  
  public boolean isLocationUsable()
  {
    return (zzaEQ) || (zzaER);
  }
  
  public boolean isNetworkLocationPresent()
  {
    return zzaEU;
  }
  
  public boolean isNetworkLocationUsable()
  {
    return zzaER;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
  
  public boolean zzwA()
  {
    return zzaEW;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.LocationSettingsStates
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */