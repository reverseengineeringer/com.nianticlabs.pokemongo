package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh
  implements Parcelable.Creator<LocationSettingsStates>
{
  static void zza(LocationSettingsStates paramLocationSettingsStates, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramLocationSettingsStates.isGpsUsable());
    zzb.zzc(paramParcel, 1000, paramLocationSettingsStates.getVersionCode());
    zzb.zza(paramParcel, 2, paramLocationSettingsStates.isNetworkLocationUsable());
    zzb.zza(paramParcel, 3, paramLocationSettingsStates.isBleUsable());
    zzb.zza(paramParcel, 4, paramLocationSettingsStates.isGpsPresent());
    zzb.zza(paramParcel, 5, paramLocationSettingsStates.isNetworkLocationPresent());
    zzb.zza(paramParcel, 6, paramLocationSettingsStates.isBlePresent());
    zzb.zza(paramParcel, 7, paramLocationSettingsStates.zzwA());
    zzb.zzI(paramParcel, paramInt);
  }
  
  public LocationSettingsStates zzeE(Parcel paramParcel)
  {
    boolean bool1 = false;
    int j = zza.zzap(paramParcel);
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool7 = false;
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
        bool7 = zza.zzc(paramParcel, k);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        bool6 = zza.zzc(paramParcel, k);
        break;
      case 3: 
        bool5 = zza.zzc(paramParcel, k);
        break;
      case 4: 
        bool4 = zza.zzc(paramParcel, k);
        break;
      case 5: 
        bool3 = zza.zzc(paramParcel, k);
        break;
      case 6: 
        bool2 = zza.zzc(paramParcel, k);
        break;
      case 7: 
        bool1 = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new LocationSettingsStates(i, bool7, bool6, bool5, bool4, bool3, bool2, bool1);
  }
  
  public LocationSettingsStates[] zzgU(int paramInt)
  {
    return new LocationSettingsStates[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.zzh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */