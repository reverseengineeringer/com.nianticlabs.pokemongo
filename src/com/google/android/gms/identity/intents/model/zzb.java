package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public class zzb
  implements Parcelable.Creator<UserAddress>
{
  static void zza(UserAddress paramUserAddress, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.zzb.zzaq(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, paramUserAddress.getVersionCode());
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, name, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, zzaDk, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 4, zzaDl, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 5, zzaDm, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 6, zzaDn, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 7, zzaDo, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 8, zzaDp, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 9, zzaDq, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 10, zzGw, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 11, zzaDr, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 12, zzaDs, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 13, phoneNumber, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 14, zzaDt);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 15, zzaDu, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 16, zzaDv, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzI(paramParcel, paramInt);
  }
  
  public UserAddress zzex(Parcel paramParcel)
  {
    int j = zza.zzap(paramParcel);
    int i = 0;
    String str14 = null;
    String str13 = null;
    String str12 = null;
    String str11 = null;
    String str10 = null;
    String str9 = null;
    String str8 = null;
    String str7 = null;
    String str6 = null;
    String str5 = null;
    String str4 = null;
    String str3 = null;
    boolean bool = false;
    String str2 = null;
    String str1 = null;
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
        str14 = zza.zzp(paramParcel, k);
        break;
      case 3: 
        str13 = zza.zzp(paramParcel, k);
        break;
      case 4: 
        str12 = zza.zzp(paramParcel, k);
        break;
      case 5: 
        str11 = zza.zzp(paramParcel, k);
        break;
      case 6: 
        str10 = zza.zzp(paramParcel, k);
        break;
      case 7: 
        str9 = zza.zzp(paramParcel, k);
        break;
      case 8: 
        str8 = zza.zzp(paramParcel, k);
        break;
      case 9: 
        str7 = zza.zzp(paramParcel, k);
        break;
      case 10: 
        str6 = zza.zzp(paramParcel, k);
        break;
      case 11: 
        str5 = zza.zzp(paramParcel, k);
        break;
      case 12: 
        str4 = zza.zzp(paramParcel, k);
        break;
      case 13: 
        str3 = zza.zzp(paramParcel, k);
        break;
      case 14: 
        bool = zza.zzc(paramParcel, k);
        break;
      case 15: 
        str2 = zza.zzp(paramParcel, k);
        break;
      case 16: 
        str1 = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new UserAddress(i, str14, str13, str12, str11, str10, str9, str8, str7, str6, str5, str4, str3, bool, str2, str1);
  }
  
  public UserAddress[] zzgH(int paramInt)
  {
    return new UserAddress[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.identity.intents.model.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */