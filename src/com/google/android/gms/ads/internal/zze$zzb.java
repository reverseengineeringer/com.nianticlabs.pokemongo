package com.google.android.gms.ads.internal;

import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhs.zza;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zziz;

@zzgr
public class zze$zzb
  implements zze.zza
{
  private final zzhs.zza zzoL;
  private final zziz zzoM;
  
  public zze$zzb(zzhs.zza paramzza, zziz paramzziz)
  {
    zzoL = paramzza;
    zzoM = paramzziz;
  }
  
  public void zzq(String paramString)
  {
    zzb.zzaF("An auto-clicking creative is blocked");
    Uri.Builder localBuilder = new Uri.Builder();
    localBuilder.scheme("https");
    localBuilder.path("//pagead2.googlesyndication.com/pagead/gen_204");
    localBuilder.appendQueryParameter("id", "gmob-apps-blocked-navigation");
    if (!TextUtils.isEmpty(paramString)) {
      localBuilder.appendQueryParameter("navigationURL", paramString);
    }
    if ((zzoL != null) && (zzoL.zzHD != null) && (!TextUtils.isEmpty(zzoL.zzHD.zzEP))) {
      localBuilder.appendQueryParameter("debugDialog", zzoL.zzHD.zzEP);
    }
    zzp.zzbv().zzc(zzoM.getContext(), zzoM.zzhh().zzJu, localBuilder.toString());
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zze.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */