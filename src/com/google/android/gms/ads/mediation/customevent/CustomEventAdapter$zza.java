package com.google.android.gms.ads.mediation.customevent;

import android.view.View;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.MediationBannerListener;

final class CustomEventAdapter$zza
  implements CustomEventBannerListener
{
  private final CustomEventAdapter zzKO;
  private final MediationBannerListener zzaQ;
  
  public CustomEventAdapter$zza(CustomEventAdapter paramCustomEventAdapter, MediationBannerListener paramMediationBannerListener)
  {
    zzKO = paramCustomEventAdapter;
    zzaQ = paramMediationBannerListener;
  }
  
  public void onAdClicked()
  {
    zzb.zzaF("Custom event adapter called onAdClicked.");
    zzaQ.onAdClicked(zzKO);
  }
  
  public void onAdClosed()
  {
    zzb.zzaF("Custom event adapter called onAdClosed.");
    zzaQ.onAdClosed(zzKO);
  }
  
  public void onAdFailedToLoad(int paramInt)
  {
    zzb.zzaF("Custom event adapter called onAdFailedToLoad.");
    zzaQ.onAdFailedToLoad(zzKO, paramInt);
  }
  
  public void onAdLeftApplication()
  {
    zzb.zzaF("Custom event adapter called onAdLeftApplication.");
    zzaQ.onAdLeftApplication(zzKO);
  }
  
  public void onAdLoaded(View paramView)
  {
    zzb.zzaF("Custom event adapter called onAdLoaded.");
    CustomEventAdapter.zza(zzKO, paramView);
    zzaQ.onAdLoaded(zzKO);
  }
  
  public void onAdOpened()
  {
    zzb.zzaF("Custom event adapter called onAdOpened.");
    zzaQ.onAdOpened(zzKO);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.mediation.customevent.CustomEventAdapter.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */