package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze
  implements Parcelable.Creator<PlayLoggerContext>
{
  static void zza(PlayLoggerContext paramPlayLoggerContext, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zza(paramParcel, 2, packageName, false);
    zzb.zzc(paramParcel, 3, zzaRR);
    zzb.zzc(paramParcel, 4, zzaRS);
    zzb.zza(paramParcel, 5, zzaRT, false);
    zzb.zza(paramParcel, 6, zzaRU, false);
    zzb.zza(paramParcel, 7, zzaRV);
    zzb.zza(paramParcel, 8, zzaRW, false);
    zzb.zza(paramParcel, 9, zzaRX);
    zzb.zzc(paramParcel, 10, zzaRY);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public PlayLoggerContext zzgj(Parcel paramParcel)
  {
    String str1 = null;
    int i = 0;
    int n = zza.zzap(paramParcel);
    boolean bool2 = true;
    boolean bool1 = false;
    String str2 = null;
    String str3 = null;
    int j = 0;
    int k = 0;
    String str4 = null;
    int m = 0;
    while (paramParcel.dataPosition() < n)
    {
      int i1 = zza.zzao(paramParcel);
      switch (zza.zzbM(i1))
      {
      default: 
        zza.zzb(paramParcel, i1);
        break;
      case 1: 
        m = zza.zzg(paramParcel, i1);
        break;
      case 2: 
        str4 = zza.zzp(paramParcel, i1);
        break;
      case 3: 
        k = zza.zzg(paramParcel, i1);
        break;
      case 4: 
        j = zza.zzg(paramParcel, i1);
        break;
      case 5: 
        str3 = zza.zzp(paramParcel, i1);
        break;
      case 6: 
        str2 = zza.zzp(paramParcel, i1);
        break;
      case 7: 
        bool2 = zza.zzc(paramParcel, i1);
        break;
      case 8: 
        str1 = zza.zzp(paramParcel, i1);
        break;
      case 9: 
        bool1 = zza.zzc(paramParcel, i1);
        break;
      case 10: 
        i = zza.zzg(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != n) {
      throw new zza.zza("Overread allowed size end=" + n, paramParcel);
    }
    return new PlayLoggerContext(m, str4, k, j, str3, str2, bool2, str1, bool1, i);
  }
  
  public PlayLoggerContext[] zziV(int paramInt)
  {
    return new PlayLoggerContext[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.playlog.internal.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */