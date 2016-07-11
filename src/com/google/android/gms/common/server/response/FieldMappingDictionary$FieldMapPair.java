package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FieldMappingDictionary$FieldMapPair
  implements SafeParcelable
{
  public static final zzb CREATOR = new zzb();
  final String key;
  final int versionCode;
  final FastJsonResponse.Field<?, ?> zzahi;
  
  FieldMappingDictionary$FieldMapPair(int paramInt, String paramString, FastJsonResponse.Field<?, ?> paramField)
  {
    versionCode = paramInt;
    key = paramString;
    zzahi = paramField;
  }
  
  FieldMappingDictionary$FieldMapPair(String paramString, FastJsonResponse.Field<?, ?> paramField)
  {
    versionCode = 1;
    key = paramString;
    zzahi = paramField;
  }
  
  public int describeContents()
  {
    zzb localzzb = CREATOR;
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb localzzb = CREATOR;
    zzb.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.server.response.FieldMappingDictionary.FieldMapPair
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */