package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public class zzb
  implements Parcelable.Creator<FieldMappingDictionary.FieldMapPair>
{
  static void zza(FieldMappingDictionary.FieldMapPair paramFieldMapPair, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzaq(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, versionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, key, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, zzahi, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzI(paramParcel, i);
  }
  
  public FieldMappingDictionary.FieldMapPair zzaw(Parcel paramParcel)
  {
    FastJsonResponse.Field localField = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    String str = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzao(paramParcel);
      switch (zza.zzbM(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        str = zza.zzp(paramParcel, k);
        break;
      case 3: 
        localField = (FastJsonResponse.Field)zza.zza(paramParcel, k, FastJsonResponse.Field.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new FieldMappingDictionary.FieldMapPair(i, str, localField);
  }
  
  public FieldMappingDictionary.FieldMapPair[] zzbU(int paramInt)
  {
    return new FieldMappingDictionary.FieldMapPair[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.server.response.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */