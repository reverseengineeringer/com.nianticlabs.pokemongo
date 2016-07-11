package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAdOptions;

public abstract interface NativeMediationAdRequest
  extends MediationAdRequest
{
  public abstract NativeAdOptions getNativeAdOptions();
  
  public abstract boolean isAppInstallAdRequested();
  
  public abstract boolean isContentAdRequested();
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.mediation.NativeMediationAdRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */