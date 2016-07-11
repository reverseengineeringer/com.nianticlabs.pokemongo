package com.google.android.gms.ads.mediation.customevent;

import com.google.android.gms.ads.mediation.NativeAdMapper;

public abstract interface CustomEventNativeListener
  extends CustomEventListener
{
  public abstract void onAdLoaded(NativeAdMapper paramNativeAdMapper);
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.mediation.customevent.CustomEventNativeListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */