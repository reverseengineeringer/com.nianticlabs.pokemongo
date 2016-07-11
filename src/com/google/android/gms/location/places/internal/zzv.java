package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzv
  implements Parcelable.Creator<AutocompletePredictionEntity.SubstringEntity>
{
  static void zza(AutocompletePredictionEntity.SubstringEntity paramSubstringEntity, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, mOffset);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zzc(paramParcel, 2, mLength);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public AutocompletePredictionEntity.SubstringEntity zzeZ(Parcel paramParcel)
  {
    int k = 0;
    int m = zza.zzap(paramParcel);
    int j = 0;
    int i = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzao(paramParcel);
      switch (zza.zzbM(n))
      {
      default: 
        zza.zzb(paramParcel, n);
        break;
      case 1: 
        j = zza.zzg(paramParcel, n);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, n);
        break;
      case 2: 
        k = zza.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new AutocompletePredictionEntity.SubstringEntity(i, j, k);
  }
  
  public AutocompletePredictionEntity.SubstringEntity[] zzhx(int paramInt)
  {
    return new AutocompletePredictionEntity.SubstringEntity[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.zzv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */