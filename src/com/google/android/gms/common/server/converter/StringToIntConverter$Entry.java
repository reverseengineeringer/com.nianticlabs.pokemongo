package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class StringToIntConverter$Entry
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  final int versionCode;
  final String zzagS;
  final int zzagT;
  
  StringToIntConverter$Entry(int paramInt1, String paramString, int paramInt2)
  {
    versionCode = paramInt1;
    zzagS = paramString;
    zzagT = paramInt2;
  }
  
  StringToIntConverter$Entry(String paramString, int paramInt)
  {
    versionCode = 1;
    zzagS = paramString;
    zzagT = paramInt;
  }
  
  public int describeContents()
  {
    zzc localzzc = CREATOR;
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc localzzc = CREATOR;
    zzc.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.server.converter.StringToIntConverter.Entry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */