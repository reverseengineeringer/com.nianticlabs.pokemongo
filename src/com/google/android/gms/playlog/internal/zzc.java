package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc
  implements Parcelable.Creator<LogEvent>
{
  static void zza(LogEvent paramLogEvent, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zza(paramParcel, 2, zzaRG);
    zzb.zza(paramParcel, 3, tag, false);
    zzb.zza(paramParcel, 4, zzaRI, false);
    zzb.zza(paramParcel, 5, zzaRJ, false);
    zzb.zza(paramParcel, 6, zzaRH);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public LogEvent zzgi(Parcel paramParcel)
  {
    long l1 = 0L;
    Bundle localBundle = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    byte[] arrayOfByte = null;
    String str = null;
    long l2 = 0L;
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
        l2 = zza.zzi(paramParcel, k);
        break;
      case 3: 
        str = zza.zzp(paramParcel, k);
        break;
      case 4: 
        arrayOfByte = zza.zzs(paramParcel, k);
        break;
      case 5: 
        localBundle = zza.zzr(paramParcel, k);
        break;
      case 6: 
        l1 = zza.zzi(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new LogEvent(i, l2, l1, str, arrayOfByte, localBundle);
  }
  
  public LogEvent[] zziU(int paramInt)
  {
    return new LogEvent[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.playlog.internal.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */