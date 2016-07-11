package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzd.zza;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzdg;
import com.google.android.gms.internal.zzdm;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zziz;

@zzgr
public final class AdOverlayInfoParcel
  implements SafeParcelable
{
  public static final zzf CREATOR = new zzf();
  public final int orientation;
  public final String url;
  public final int versionCode;
  public final AdLauncherIntentInfoParcel zzBA;
  public final zza zzBB;
  public final zzg zzBC;
  public final zziz zzBD;
  public final zzdg zzBE;
  public final String zzBF;
  public final boolean zzBG;
  public final String zzBH;
  public final zzn zzBI;
  public final int zzBJ;
  public final zzdm zzBK;
  public final String zzBL;
  public final InterstitialAdParameterParcel zzBM;
  public final VersionInfoParcel zzqj;
  
  AdOverlayInfoParcel(int paramInt1, AdLauncherIntentInfoParcel paramAdLauncherIntentInfoParcel, IBinder paramIBinder1, IBinder paramIBinder2, IBinder paramIBinder3, IBinder paramIBinder4, String paramString1, boolean paramBoolean, String paramString2, IBinder paramIBinder5, int paramInt2, int paramInt3, String paramString3, VersionInfoParcel paramVersionInfoParcel, IBinder paramIBinder6, String paramString4, InterstitialAdParameterParcel paramInterstitialAdParameterParcel)
  {
    versionCode = paramInt1;
    zzBA = paramAdLauncherIntentInfoParcel;
    zzBB = ((zza)zze.zzp(zzd.zza.zzbk(paramIBinder1)));
    zzBC = ((zzg)zze.zzp(zzd.zza.zzbk(paramIBinder2)));
    zzBD = ((zziz)zze.zzp(zzd.zza.zzbk(paramIBinder3)));
    zzBE = ((zzdg)zze.zzp(zzd.zza.zzbk(paramIBinder4)));
    zzBF = paramString1;
    zzBG = paramBoolean;
    zzBH = paramString2;
    zzBI = ((zzn)zze.zzp(zzd.zza.zzbk(paramIBinder5)));
    orientation = paramInt2;
    zzBJ = paramInt3;
    url = paramString3;
    zzqj = paramVersionInfoParcel;
    zzBK = ((zzdm)zze.zzp(zzd.zza.zzbk(paramIBinder6)));
    zzBL = paramString4;
    zzBM = paramInterstitialAdParameterParcel;
  }
  
  public AdOverlayInfoParcel(zza paramzza, zzg paramzzg, zzn paramzzn, zziz paramzziz, int paramInt, VersionInfoParcel paramVersionInfoParcel, String paramString, InterstitialAdParameterParcel paramInterstitialAdParameterParcel)
  {
    versionCode = 4;
    zzBA = null;
    zzBB = paramzza;
    zzBC = paramzzg;
    zzBD = paramzziz;
    zzBE = null;
    zzBF = null;
    zzBG = false;
    zzBH = null;
    zzBI = paramzzn;
    orientation = paramInt;
    zzBJ = 1;
    url = null;
    zzqj = paramVersionInfoParcel;
    zzBK = null;
    zzBL = paramString;
    zzBM = paramInterstitialAdParameterParcel;
  }
  
  public AdOverlayInfoParcel(zza paramzza, zzg paramzzg, zzn paramzzn, zziz paramzziz, boolean paramBoolean, int paramInt, VersionInfoParcel paramVersionInfoParcel)
  {
    versionCode = 4;
    zzBA = null;
    zzBB = paramzza;
    zzBC = paramzzg;
    zzBD = paramzziz;
    zzBE = null;
    zzBF = null;
    zzBG = paramBoolean;
    zzBH = null;
    zzBI = paramzzn;
    orientation = paramInt;
    zzBJ = 2;
    url = null;
    zzqj = paramVersionInfoParcel;
    zzBK = null;
    zzBL = null;
    zzBM = null;
  }
  
  public AdOverlayInfoParcel(zza paramzza, zzg paramzzg, zzdg paramzzdg, zzn paramzzn, zziz paramzziz, boolean paramBoolean, int paramInt, String paramString, VersionInfoParcel paramVersionInfoParcel, zzdm paramzzdm)
  {
    versionCode = 4;
    zzBA = null;
    zzBB = paramzza;
    zzBC = paramzzg;
    zzBD = paramzziz;
    zzBE = paramzzdg;
    zzBF = null;
    zzBG = paramBoolean;
    zzBH = null;
    zzBI = paramzzn;
    orientation = paramInt;
    zzBJ = 3;
    url = paramString;
    zzqj = paramVersionInfoParcel;
    zzBK = paramzzdm;
    zzBL = null;
    zzBM = null;
  }
  
  public AdOverlayInfoParcel(zza paramzza, zzg paramzzg, zzdg paramzzdg, zzn paramzzn, zziz paramzziz, boolean paramBoolean, int paramInt, String paramString1, String paramString2, VersionInfoParcel paramVersionInfoParcel, zzdm paramzzdm)
  {
    versionCode = 4;
    zzBA = null;
    zzBB = paramzza;
    zzBC = paramzzg;
    zzBD = paramzziz;
    zzBE = paramzzdg;
    zzBF = paramString2;
    zzBG = paramBoolean;
    zzBH = paramString1;
    zzBI = paramzzn;
    orientation = paramInt;
    zzBJ = 3;
    url = null;
    zzqj = paramVersionInfoParcel;
    zzBK = paramzzdm;
    zzBL = null;
    zzBM = null;
  }
  
  public AdOverlayInfoParcel(AdLauncherIntentInfoParcel paramAdLauncherIntentInfoParcel, zza paramzza, zzg paramzzg, zzn paramzzn, VersionInfoParcel paramVersionInfoParcel)
  {
    versionCode = 4;
    zzBA = paramAdLauncherIntentInfoParcel;
    zzBB = paramzza;
    zzBC = paramzzg;
    zzBD = null;
    zzBE = null;
    zzBF = null;
    zzBG = false;
    zzBH = null;
    zzBI = paramzzn;
    orientation = -1;
    zzBJ = 4;
    url = null;
    zzqj = paramVersionInfoParcel;
    zzBK = null;
    zzBL = null;
    zzBM = null;
  }
  
  public static void zza(Intent paramIntent, AdOverlayInfoParcel paramAdOverlayInfoParcel)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", paramAdOverlayInfoParcel);
    paramIntent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", localBundle);
  }
  
  public static AdOverlayInfoParcel zzb(Intent paramIntent)
  {
    try
    {
      paramIntent = paramIntent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
      paramIntent.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
      paramIntent = (AdOverlayInfoParcel)paramIntent.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
      return paramIntent;
    }
    catch (Exception paramIntent) {}
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzeK()
  {
    return zze.zzy(zzBB).asBinder();
  }
  
  IBinder zzeL()
  {
    return zze.zzy(zzBC).asBinder();
  }
  
  IBinder zzeM()
  {
    return zze.zzy(zzBD).asBinder();
  }
  
  IBinder zzeN()
  {
    return zze.zzy(zzBE).asBinder();
  }
  
  IBinder zzeO()
  {
    return zze.zzy(zzBK).asBinder();
  }
  
  IBinder zzeP()
  {
    return zze.zzy(zzBI).asBinder();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */