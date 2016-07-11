package com.google.ads.mediation;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.mediation.MediationBannerListener;

final class AbstractAdViewAdapter$zzc
  extends AdListener
  implements zza
{
  final AbstractAdViewAdapter zzaP;
  final MediationBannerListener zzaQ;
  
  public AbstractAdViewAdapter$zzc(AbstractAdViewAdapter paramAbstractAdViewAdapter, MediationBannerListener paramMediationBannerListener)
  {
    zzaP = paramAbstractAdViewAdapter;
    zzaQ = paramMediationBannerListener;
  }
  
  public void onAdClicked()
  {
    zzaQ.onAdClicked(zzaP);
  }
  
  public void onAdClosed()
  {
    zzaQ.onAdClosed(zzaP);
  }
  
  public void onAdFailedToLoad(int paramInt)
  {
    zzaQ.onAdFailedToLoad(zzaP, paramInt);
  }
  
  public void onAdLeftApplication()
  {
    zzaQ.onAdLeftApplication(zzaP);
  }
  
  public void onAdLoaded()
  {
    zzaQ.onAdLoaded(zzaP);
  }
  
  public void onAdOpened()
  {
    zzaQ.onAdOpened(zzaP);
  }
}

/* Location:
 * Qualified Name:     com.google.ads.mediation.AbstractAdViewAdapter.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */