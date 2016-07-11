package com.google.ads.mediation.customevent;

import android.app.Activity;
import com.google.ads.mediation.MediationAdRequest;

@Deprecated
public abstract interface CustomEventInterstitial
  extends CustomEvent
{
  public abstract void requestInterstitialAd(CustomEventInterstitialListener paramCustomEventInterstitialListener, Activity paramActivity, String paramString1, String paramString2, MediationAdRequest paramMediationAdRequest, Object paramObject);
  
  public abstract void showInterstitial();
}

/* Location:
 * Qualified Name:     com.google.ads.mediation.customevent.CustomEventInterstitial
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */