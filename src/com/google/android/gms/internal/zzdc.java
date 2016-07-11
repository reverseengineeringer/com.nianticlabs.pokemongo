package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;

@zzgr
public class zzdc
  extends zzcx.zza
{
  private final NativeContentAd.OnContentAdLoadedListener zzxk;
  
  public zzdc(NativeContentAd.OnContentAdLoadedListener paramOnContentAdLoadedListener)
  {
    zzxk = paramOnContentAdLoadedListener;
  }
  
  public void zza(zzcs paramzzcs)
  {
    zzxk.onContentAdLoaded(zzb(paramzzcs));
  }
  
  zzct zzb(zzcs paramzzcs)
  {
    return new zzct(paramzzcs);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */