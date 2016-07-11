package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.Window;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhz;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzie;

@zzgr
class zzd$zzd
  extends zzhz
{
  private zzd$zzd(zzd paramzzd) {}
  
  public void onStop() {}
  
  public void zzbn()
  {
    final Object localObject = zzp.zzbv().zzg(zzd.zza(zzBv), zzBv.zzBi.zzBM.zzpv);
    if (localObject != null)
    {
      localObject = zzp.zzbx().zza(zzd.zza(zzBv), (Bitmap)localObject, zzBv.zzBi.zzBM.zzpw, zzBv.zzBi.zzBM.zzpx);
      zzid.zzIE.post(new Runnable()
      {
        public void run()
        {
          zzd.zza(zzBv).getWindow().setBackgroundDrawable(localObject);
        }
      });
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzd.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */