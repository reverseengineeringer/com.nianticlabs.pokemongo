package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;

final class zzgt$2
  implements Runnable
{
  zzgt$2(Context paramContext, AdRequestInfoParcel paramAdRequestInfoParcel, zzgv paramzzgv, zzcg paramzzcg, zzce paramzzce, String paramString, zzbr paramzzbr) {}
  
  public void run()
  {
    zziz localzziz = zzp.zzbw().zza(zzry, new AdSizeParcel(), false, false, null, zzFJ.zzqj);
    if (zzp.zzby().zzgu()) {
      localzziz.clearCache(true);
    }
    localzziz.getWebView().setWillNotDraw(true);
    zzFE.zze(localzziz);
    zzoD.zza(zzFF, new String[] { "rwc" });
    Object localObject = zzoD.zzdn();
    localObject = zzgt.zzb(zzFG, zzoD, (zzce)localObject);
    zzja localzzja = localzziz.zzhe();
    localzzja.zza("/invalidRequest", zzFE.zzFR);
    localzzja.zza("/loadAdURL", zzFE.zzFS);
    localzzja.zza("/log", zzdj.zzxv);
    localzzja.zza((zzja.zza)localObject);
    zzb.zzaF("Loading the JS library.");
    localzziz.loadUrl(zzFK.zzdc());
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgt.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */