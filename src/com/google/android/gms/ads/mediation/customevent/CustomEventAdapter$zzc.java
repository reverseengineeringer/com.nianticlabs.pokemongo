package com.google.android.gms.ads.mediation.customevent;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;

class CustomEventAdapter$zzc
  implements CustomEventNativeListener
{
  private final CustomEventAdapter zzKO;
  private final MediationNativeListener zzaS;
  
  public CustomEventAdapter$zzc(CustomEventAdapter paramCustomEventAdapter, MediationNativeListener paramMediationNativeListener)
  {
    zzKO = paramCustomEventAdapter;
    zzaS = paramMediationNativeListener;
  }
  
  public void onAdClicked()
  {
    zzb.zzaF("Custom event adapter called onAdClicked.");
    zzaS.onAdClicked(zzKO);
  }
  
  public void onAdClosed()
  {
    zzb.zzaF("Custom event adapter called onAdClosed.");
    zzaS.onAdClosed(zzKO);
  }
  
  public void onAdFailedToLoad(int paramInt)
  {
    zzb.zzaF("Custom event adapter called onAdFailedToLoad.");
    zzaS.onAdFailedToLoad(zzKO, paramInt);
  }
  
  public void onAdLeftApplication()
  {
    zzb.zzaF("Custom event adapter called onAdLeftApplication.");
    zzaS.onAdLeftApplication(zzKO);
  }
  
  public void onAdLoaded(NativeAdMapper paramNativeAdMapper)
  {
    zzb.zzaF("Custom event adapter called onAdLoaded.");
    zzaS.onAdLoaded(zzKO, paramNativeAdMapper);
  }
  
  public void onAdOpened()
  {
    zzb.zzaF("Custom event adapter called onAdOpened.");
    zzaS.onAdOpened(zzKO);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.mediation.customevent.CustomEventAdapter.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */