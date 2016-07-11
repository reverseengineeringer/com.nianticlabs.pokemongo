package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzc
  implements Parcelable.Creator<AutocompleteFilter>
{
  static void zza(AutocompleteFilter paramAutocompleteFilter, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramAutocompleteFilter.zzwM());
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 2, zzaFX, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public AutocompleteFilter zzeL(Parcel paramParcel)
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
        bool = zza.zzc(paramParcel, k);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        localArrayList = zza.zzC(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new AutocompleteFilter(i, bool, localArrayList);
  }
  
  public AutocompleteFilter[] zzhg(int paramInt)
  {
    return new AutocompleteFilter[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */