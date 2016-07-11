package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzc
  implements Parcelable.Creator<CheckServerAuthResult>
{
  static void zza(CheckServerAuthResult paramCheckServerAuthResult, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, zzaVi);
    zzb.zzc(paramParcel, 3, zzaVj, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public CheckServerAuthResult zzgC(Parcel paramParcel)
  {
    boolean bool = false;
    int j = zza.zzap(paramParcel);
    ArrayList localArrayList = null;
    int i = 0;
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
        bool = zza.zzc(paramParcel, k);
        break;
      case 3: 
        localArrayList = zza.zzc(paramParcel, k, Scope.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new CheckServerAuthResult(i, bool, localArrayList);
  }
  
  public CheckServerAuthResult[] zzjp(int paramInt)
  {
    return new CheckServerAuthResult[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.signin.internal.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */