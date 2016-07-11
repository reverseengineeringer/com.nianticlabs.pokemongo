package com.google.android.gms.ads.internal;

import android.graphics.Bitmap;
import android.os.Handler;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzhz;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zziz;

@zzgr
class zzk$zzb
  extends zzhz
{
  private final String zzpo;
  private final Bitmap zzpq;
  
  public zzk$zzb(zzk paramzzk, Bitmap paramBitmap, String paramString)
  {
    zzpq = paramBitmap;
    zzpo = paramString;
  }
  
  public void onStop() {}
  
  public void zzbn()
  {
    boolean bool1;
    boolean bool2;
    boolean bool3;
    if (zzpp.zzot.zzpt)
    {
      bool1 = zzp.zzbv().zza(zzpp.zzot.context, zzpq, zzpo);
      bool2 = zzpp.zzot.zzpt;
      bool3 = zzpp.zzbl();
      if (!bool1) {
        break label221;
      }
    }
    label221:
    for (final Object localObject = zzpo;; localObject = null)
    {
      localObject = new InterstitialAdParameterParcel(bool2, bool3, (String)localObject, zzk.zza(zzpp), zzk.zzb(zzpp));
      int j = zzpp.zzot.zzqo.zzBD.getRequestedOrientation();
      int i = j;
      if (j == -1) {
        i = zzpp.zzot.zzqo.orientation;
      }
      localObject = new AdOverlayInfoParcel(zzpp, zzpp, zzpp, zzpp.zzot.zzqo.zzBD, i, zzpp.zzot.zzqj, zzpp.zzot.zzqo.zzEP, (InterstitialAdParameterParcel)localObject);
      zzid.zzIE.post(new Runnable()
      {
        public void run()
        {
          zzp.zzbt().zza(zzpp.zzot.context, localObject);
        }
      });
      return;
      bool1 = false;
      break;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzk.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */