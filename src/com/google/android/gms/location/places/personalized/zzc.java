package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc
  implements Parcelable.Creator<PlaceAlias>
{
  static void zza(PlaceAlias paramPlaceAlias, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramPlaceAlias.zzxq(), false);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public PlaceAlias zzfc(Parcel paramParcel)
  {
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
        str = zza.zzp(paramParcel, k);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new PlaceAlias(i, str);
  }
  
  public PlaceAlias[] zzhA(int paramInt)
  {
    return new PlaceAlias[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.personalized.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */