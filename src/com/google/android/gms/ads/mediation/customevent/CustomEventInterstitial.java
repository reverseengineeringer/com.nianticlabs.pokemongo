package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdRequest;

public abstract interface CustomEventInterstitial
  extends CustomEvent
{
  public abstract void requestInterstitialAd(Context paramContext, CustomEventInterstitialListener paramCustomEventInterstitialListener, String paramString, MediationAdRequest paramMediationAdRequest, Bundle paramBundle);
  
  public abstract void showInterstitial();
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.mediation.customevent.CustomEventInterstitial
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */