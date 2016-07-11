package com.google.android.gms.ads.internal.reward.mediation.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc
  implements Parcelable.Creator<RewardItemParcel>
{
  static void zza(RewardItemParcel paramRewardItemParcel, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zza(paramParcel, 2, type, false);
    zzb.zzc(paramParcel, 3, zzHv);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public RewardItemParcel[] zzL(int paramInt)
  {
    return new RewardItemParcel[paramInt];
  }
  
  public RewardItemParcel zzo(Parcel paramParcel)
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
        i = zza.zzg(paramParcel, m);
        break;
      case 2: 
        str = zza.zzp(paramParcel, m);
        break;
      case 3: 
        j = zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new RewardItemParcel(i, str, j);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.reward.mediation.client.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */