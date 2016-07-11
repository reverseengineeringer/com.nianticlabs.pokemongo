package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzad
  implements Parcelable.Creator<ValidateAccountRequest>
{
  static void zza(ValidateAccountRequest paramValidateAccountRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zzc(paramParcel, 2, paramValidateAccountRequest.zzpu());
    zzb.zza(paramParcel, 3, zzaeH, false);
    zzb.zza(paramParcel, 4, paramValidateAccountRequest.zzpv(), paramInt, false);
    zzb.zza(paramParcel, 5, paramValidateAccountRequest.zzpw(), false);
    zzb.zza(paramParcel, 6, paramValidateAccountRequest.getCallingPackage(), false);
    zzb.zzI(paramParcel, i);
  }
  
  public ValidateAccountRequest zzan(Parcel paramParcel)
  {
    int i = 0;
    String str = null;
    int k = zza.zzap(paramParcel);
    Bundle localBundle = null;
    Scope[] arrayOfScope = null;
    IBinder localIBinder = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzao(paramParcel);
      switch (zza.zzbM(m))
      {
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        j = zza.zzg(paramParcel, m);
        break;
      case 2: 
        i = zza.zzg(paramParcel, m);
        break;
      case 3: 
        localIBinder = zza.zzq(paramParcel, m);
        break;
      case 4: 
        arrayOfScope = (Scope[])zza.zzb(paramParcel, m, Scope.CREATOR);
        break;
      case 5: 
        localBundle = zza.zzr(paramParcel, m);
        break;
      case 6: 
        str = zza.zzp(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new ValidateAccountRequest(j, i, localIBinder, arrayOfScope, localBundle, str);
  }
  
  public ValidateAccountRequest[] zzbL(int paramInt)
  {
    return new ValidateAccountRequest[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzad
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */