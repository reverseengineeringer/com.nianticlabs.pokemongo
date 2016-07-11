package com.google.android.gms.ads.internal.purchase;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza
  implements Parcelable.Creator<GInAppPurchaseManagerInfoParcel>
{
  static void zza(GInAppPurchaseManagerInfoParcel paramGInAppPurchaseManagerInfoParcel, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zza(paramParcel, 3, paramGInAppPurchaseManagerInfoParcel.zzfj(), false);
    zzb.zza(paramParcel, 4, paramGInAppPurchaseManagerInfoParcel.zzfk(), false);
    zzb.zza(paramParcel, 5, paramGInAppPurchaseManagerInfoParcel.zzfl(), false);
    zzb.zza(paramParcel, 6, paramGInAppPurchaseManagerInfoParcel.zzfi(), false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public GInAppPurchaseManagerInfoParcel zzh(Parcel paramParcel)
  {
    IBinder localIBinder1 = null;
    int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(paramParcel);
    int i = 0;
    IBinder localIBinder2 = null;
    IBinder localIBinder3 = null;
    IBinder localIBinder4 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zza.zzao(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(k))
      {
      case 2: 
      default: 
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, k);
        break;
      case 1: 
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, k);
        break;
      case 3: 
        localIBinder4 = com.google.android.gms.common.internal.safeparcel.zza.zzq(paramParcel, k);
        break;
      case 4: 
        localIBinder3 = com.google.android.gms.common.internal.safeparcel.zza.zzq(paramParcel, k);
        break;
      case 5: 
        localIBinder2 = com.google.android.gms.common.internal.safeparcel.zza.zzq(paramParcel, k);
        break;
      case 6: 
        localIBinder1 = com.google.android.gms.common.internal.safeparcel.zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new GInAppPurchaseManagerInfoParcel(i, localIBinder4, localIBinder3, localIBinder2, localIBinder1);
  }
  
  public GInAppPurchaseManagerInfoParcel[] zzx(int paramInt)
  {
    return new GInAppPurchaseManagerInfoParcel[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.purchase.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */