package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.view.View.MeasureSpec;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.util.client.zzb;

public final class zzgd$zza
  extends AsyncTask<Void, Void, Boolean>
{
  private final WebView zzDq;
  private Bitmap zzDr;
  
  public zzgd$zza(zzgd paramzzgd, WebView paramWebView)
  {
    zzDq = paramWebView;
  }
  
  protected void onPreExecute()
  {
    try
    {
      zzDr = Bitmap.createBitmap(zzgd.zza(zzDs), zzgd.zzb(zzDs), Bitmap.Config.ARGB_8888);
      zzDq.setVisibility(0);
      zzDq.measure(View.MeasureSpec.makeMeasureSpec(zzgd.zza(zzDs), 0), View.MeasureSpec.makeMeasureSpec(zzgd.zzb(zzDs), 0));
      zzDq.layout(0, 0, zzgd.zza(zzDs), zzgd.zzb(zzDs));
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
    zzgd.zzc(zzDs);
    if ((paramBoolean.booleanValue()) || (zzDs.zzfx()) || (zzgd.zzd(zzDs) <= 0L))
    {
      zzDs.zzDp = paramBoolean.booleanValue();
      zzgd.zze(zzDs).zza(zzDs.zzoM, true);
    }
    while (zzgd.zzd(zzDs) <= 0L) {
      return;
    }
    if (zzb.zzN(2)) {
      zzb.zzaF("Ad not detected, scheduling another run.");
    }
    zzgd.zzg(zzDs).postDelayed(zzDs, zzgd.zzf(zzDs));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgd.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */