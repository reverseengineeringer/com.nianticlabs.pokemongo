package com.google.ads.mediation;

import android.app.Activity;

@Deprecated
public abstract interface MediationInterstitialAdapter<ADDITIONAL_PARAMETERS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters>
  extends MediationAdapter<ADDITIONAL_PARAMETERS, SERVER_PARAMETERS>
{
  public abstract void requestInterstitialAd(MediationInterstitialListener paramMediationInterstitialListener, Activity paramActivity, SERVER_PARAMETERS paramSERVER_PARAMETERS, MediationAdRequest paramMediationAdRequest, ADDITIONAL_PARAMETERS paramADDITIONAL_PARAMETERS);
  
  public abstract void showInterstitial();
}

/* Location:
 * Qualified Name:     com.google.ads.mediation.MediationInterstitialAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */