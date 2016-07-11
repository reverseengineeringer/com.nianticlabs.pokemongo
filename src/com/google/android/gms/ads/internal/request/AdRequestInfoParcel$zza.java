package com.google.android.gms.ads.internal.request;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzgr;
import java.util.List;

@zzgr
public final class AdRequestInfoParcel$zza
{
  public final ApplicationInfo applicationInfo;
  public final String zzEA;
  public final long zzEB;
  public final String zzEC;
  public final List<String> zzED;
  public final List<String> zzEE;
  public final CapabilityParcel zzEG;
  public final String zzEH;
  public final Bundle zzEm;
  public final AdRequestParcel zzEn;
  public final PackageInfo zzEo;
  public final String zzEq;
  public final String zzEr;
  public final Bundle zzEs;
  public final int zzEt;
  public final Bundle zzEu;
  public final boolean zzEv;
  public final Messenger zzEw;
  public final int zzEx;
  public final int zzEy;
  public final float zzEz;
  public final NativeAdOptionsParcel zzqB;
  public final List<String> zzqD;
  public final String zzqg;
  public final String zzqh;
  public final VersionInfoParcel zzqj;
  public final AdSizeParcel zzqn;
  
  public AdRequestInfoParcel$zza(Bundle paramBundle1, AdRequestParcel paramAdRequestParcel, AdSizeParcel paramAdSizeParcel, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, VersionInfoParcel paramVersionInfoParcel, Bundle paramBundle2, List<String> paramList1, List<String> paramList2, Bundle paramBundle3, boolean paramBoolean, Messenger paramMessenger, int paramInt1, int paramInt2, float paramFloat, String paramString4, long paramLong, String paramString5, List<String> paramList3, String paramString6, NativeAdOptionsParcel paramNativeAdOptionsParcel, CapabilityParcel paramCapabilityParcel, String paramString7)
  {
    zzEm = paramBundle1;
    zzEn = paramAdRequestParcel;
    zzqn = paramAdSizeParcel;
    zzqh = paramString1;
    applicationInfo = paramApplicationInfo;
    zzEo = paramPackageInfo;
    zzEq = paramString2;
    zzEr = paramString3;
    zzqj = paramVersionInfoParcel;
    zzEs = paramBundle2;
    zzEv = paramBoolean;
    zzEw = paramMessenger;
    zzEx = paramInt1;
    zzEy = paramInt2;
    zzEz = paramFloat;
    if ((paramList1 != null) && (paramList1.size() > 0))
    {
      zzEt = 3;
      zzqD = paramList1;
    }
    for (zzEE = paramList2;; zzEE = null)
    {
      zzEu = paramBundle3;
      zzEA = paramString4;
      zzEB = paramLong;
      zzEC = paramString5;
      zzED = paramList3;
      zzqg = paramString6;
      zzqB = paramNativeAdOptionsParcel;
      zzEG = paramCapabilityParcel;
      zzEH = paramString7;
      return;
      zzEt = 0;
      zzqD = null;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.AdRequestInfoParcel.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */