package com.google.android.gms.ads.mediation.customevent;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

class CustomEventAdapter$zzb
  implements CustomEventInterstitialListener
{
  private final CustomEventAdapter zzKO;
  private final MediationInterstitialListener zzaR;
  
  public CustomEventAdapter$zzb(CustomEventAdapter paramCustomEventAdapter1, CustomEventAdapter paramCustomEventAdapter2, MediationInterstitialListener paramMediationInterstitialListener)
  {
    zzKO = paramCustomEventAdapter2;
    zzaR = paramMediationInterstitialListener;
  }
  
  public void onAdClicked()
  {
    zzb.zzaF("Custom event adapter called onAdClicked.");
    zzaR.onAdClicked(zzKO);
  }
  
  public void onAdClosed()
  {
    zzb.zzaF("Custom event adapter called onAdClosed.");
    zzaR.onAdClosed(zzKO);
  }
  
  public void onAdFailedToLoad(int paramInt)
  {
    zzb.zzaF("Custom event adapter called onFailedToReceiveAd.");
    zzaR.onAdFailedToLoad(zzKO, paramInt);
  }
  
  public void onAdLeftApplication()
  {
    zzb.zzaF("Custom event adapter called onAdLeftApplication.");
    zzaR.onAdLeftApplication(zzKO);
  }
  
  public void onAdLoaded()
  {
    zzb.zzaF("Custom event adapter called onReceivedAd.");
    zzaR.onAdLoaded(zzKP);
  }
  
  public void onAdOpened()
  {
    zzb.zzaF("Custom event adapter called onAdOpened.");
    zzaR.onAdOpened(zzKO);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.mediation.customevent.CustomEventAdapter.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */