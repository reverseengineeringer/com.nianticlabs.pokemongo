package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc
  implements Parcelable.Creator<Scope>
{
  static void zza(Scope paramScope, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, paramScope.zznG(), false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public Scope zzad(Parcel paramParcel)
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
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        str = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new Scope(i, str);
  }
  
  public Scope[] zzbl(int paramInt)
  {
    return new Scope[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */