package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza
  implements Parcelable.Creator<HereContent.Action>
{
  static void zza(HereContent.Action paramAction, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramAction.getTitle(), false);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 2, paramAction.getUri(), false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public HereContent.Action zzfa(Parcel paramParcel)
  {
    String str2 = null;
    int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(paramParcel);
    int i = 0;
    String str1 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zza.zzao(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, k);
        break;
      case 1: 
        str1 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, k);
        break;
      case 1000: 
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, k);
        break;
      case 2: 
        str2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new HereContent.Action(i, str1, str2);
  }
  
  public HereContent.Action[] zzhy(int paramInt)
  {
    return new HereContent.Action[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.personalized.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */