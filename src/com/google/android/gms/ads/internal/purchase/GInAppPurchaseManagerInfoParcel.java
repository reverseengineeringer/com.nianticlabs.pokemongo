package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzd.zza;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzfr;
import com.google.android.gms.internal.zzgr;

@zzgr
public final class GInAppPurchaseManagerInfoParcel
  implements SafeParcelable
{
  public static final zza CREATOR = new zza();
  public final int versionCode;
  public final zzfr zzCw;
  public final Context zzCx;
  public final zzj zzCy;
  public final zzk zzqE;
  
  GInAppPurchaseManagerInfoParcel(int paramInt, IBinder paramIBinder1, IBinder paramIBinder2, IBinder paramIBinder3, IBinder paramIBinder4)
  {
    versionCode = paramInt;
    zzqE = ((zzk)zze.zzp(zzd.zza.zzbk(paramIBinder1)));
    zzCw = ((zzfr)zze.zzp(zzd.zza.zzbk(paramIBinder2)));
    zzCx = ((Context)zze.zzp(zzd.zza.zzbk(paramIBinder3)));
    zzCy = ((zzj)zze.zzp(zzd.zza.zzbk(paramIBinder4)));
  }
  
  public GInAppPurchaseManagerInfoParcel(Context paramContext, zzk paramzzk, zzfr paramzzfr, zzj paramzzj)
  {
    versionCode = 2;
    zzCx = paramContext;
    zzqE = paramzzk;
    zzCw = paramzzfr;
    zzCy = paramzzj;
  }
  
  public static void zza(Intent paramIntent, GInAppPurchaseManagerInfoParcel paramGInAppPurchaseManagerInfoParcel)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", paramGInAppPurchaseManagerInfoParcel);
    paramIntent.putExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", localBundle);
  }
  
  public static GInAppPurchaseManagerInfoParcel zzc(Intent paramIntent)
  {
    try
    {
      paramIntent = paramIntent.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
      paramIntent.setClassLoader(GInAppPurchaseManagerInfoParcel.class.getClassLoader());
      paramIntent = (GInAppPurchaseManagerInfoParcel)paramIntent.getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
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
    zza.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzfi()
  {
    return zze.zzy(zzCy).asBinder();
  }
  
  IBinder zzfj()
  {
    return zze.zzy(zzqE).asBinder();
  }
  
  IBinder zzfk()
  {
    return zze.zzy(zzCw).asBinder();
  }
  
  IBinder zzfl()
  {
    return zze.zzy(zzCx).asBinder();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.purchase.GInAppPurchaseManagerInfoParcel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */