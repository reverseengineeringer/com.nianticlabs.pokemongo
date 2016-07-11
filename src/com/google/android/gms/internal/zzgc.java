package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.atomic.AtomicBoolean;

@zzgr
public abstract class zzgc
  implements zzgh<Void>, zzja.zza
{
  protected final Context mContext;
  protected final zzgg.zza zzDd;
  protected final zzhs.zza zzDe;
  protected AdResponseParcel zzDf;
  private Runnable zzDg;
  protected final Object zzDh = new Object();
  private AtomicBoolean zzDi = new AtomicBoolean(true);
  protected final zziz zzoM;
  
  protected zzgc(Context paramContext, zzhs.zza paramzza, zziz paramzziz, zzgg.zza paramzza1)
  {
    mContext = paramContext;
    zzDe = paramzza;
    zzDf = zzDe.zzHD;
    zzoM = paramzziz;
    zzDd = paramzza1;
  }
  
  private zzhs zzA(int paramInt)
  {
    AdRequestInfoParcel localAdRequestInfoParcel = zzDe.zzHC;
    return new zzhs(zzEn, zzoM, zzDf.zzyY, paramInt, zzDf.zzyZ, zzDf.zzEM, zzDf.orientation, zzDf.zzzc, zzEq, zzDf.zzEK, null, null, null, null, null, zzDf.zzEL, zzDe.zzqn, zzDf.zzEJ, zzDe.zzHz, zzDf.zzEO, zzDf.zzEP, zzDe.zzHw, null);
  }
  
  public void cancel()
  {
    if (!zzDi.getAndSet(false)) {
      return;
    }
    zzoM.stopLoading();
    zzp.zzbx().zza(zzoM.getWebView());
    zzz(-1);
    zzid.zzIE.removeCallbacks(zzDg);
  }
  
  public void zza(zziz paramzziz, boolean paramBoolean)
  {
    zzb.zzaF("WebView finished loading.");
    if (!zzDi.getAndSet(false)) {
      return;
    }
    if (paramBoolean) {}
    for (int i = zzft();; i = -1)
    {
      zzz(i);
      zzid.zzIE.removeCallbacks(zzDg);
      return;
    }
  }
  
  public final Void zzfr()
  {
    zzx.zzci("Webview render task needs to be called on UI thread.");
    zzDg = new Runnable()
    {
      public void run()
      {
        if (!zzgc.zza(zzgc.this).get()) {
          return;
        }
        zzb.e("Timed out waiting for WebView to finish loading.");
        cancel();
      }
    };
    zzid.zzIE.postDelayed(zzDg, ((Long)zzby.zzvw.get()).longValue());
    zzfs();
    return null;
  }
  
  protected abstract void zzfs();
  
  protected int zzft()
  {
    return -2;
  }
  
  protected void zzz(int paramInt)
  {
    if (paramInt != -2) {
      zzDf = new AdResponseParcel(paramInt, zzDf.zzzc);
    }
    zzDd.zzb(zzA(paramInt));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */