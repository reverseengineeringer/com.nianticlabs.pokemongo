package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;

@zzgr
public class zzgi
  extends zzgc
  implements zzja.zza
{
  zzgi(Context paramContext, zzhs.zza paramzza, zziz paramzziz, zzgg.zza paramzza1)
  {
    super(paramContext, paramzza, paramzziz, paramzza1);
  }
  
  protected void zzfs()
  {
    if (zzDf.errorCode != -2) {
      return;
    }
    zzoM.zzhe().zza(this);
    zzfz();
    zzb.v("Loading HTML in WebView.");
    zzoM.loadDataWithBaseURL(zzp.zzbv().zzaz(zzDf.zzBF), zzDf.body, "text/html", "UTF-8", null);
  }
  
  protected void zzfz() {}
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */