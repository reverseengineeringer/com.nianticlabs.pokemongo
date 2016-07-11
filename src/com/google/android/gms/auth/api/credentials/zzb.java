package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public class zzb
  implements Parcelable.Creator<CredentialPickerConfig>
{
  static void zza(CredentialPickerConfig paramCredentialPickerConfig, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.zzb.zzaq(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 1, paramCredentialPickerConfig.shouldShowAddAccountButton());
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1000, mVersionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, paramCredentialPickerConfig.shouldShowCancelButton());
    com.google.android.gms.common.internal.safeparcel.zzb.zzI(paramParcel, paramInt);
  }
  
  public CredentialPickerConfig zzF(Parcel paramParcel)
  {
    boolean bool2 = false;
    int j = zza.zzap(paramParcel);
    boolean bool1 = false;
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
        bool1 = zza.zzc(paramParcel, k);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        bool2 = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new CredentialPickerConfig(i, bool1, bool2);
  }
  
  public CredentialPickerConfig[] zzaw(int paramInt)
  {
    return new CredentialPickerConfig[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */