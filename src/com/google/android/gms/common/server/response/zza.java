package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.server.converter.ConverterWrapper;

public class zza
  implements Parcelable.Creator<FastJsonResponse.Field>
{
  static void zza(FastJsonResponse.Field paramField, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramField.getVersionCode());
    zzb.zzc(paramParcel, 2, paramField.zzpB());
    zzb.zza(paramParcel, 3, paramField.zzpH());
    zzb.zzc(paramParcel, 4, paramField.zzpC());
    zzb.zza(paramParcel, 5, paramField.zzpI());
    zzb.zza(paramParcel, 6, paramField.zzpJ(), false);
    zzb.zzc(paramParcel, 7, paramField.zzpK());
    zzb.zza(paramParcel, 8, paramField.zzpM(), false);
    zzb.zza(paramParcel, 9, paramField.zzpO(), paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public FastJsonResponse.Field zzav(Parcel paramParcel)
  {
    ConverterWrapper localConverterWrapper = null;
    int i = 0;
    int n = com.google.android.gms.common.internal.safeparcel.zza.zzap(paramParcel);
    String str1 = null;
    String str2 = null;
    boolean bool1 = false;
    int j = 0;
    boolean bool2 = false;
    int k = 0;
    int m = 0;
    while (paramParcel.dataPosition() < n)
    {
      int i1 = com.google.android.gms.common.internal.safeparcel.zza.zzao(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(i1))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, i1);
        break;
      case 1: 
        m = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, i1);
        break;
      case 2: 
        k = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, i1);
        break;
      case 3: 
        bool2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, i1);
        break;
      case 4: 
        j = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, i1);
        break;
      case 5: 
        bool1 = com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, i1);
        break;
      case 6: 
        str2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, i1);
        break;
      case 7: 
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, i1);
        break;
      case 8: 
        str1 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, i1);
        break;
      case 9: 
        localConverterWrapper = (ConverterWrapper)com.google.android.gms.common.internal.safeparcel.zza.zza(paramParcel, i1, ConverterWrapper.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != n) {
      throw new zza.zza("Overread allowed size end=" + n, paramParcel);
    }
    return new FastJsonResponse.Field(m, k, bool2, j, bool1, str2, i, str1, localConverterWrapper);
  }
  
  public FastJsonResponse.Field[] zzbT(int paramInt)
  {
    return new FastJsonResponse.Field[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.server.response.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */