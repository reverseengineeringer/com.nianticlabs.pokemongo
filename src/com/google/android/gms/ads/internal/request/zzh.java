package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzh
  implements Parcelable.Creator<AdResponseParcel>
{
  static void zza(AdResponseParcel paramAdResponseParcel, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zza(paramParcel, 2, zzBF, false);
    zzb.zza(paramParcel, 3, body, false);
    zzb.zzb(paramParcel, 4, zzyY, false);
    zzb.zzc(paramParcel, 5, errorCode);
    zzb.zzb(paramParcel, 6, zzyZ, false);
    zzb.zza(paramParcel, 7, zzEJ);
    zzb.zza(paramParcel, 8, zzEK);
    zzb.zza(paramParcel, 9, zzEL);
    zzb.zzb(paramParcel, 10, zzEM, false);
    zzb.zza(paramParcel, 11, zzzc);
    zzb.zzc(paramParcel, 12, orientation);
    zzb.zza(paramParcel, 13, zzEN, false);
    zzb.zza(paramParcel, 14, zzEO);
    zzb.zza(paramParcel, 15, zzEP, false);
    zzb.zza(paramParcel, 19, zzER, false);
    zzb.zza(paramParcel, 18, zzEQ);
    zzb.zza(paramParcel, 21, zzES, false);
    zzb.zza(paramParcel, 23, zzth);
    zzb.zza(paramParcel, 22, zzET);
    zzb.zza(paramParcel, 25, zzEU);
    zzb.zza(paramParcel, 24, zzEv);
    zzb.zzc(paramParcel, 27, zzEW);
    zzb.zza(paramParcel, 26, zzEV);
    zzb.zza(paramParcel, 29, zzEY, false);
    zzb.zza(paramParcel, 28, zzEX, paramInt, false);
    zzb.zza(paramParcel, 31, zzti);
    zzb.zza(paramParcel, 30, zzEZ, false);
    zzb.zzI(paramParcel, i);
  }
  
  public AdResponseParcel[] zzE(int paramInt)
  {
    return new AdResponseParcel[paramInt];
  }
  
  public AdResponseParcel zzj(Parcel paramParcel)
  {
    int n = zza.zzap(paramParcel);
    int m = 0;
    String str8 = null;
    String str7 = null;
    ArrayList localArrayList3 = null;
    int k = 0;
    ArrayList localArrayList2 = null;
    long l4 = 0L;
    boolean bool8 = false;
    long l3 = 0L;
    ArrayList localArrayList1 = null;
    long l2 = 0L;
    int j = 0;
    String str6 = null;
    long l1 = 0L;
    String str5 = null;
    boolean bool7 = false;
    String str4 = null;
    String str3 = null;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    int i = 0;
    LargeParcelTeleporter localLargeParcelTeleporter = null;
    String str2 = null;
    String str1 = null;
    boolean bool1 = false;
    while (paramParcel.dataPosition() < n)
    {
      int i1 = zza.zzao(paramParcel);
      switch (zza.zzbM(i1))
      {
      case 16: 
      case 17: 
      case 20: 
      default: 
        zza.zzb(paramParcel, i1);
        break;
      case 1: 
        m = zza.zzg(paramParcel, i1);
        break;
      case 2: 
        str8 = zza.zzp(paramParcel, i1);
        break;
      case 3: 
        str7 = zza.zzp(paramParcel, i1);
        break;
      case 4: 
        localArrayList3 = zza.zzD(paramParcel, i1);
        break;
      case 5: 
        k = zza.zzg(paramParcel, i1);
        break;
      case 6: 
        localArrayList2 = zza.zzD(paramParcel, i1);
        break;
      case 7: 
        l4 = zza.zzi(paramParcel, i1);
        break;
      case 8: 
        bool8 = zza.zzc(paramParcel, i1);
        break;
      case 9: 
        l3 = zza.zzi(paramParcel, i1);
        break;
      case 10: 
        localArrayList1 = zza.zzD(paramParcel, i1);
        break;
      case 11: 
        l2 = zza.zzi(paramParcel, i1);
        break;
      case 12: 
        j = zza.zzg(paramParcel, i1);
        break;
      case 13: 
        str6 = zza.zzp(paramParcel, i1);
        break;
      case 14: 
        l1 = zza.zzi(paramParcel, i1);
        break;
      case 15: 
        str5 = zza.zzp(paramParcel, i1);
        break;
      case 19: 
        str4 = zza.zzp(paramParcel, i1);
        break;
      case 18: 
        bool7 = zza.zzc(paramParcel, i1);
        break;
      case 21: 
        str3 = zza.zzp(paramParcel, i1);
        break;
      case 23: 
        bool5 = zza.zzc(paramParcel, i1);
        break;
      case 22: 
        bool6 = zza.zzc(paramParcel, i1);
        break;
      case 25: 
        bool3 = zza.zzc(paramParcel, i1);
        break;
      case 24: 
        bool4 = zza.zzc(paramParcel, i1);
        break;
      case 27: 
        i = zza.zzg(paramParcel, i1);
        break;
      case 26: 
        bool2 = zza.zzc(paramParcel, i1);
        break;
      case 29: 
        str2 = zza.zzp(paramParcel, i1);
        break;
      case 28: 
        localLargeParcelTeleporter = (LargeParcelTeleporter)zza.zza(paramParcel, i1, LargeParcelTeleporter.CREATOR);
        break;
      case 31: 
        bool1 = zza.zzc(paramParcel, i1);
        break;
      case 30: 
        str1 = zza.zzp(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != n) {
      throw new zza.zza("Overread allowed size end=" + n, paramParcel);
    }
    return new AdResponseParcel(m, str8, str7, localArrayList3, k, localArrayList2, l4, bool8, l3, localArrayList1, l2, j, str6, l1, str5, bool7, str4, str3, bool6, bool5, bool4, bool3, bool2, i, localLargeParcelTeleporter, str2, str1, bool1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.zzh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */