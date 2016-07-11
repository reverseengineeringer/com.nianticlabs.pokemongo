package com.google.android.gms.ads.internal.overlay;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf
  implements Parcelable.Creator<AdOverlayInfoParcel>
{
  static void zza(AdOverlayInfoParcel paramAdOverlayInfoParcel, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zza(paramParcel, 2, zzBA, paramInt, false);
    zzb.zza(paramParcel, 3, paramAdOverlayInfoParcel.zzeK(), false);
    zzb.zza(paramParcel, 4, paramAdOverlayInfoParcel.zzeL(), false);
    zzb.zza(paramParcel, 5, paramAdOverlayInfoParcel.zzeM(), false);
    zzb.zza(paramParcel, 6, paramAdOverlayInfoParcel.zzeN(), false);
    zzb.zza(paramParcel, 7, zzBF, false);
    zzb.zza(paramParcel, 8, zzBG);
    zzb.zza(paramParcel, 9, zzBH, false);
    zzb.zza(paramParcel, 10, paramAdOverlayInfoParcel.zzeP(), false);
    zzb.zzc(paramParcel, 11, orientation);
    zzb.zzc(paramParcel, 12, zzBJ);
    zzb.zza(paramParcel, 13, url, false);
    zzb.zza(paramParcel, 14, zzqj, paramInt, false);
    zzb.zza(paramParcel, 15, paramAdOverlayInfoParcel.zzeO(), false);
    zzb.zza(paramParcel, 17, zzBM, paramInt, false);
    zzb.zza(paramParcel, 16, zzBL, false);
    zzb.zzI(paramParcel, i);
  }
  
  public AdOverlayInfoParcel zzg(Parcel paramParcel)
  {
    int m = zza.zzap(paramParcel);
    int k = 0;
    AdLauncherIntentInfoParcel localAdLauncherIntentInfoParcel = null;
    IBinder localIBinder6 = null;
    IBinder localIBinder5 = null;
    IBinder localIBinder4 = null;
    IBinder localIBinder3 = null;
    String str4 = null;
    boolean bool = false;
    String str3 = null;
    IBinder localIBinder2 = null;
    int j = 0;
    int i = 0;
    String str2 = null;
    VersionInfoParcel localVersionInfoParcel = null;
    IBinder localIBinder1 = null;
    String str1 = null;
    InterstitialAdParameterParcel localInterstitialAdParameterParcel = null;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzao(paramParcel);
      switch (zza.zzbM(n))
      {
      default: 
        zza.zzb(paramParcel, n);
        break;
      case 1: 
        k = zza.zzg(paramParcel, n);
        break;
      case 2: 
        localAdLauncherIntentInfoParcel = (AdLauncherIntentInfoParcel)zza.zza(paramParcel, n, AdLauncherIntentInfoParcel.CREATOR);
        break;
      case 3: 
        localIBinder6 = zza.zzq(paramParcel, n);
        break;
      case 4: 
        localIBinder5 = zza.zzq(paramParcel, n);
        break;
      case 5: 
        localIBinder4 = zza.zzq(paramParcel, n);
        break;
      case 6: 
        localIBinder3 = zza.zzq(paramParcel, n);
        break;
      case 7: 
        str4 = zza.zzp(paramParcel, n);
        break;
      case 8: 
        bool = zza.zzc(paramParcel, n);
        break;
      case 9: 
        str3 = zza.zzp(paramParcel, n);
        break;
      case 10: 
        localIBinder2 = zza.zzq(paramParcel, n);
        break;
      case 11: 
        j = zza.zzg(paramParcel, n);
        break;
      case 12: 
        i = zza.zzg(paramParcel, n);
        break;
      case 13: 
        str2 = zza.zzp(paramParcel, n);
        break;
      case 14: 
        localVersionInfoParcel = (VersionInfoParcel)zza.zza(paramParcel, n, VersionInfoParcel.CREATOR);
        break;
      case 15: 
        localIBinder1 = zza.zzq(paramParcel, n);
        break;
      case 17: 
        localInterstitialAdParameterParcel = (InterstitialAdParameterParcel)zza.zza(paramParcel, n, InterstitialAdParameterParcel.CREATOR);
        break;
      case 16: 
        str1 = zza.zzp(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new AdOverlayInfoParcel(k, localAdLauncherIntentInfoParcel, localIBinder6, localIBinder5, localIBinder4, localIBinder3, str4, bool, str3, localIBinder2, j, i, str2, localVersionInfoParcel, localIBinder1, str1, localInterstitialAdParameterParcel);
  }
  
  public AdOverlayInfoParcel[] zzw(int paramInt)
  {
    return new AdOverlayInfoParcel[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */