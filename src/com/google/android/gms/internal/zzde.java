package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener;

@zzgr
public class zzde
  extends zzcz.zza
{
  private final NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener zzxm;
  
  public zzde(NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener paramOnCustomTemplateAdLoadedListener)
  {
    zzxm = paramOnCustomTemplateAdLoadedListener;
  }
  
  public void zza(zzcu paramzzcu)
  {
    zzxm.onCustomTemplateAdLoaded(new zzcv(paramzzcu));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzde
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */