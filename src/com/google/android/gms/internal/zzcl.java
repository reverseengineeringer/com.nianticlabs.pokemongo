package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;

@zzgr
public final class zzcl
  extends zzck.zza
{
  private final OnCustomRenderedAdLoadedListener zztK;
  
  public zzcl(OnCustomRenderedAdLoadedListener paramOnCustomRenderedAdLoadedListener)
  {
    zztK = paramOnCustomRenderedAdLoadedListener;
  }
  
  public void zza(zzcj paramzzcj)
  {
    zztK.onCustomRenderedAdLoaded(new zzci(paramzzcj));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzcl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */