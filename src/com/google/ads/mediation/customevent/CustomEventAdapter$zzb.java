package com.google.ads.mediation.customevent;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.internal.util.client.zzb;

class CustomEventAdapter$zzb
  implements CustomEventInterstitialListener
{
  private final CustomEventAdapter zzbb;
  private final MediationInterstitialListener zzbd;
  
  public CustomEventAdapter$zzb(CustomEventAdapter paramCustomEventAdapter1, CustomEventAdapter paramCustomEventAdapter2, MediationInterstitialListener paramMediationInterstitialListener)
  {
    zzbb = paramCustomEventAdapter2;
    zzbd = paramMediationInterstitialListener;
  }
  
  public void onDismissScreen()
  {
    zzb.zzaF("Custom event adapter called onDismissScreen.");
    zzbd.onDismissScreen(zzbb);
  }
  
  public void onFailedToReceiveAd()
  {
    zzb.zzaF("Custom event adapter called onFailedToReceiveAd.");
    zzbd.onFailedToReceiveAd(zzbb, AdRequest.ErrorCode.NO_FILL);
  }
  
  public void onLeaveApplication()
  {
    zzb.zzaF("Custom event adapter called onLeaveApplication.");
    zzbd.onLeaveApplication(zzbb);
  }
  
  public void onPresentScreen()
  {
    zzb.zzaF("Custom event adapter called onPresentScreen.");
    zzbd.onPresentScreen(zzbb);
  }
  
  public void onReceivedAd()
  {
    zzb.zzaF("Custom event adapter called onReceivedAd.");
    zzbd.onReceivedAd(zzbe);
  }
}

/* Location:
 * Qualified Name:     com.google.ads.mediation.customevent.CustomEventAdapter.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */