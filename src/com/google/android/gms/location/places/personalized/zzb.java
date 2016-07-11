package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import java.util.ArrayList;

public class zzb
  implements Parcelable.Creator<HereContent>
{
  static void zza(HereContent paramHereContent, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.zzb.zzaq(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 1, paramHereContent.getData(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1000, mVersionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 2, paramHereContent.getActions(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzI(paramParcel, paramInt);
  }
  
  public HereContent zzfb(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
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
        break;
      case 2: 
        localArrayList = zza.zzc(paramParcel, k, HereContent.Action.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new HereContent(i, str, localArrayList);
  }
  
  public HereContent[] zzhz(int paramInt)
  {
    return new HereContent[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.personalized.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */