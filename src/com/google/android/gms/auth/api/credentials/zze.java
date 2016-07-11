package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zze
  implements Parcelable.Creator<PasswordSpecification>
{
  static void zza(PasswordSpecification paramPasswordSpecification, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, zzSv, false);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zzb(paramParcel, 2, zzSw, false);
    zzb.zza(paramParcel, 3, zzSx, false);
    zzb.zzc(paramParcel, 4, zzSy);
    zzb.zzc(paramParcel, 5, zzSz);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public PasswordSpecification zzI(Parcel paramParcel)
  {
    ArrayList localArrayList1 = null;
    int i = 0;
    int m = zza.zzap(paramParcel);
    int j = 0;
    ArrayList localArrayList2 = null;
    String str = null;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzao(paramParcel);
      switch (zza.zzbM(n))
      {
      default: 
        zza.zzb(paramParcel, n);
        break;
      case 1: 
        str = zza.zzp(paramParcel, n);
        break;
      case 1000: 
        k = zza.zzg(paramParcel, n);
        break;
      case 2: 
        localArrayList2 = zza.zzD(paramParcel, n);
        break;
      case 3: 
        localArrayList1 = zza.zzC(paramParcel, n);
        break;
      case 4: 
        j = zza.zzg(paramParcel, n);
        break;
      case 5: 
        i = zza.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new PasswordSpecification(k, str, localArrayList2, localArrayList1, j, i);
  }
  
  public PasswordSpecification[] zzaz(int paramInt)
  {
    return new PasswordSpecification[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.credentials.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */