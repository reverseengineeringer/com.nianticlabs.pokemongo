package com.google.ads.mediation;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.mediation.MediationNativeListener;

final class AbstractAdViewAdapter$zze
  extends AdListener
  implements NativeAppInstallAd.OnAppInstallAdLoadedListener, NativeContentAd.OnContentAdLoadedListener, zza
{
  final AbstractAdViewAdapter zzaP;
  final MediationNativeListener zzaS;
  
  public AbstractAdViewAdapter$zze(AbstractAdViewAdapter paramAbstractAdViewAdapter, MediationNativeListener paramMediationNativeListener)
  {
    zzaP = paramAbstractAdViewAdapter;
    zzaS = paramMediationNativeListener;
  }
  
  public void onAdClicked()
  {
    zzaS.onAdClicked(zzaP);
  }
  
  public void onAdClosed()
  {
    zzaS.onAdClosed(zzaP);
  }
  
  public void onAdFailedToLoad(int paramInt)
  {
    zzaS.onAdFailedToLoad(zzaP, paramInt);
  }
  
  public void onAdLeftApplication()
  {
    zzaS.onAdLeftApplication(zzaP);
  }
  
  public void onAdLoaded() {}
  
  public void onAdOpened()
  {
    zzaS.onAdOpened(zzaP);
  }
  
  public void onAppInstallAdLoaded(NativeAppInstallAd paramNativeAppInstallAd)
  {
    zzaS.onAdLoaded(zzaP, new AbstractAdViewAdapter.zza(paramNativeAppInstallAd));
  }
  
  public void onContentAdLoaded(NativeContentAd paramNativeContentAd)
  {
    zzaS.onAdLoaded(zzaP, new AbstractAdViewAdapter.zzb(paramNativeContentAd));
  }
}

/* Location:
 * Qualified Name:     com.google.ads.mediation.AbstractAdViewAdapter.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */