package com.google.ads.mediation.customevent;

import android.view.View;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.internal.util.client.zzb;

final class CustomEventAdapter$zza
  implements CustomEventBannerListener
{
  private final CustomEventAdapter zzbb;
  private final MediationBannerListener zzbc;
  
  public CustomEventAdapter$zza(CustomEventAdapter paramCustomEventAdapter, MediationBannerListener paramMediationBannerListener)
  {
    zzbb = paramCustomEventAdapter;
    zzbc = paramMediationBannerListener;
  }
  
  public void onClick()
  {
    zzb.zzaF("Custom event adapter called onFailedToReceiveAd.");
    zzbc.onClick(zzbb);
  }
  
  public void onDismissScreen()
  {
    zzb.zzaF("Custom event adapter called onFailedToReceiveAd.");
    zzbc.onDismissScreen(zzbb);
  }
  
  public void onFailedToReceiveAd()
  {
    zzb.zzaF("Custom event adapter called onFailedToReceiveAd.");
    zzbc.onFailedToReceiveAd(zzbb, AdRequest.ErrorCode.NO_FILL);
  }
  
  public void onLeaveApplication()
  {
    zzb.zzaF("Custom event adapter called onFailedToReceiveAd.");
    zzbc.onLeaveApplication(zzbb);
  }
  
  public void onPresentScreen()
  {
    zzb.zzaF("Custom event adapter called onFailedToReceiveAd.");
    zzbc.onPresentScreen(zzbb);
  }
  
  public void onReceivedAd(View paramView)
  {
    zzb.zzaF("Custom event adapter called onReceivedAd.");
    CustomEventAdapter.zza(zzbb, paramView);
    zzbc.onReceivedAd(zzbb);
  }
}

/* Location:
 * Qualified Name:     com.google.ads.mediation.customevent.CustomEventAdapter.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */