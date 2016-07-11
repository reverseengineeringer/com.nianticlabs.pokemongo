package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm
  implements Parcelable.Creator<UserDataType>
{
  static void zza(UserDataType paramUserDataType, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, zzGq, false);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zzc(paramParcel, 2, zzaGM);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public UserDataType zzeT(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzap(paramParcel);
    String str = null;
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzao(paramParcel);
      switch (zza.zzbM(m))
      {
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        str = zza.zzp(paramParcel, m);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, m);
        break;
      case 2: 
        j = zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new UserDataType(i, str, j);
  }
  
  public UserDataType[] zzhq(int paramInt)
  {
    return new UserDataType[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.zzm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */