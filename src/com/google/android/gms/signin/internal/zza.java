package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza
  implements Parcelable.Creator<AuthAccountResult>
{
  static void zza(AuthAccountResult paramAuthAccountResult, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public AuthAccountResult zzgB(Parcel paramParcel)
  {
    int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(paramParcel);
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zza.zzao(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, k);
        break;
      case 1: 
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new AuthAccountResult(i);
  }
  
  public AuthAccountResult[] zzjo(int paramInt)
  {
    return new AuthAccountResult[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.signin.internal.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */