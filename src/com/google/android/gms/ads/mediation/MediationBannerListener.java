package com.google.android.gms.ads.mediation;

public abstract interface MediationBannerListener
{
  public abstract void onAdClicked(MediationBannerAdapter paramMediationBannerAdapter);
  
  public abstract void onAdClosed(MediationBannerAdapter paramMediationBannerAdapter);
  
  public abstract void onAdFailedToLoad(MediationBannerAdapter paramMediationBannerAdapter, int paramInt);
  
  public abstract void onAdLeftApplication(MediationBannerAdapter paramMediationBannerAdapter);
  
  public abstract void onAdLoaded(MediationBannerAdapter paramMediationBannerAdapter);
  
  public abstract void onAdOpened(MediationBannerAdapter paramMediationBannerAdapter);
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.mediation.MediationBannerListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */