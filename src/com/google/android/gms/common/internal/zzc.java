package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc
  implements Parcelable.Creator<AuthAccountRequest>
{
  static void zza(AuthAccountRequest paramAuthAccountRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, zzaeH, false);
    zzb.zza(paramParcel, 3, zzaeI, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public AuthAccountRequest zzai(Parcel paramParcel)
  {
    Scope[] arrayOfScope = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    IBinder localIBinder = null;
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
        localIBinder = zza.zzq(paramParcel, k);
        break;
      case 3: 
        arrayOfScope = (Scope[])zza.zzb(paramParcel, k, Scope.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new AuthAccountRequest(i, localIBinder, arrayOfScope);
  }
  
  public AuthAccountRequest[] zzbB(int paramInt)
  {
    return new AuthAccountRequest[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */