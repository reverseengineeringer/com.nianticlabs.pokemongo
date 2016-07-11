package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CountrySpecification
  implements SafeParcelable
{
  public static final Parcelable.Creator<CountrySpecification> CREATOR = new zza();
  private final int mVersionCode;
  String zzGw;
  
  CountrySpecification(int paramInt, String paramString)
  {
    mVersionCode = paramInt;
    zzGw = paramString;
  }
  
  public CountrySpecification(String paramString)
  {
    mVersionCode = 1;
    zzGw = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getCountryCode()
  {
    return zzGw;
  }
  
  public int getVersionCode()
  {
    return mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.identity.intents.model.CountrySpecification
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */