package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public class zzb
  implements Parcelable.Creator<ProxyRequest>
{
  static void zza(ProxyRequest paramProxyRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.zzb.zzaq(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 1, url, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1000, versionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 2, httpMethod);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, timeoutMillis);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 4, body, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 5, zzSK, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzI(paramParcel, paramInt);
  }
  
  public ProxyRequest zzM(Parcel paramParcel)
  {
    int i = 0;
    Bundle localBundle = null;
    int k = zza.zzap(paramParcel);
    long l = 0L;
    byte[] arrayOfByte = null;
    String str = null;
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
        str = zza.zzp(paramParcel, m);
        break;
      case 1000: 
        j = zza.zzg(paramParcel, m);
        break;
      case 2: 
        i = zza.zzg(paramParcel, m);
        break;
      case 3: 
        l = zza.zzi(paramParcel, m);
        break;
      case 4: 
        arrayOfByte = zza.zzs(paramParcel, m);
        break;
      case 5: 
        localBundle = zza.zzr(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new ProxyRequest(j, str, i, l, arrayOfByte, localBundle);
  }
  
  public ProxyRequest[] zzaD(int paramInt)
  {
    return new ProxyRequest[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.proxy.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */