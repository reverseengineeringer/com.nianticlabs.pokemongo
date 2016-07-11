package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View.MeasureSpec;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;

@zzgr
public class zzgd
  implements Runnable
{
  private final Handler zzDk;
  private final long zzDl;
  private long zzDm;
  private zzja.zza zzDn;
  protected boolean zzDo;
  protected boolean zzDp;
  private final int zznQ;
  private final int zznR;
  protected final zziz zzoM;
  
  public zzgd(zzja.zza paramzza, zziz paramzziz, int paramInt1, int paramInt2)
  {
    this(paramzza, paramzziz, paramInt1, paramInt2, 200L, 50L);
  }
  
  public zzgd(zzja.zza paramzza, zziz paramzziz, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    zzDl = paramLong1;
    zzDm = paramLong2;
    zzDk = new Handler(Looper.getMainLooper());
    zzoM = paramzziz;
    zzDn = paramzza;
    zzDo = false;
    zzDp = false;
    zznR = paramInt2;
    zznQ = paramInt1;
  }
  
  public void run()
  {
    if ((zzoM == null) || (zzfx()))
    {
      zzDn.zza(zzoM, true);
      return;
    }
    new zza(zzoM.getWebView()).execute(new Void[0]);
  }
  
  public void zza(AdResponseParcel paramAdResponseParcel)
  {
    zza(paramAdResponseParcel, new zzji(this, zzoM, zzER));
  }
  
  public void zza(AdResponseParcel paramAdResponseParcel, zzji paramzzji)
  {
    zzoM.setWebViewClient(paramzzji);
    zziz localzziz = zzoM;
    if (TextUtils.isEmpty(zzBF)) {}
    for (paramzzji = null;; paramzzji = zzp.zzbv().zzaz(zzBF))
    {
      localzziz.loadDataWithBaseURL(paramzzji, body, "text/html", "UTF-8", null);
      return;
    }
  }
  
  public void zzfv()
  {
    zzDk.postDelayed(this, zzDl);
  }
  
  public void zzfw()
  {
    try
    {
      zzDo = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean zzfx()
  {
    try
    {
      boolean bool = zzDo;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean zzfy()
  {
    return zzDp;
  }
  
  protected final class zza
    extends AsyncTask<Void, Void, Boolean>
  {
    private final WebView zzDq;
    private Bitmap zzDr;
    
    public zza(WebView paramWebView)
    {
      zzDq = paramWebView;
    }
    
    protected void onPreExecute()
    {
      try
      {
        zzDr = Bitmap.createBitmap(zzgd.zza(zzgd.this), zzgd.zzb(zzgd.this), Bitmap.Config.ARGB_8888);
        zzDq.setVisibility(0);
        zzDq.measure(View.MeasureSpec.makeMeasureSpec(zzgd.zza(zzgd.this), 0), View.MeasureSpec.makeMeasureSpec(zzgd.zzb(zzgd.this), 0));
        zzDq.layout(0, 0, zzgd.zza(zzgd.this), zzgd.zzb(zzgd.this));
        Canvas localCanvas = new Canvas(zzDr);
        zzDq.draw(localCanvas);
        zzDq.invalidate();
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    protected Boolean zza(Void... paramVarArgs)
    {
      for (;;)
      {
        int i;
        int m;
        try
        {
          int n = zzDr.getWidth();
          int i1 = zzDr.getHeight();
          if ((n == 0) || (i1 == 0))
          {
            paramVarArgs = Boolean.valueOf(false);
            return paramVarArgs;
          }
          i = 0;
          j = 0;
          int k;
          if (i < n)
          {
            k = 0;
            if (k >= i1) {
              break label139;
            }
            m = j;
            if (zzDr.getPixel(i, k) != 0) {
              m = j + 1;
            }
          }
          else
          {
            if (j / (n * i1 / 100.0D) > 0.1D)
            {
              bool = true;
              paramVarArgs = Boolean.valueOf(bool);
              continue;
            }
            boolean bool = false;
            continue;
          }
          k += 10;
        }
        finally {}
        int j = m;
        continue;
        label139:
        i += 10;
      }
    }
    
    protected void zza(Boolean paramBoolean)
    {
      zzgd.zzc(zzgd.this);
      if ((paramBoolean.booleanValue()) || (zzfx()) || (zzgd.zzd(zzgd.this) <= 0L))
      {
        zzDp = paramBoolean.booleanValue();
        zzgd.zze(zzgd.this).zza(zzoM, true);
      }
      while (zzgd.zzd(zzgd.this) <= 0L) {
        return;
      }
      if (zzb.zzN(2)) {
        zzb.zzaF("Ad not detected, scheduling another run.");
      }
      zzgd.zzg(zzgd.this).postDelayed(zzgd.this, zzgd.zzf(zzgd.this));
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */