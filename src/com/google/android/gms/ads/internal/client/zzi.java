package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi
  implements Parcelable.Creator<AdSizeParcel>
{
  static void zza(AdSizeParcel paramAdSizeParcel, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zza(paramParcel, 2, zzte, false);
    zzb.zzc(paramParcel, 3, height);
    zzb.zzc(paramParcel, 4, heightPixels);
    zzb.zza(paramParcel, 5, zztf);
    zzb.zzc(paramParcel, 6, width);
    zzb.zzc(paramParcel, 7, widthPixels);
    zzb.zza(paramParcel, 8, zztg, paramInt, false);
    zzb.zza(paramParcel, 9, zzth);
    zzb.zza(paramParcel, 10, zzti);
    zzb.zzI(paramParcel, i);
  }
  
  public AdSizeParcel zzc(Parcel paramParcel)
  {
    AdSizeParcel[] arrayOfAdSizeParcel = null;
    boolean bool1 = false;
    int i1 = zza.zzap(paramParcel);
    boolean bool2 = false;
    int i = 0;
    int j = 0;
    boolean bool3 = false;
    int k = 0;
    int m = 0;
    String str = null;
    int n = 0;
    while (paramParcel.dataPosition() < i1)
    {
      int i2 = zza.zzao(paramParcel);
      switch (zza.zzbM(i2))
      {
      default: 
        zza.zzb(paramParcel, i2);
        break;
      case 1: 
        n = zza.zzg(paramParcel, i2);
        break;
      case 2: 
        str = zza.zzp(paramParcel, i2);
        break;
      case 3: 
        m = zza.zzg(paramParcel, i2);
        break;
      case 4: 
        k = zza.zzg(paramParcel, i2);
        break;
      case 5: 
        bool3 = zza.zzc(paramParcel, i2);
        break;
      case 6: 
        j = zza.zzg(paramParcel, i2);
        break;
      case 7: 
        i = zza.zzg(paramParcel, i2);
        break;
      case 8: 
        arrayOfAdSizeParcel = (AdSizeParcel[])zza.zzb(paramParcel, i2, AdSizeParcel.CREATOR);
        break;
      case 9: 
        bool2 = zza.zzc(paramParcel, i2);
        break;
      case 10: 
        bool1 = zza.zzc(paramParcel, i2);
      }
    }
    if (paramParcel.dataPosition() != i1) {
      throw new zza.zza("Overread allowed size end=" + i1, paramParcel);
    }
    return new AdSizeParcel(n, str, m, k, bool3, j, i, arrayOfAdSizeParcel, bool2, bool1);
  }
  
  public AdSizeParcel[] zzl(int paramInt)
  {
    return new AdSizeParcel[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zzi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */