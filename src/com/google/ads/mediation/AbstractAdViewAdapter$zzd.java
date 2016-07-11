package com.google.ads.mediation;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

final class AbstractAdViewAdapter$zzd
  extends AdListener
  implements zza
{
  final AbstractAdViewAdapter zzaP;
  final MediationInterstitialListener zzaR;
  
  public AbstractAdViewAdapter$zzd(AbstractAdViewAdapter paramAbstractAdViewAdapter, MediationInterstitialListener paramMediationInterstitialListener)
  {
    zzaP = paramAbstractAdViewAdapter;
    zzaR = paramMediationInterstitialListener;
  }
  
  public void onAdClicked()
  {
    zzaR.onAdClicked(zzaP);
  }
  
  public void onAdClosed()
  {
    zzaR.onAdClosed(zzaP);
  }
  
  public void onAdFailedToLoad(int paramInt)
  {
    zzaR.onAdFailedToLoad(zzaP, paramInt);
  }
  
  public void onAdLeftApplication()
  {
    zzaR.onAdLeftApplication(zzaP);
  }
  
  public void onAdLoaded()
  {
    zzaR.onAdLoaded(zzaP);
  }
  
  public void onAdOpened()
  {
    zzaR.onAdOpened(zzaP);
  }
}

/* Location:
 * Qualified Name:     com.google.ads.mediation.AbstractAdViewAdapter.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */