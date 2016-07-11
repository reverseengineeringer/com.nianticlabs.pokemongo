package com.google.ads.mediation;

import com.google.ads.AdRequest.ErrorCode;

@Deprecated
public abstract interface MediationInterstitialListener
{
  public abstract void onDismissScreen(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter);
  
  public abstract void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter, AdRequest.ErrorCode paramErrorCode);
  
  public abstract void onLeaveApplication(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter);
  
  public abstract void onPresentScreen(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter);
  
  public abstract void onReceivedAd(MediationInterstitialAdapter<?, ?> paramMediationInterstitialAdapter);
}

/* Location:
 * Qualified Name:     com.google.ads.mediation.MediationInterstitialListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */