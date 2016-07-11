package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;

@zzgr
public class zzdb
  extends zzcw.zza
{
  private final NativeAppInstallAd.OnAppInstallAdLoadedListener zzxj;
  
  public zzdb(NativeAppInstallAd.OnAppInstallAdLoadedListener paramOnAppInstallAdLoadedListener)
  {
    zzxj = paramOnAppInstallAdLoadedListener;
  }
  
  public void zza(zzcq paramzzcq)
  {
    zzxj.onAppInstallAdLoaded(zzb(paramzzcq));
  }
  
  zzcr zzb(zzcq paramzzcq)
  {
    return new zzcr(paramzzcq);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */