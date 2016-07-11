package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;

public final class CustomEventAdapter
  implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter
{
  CustomEventBanner zzKL;
  CustomEventInterstitial zzKM;
  CustomEventNative zzKN;
  private View zzaY;
  
  private void zza(View paramView)
  {
    zzaY = paramView;
  }
  
  private static <T> T zzj(String paramString)
  {
    try
    {
      Object localObject = Class.forName(paramString).newInstance();
      return (T)localObject;
    }
    catch (Throwable localThrowable)
    {
      zzb.zzaH("Could not instantiate custom event adapter: " + paramString + ". " + localThrowable.getMessage());
    }
    return null;
  }
  
  public View getBannerView()
  {
    return zzaY;
  }
  
  public void onDestroy()
  {
    if (zzKL != null) {
      zzKL.onDestroy();
    }
    if (zzKM != null) {
      zzKM.onDestroy();
    }
    if (zzKN != null) {
      zzKN.onDestroy();
    }
  }
  
  public void onPause()
  {
    if (zzKL != null) {
      zzKL.onPause();
    }
    if (zzKM != null) {
      zzKM.onPause();
    }
    if (zzKN != null) {
      zzKN.onPause();
    }
  }
  
  public void onResume()
  {
    if (zzKL != null) {
      zzKL.onResume();
    }
    if (zzKM != null) {
      zzKM.onResume();
    }
    if (zzKN != null) {
      zzKN.onResume();
    }
  }
  
  public void requestBannerAd(Context paramContext, MediationBannerListener paramMediationBannerListener, Bundle paramBundle1, AdSize paramAdSize, MediationAdRequest paramMediationAdRequest, Bundle paramBundle2)
  {
    zzKL = ((CustomEventBanner)zzj(paramBundle1.getString("class_name")));
    if (zzKL == null)
    {
      paramMediationBannerListener.onAdFailedToLoad(this, 0);
      return;
    }
    if (paramBundle2 == null) {}
    for (paramBundle2 = null;; paramBundle2 = paramBundle2.getBundle(paramBundle1.getString("class_name")))
    {
      zzKL.requestBannerAd(paramContext, new zza(this, paramMediationBannerListener), paramBundle1.getString("parameter"), paramAdSize, paramMediationAdRequest, paramBundle2);
      return;
    }
  }
  
  public void requestInterstitialAd(Context paramContext, MediationInterstitialListener paramMediationInterstitialListener, Bundle paramBundle1, MediationAdRequest paramMediationAdRequest, Bundle paramBundle2)
  {
    zzKM = ((CustomEventInterstitial)zzj(paramBundle1.getString("class_name")));
    if (zzKM == null)
    {
      paramMediationInterstitialListener.onAdFailedToLoad(this, 0);
      return;
    }
    if (paramBundle2 == null) {}
    for (paramBundle2 = null;; paramBundle2 = paramBundle2.getBundle(paramBundle1.getString("class_name")))
    {
      zzKM.requestInterstitialAd(paramContext, zza(paramMediationInterstitialListener), paramBundle1.getString("parameter"), paramMediationAdRequest, paramBundle2);
      return;
    }
  }
  
  public void requestNativeAd(Context paramContext, MediationNativeListener paramMediationNativeListener, Bundle paramBundle1, NativeMediationAdRequest paramNativeMediationAdRequest, Bundle paramBundle2)
  {
    zzKN = ((CustomEventNative)zzj(paramBundle1.getString("class_name")));
    if (zzKN == null)
    {
      paramMediationNativeListener.onAdFailedToLoad(this, 0);
      return;
    }
    if (paramBundle2 == null) {}
    for (paramBundle2 = null;; paramBundle2 = paramBundle2.getBundle(paramBundle1.getString("class_name")))
    {
      zzKN.requestNativeAd(paramContext, new zzc(this, paramMediationNativeListener), paramBundle1.getString("parameter"), paramNativeMediationAdRequest, paramBundle2);
      return;
    }
  }
  
  public void showInterstitial()
  {
    zzKM.showInterstitial();
  }
  
  zzb zza(MediationInterstitialListener paramMediationInterstitialListener)
  {
    return new zzb(this, paramMediationInterstitialListener);
  }
  
  static final class zza
    implements CustomEventBannerListener
  {
    private final CustomEventAdapter zzKO;
    private final MediationBannerListener zzaQ;
    
    public zza(CustomEventAdapter paramCustomEventAdapter, MediationBannerListener paramMediationBannerListener)
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
  
  class zzb
    implements CustomEventInterstitialListener
  {
    private final CustomEventAdapter zzKO;
    private final MediationInterstitialListener zzaR;
    
    public zzb(CustomEventAdapter paramCustomEventAdapter, MediationInterstitialListener paramMediationInterstitialListener)
    {
      zzKO = paramCustomEventAdapter;
      zzaR = paramMediationInterstitialListener;
    }
    
    public void onAdClicked()
    {
      zzb.zzaF("Custom event adapter called onAdClicked.");
      zzaR.onAdClicked(zzKO);
    }
    
    public void onAdClosed()
    {
      zzb.zzaF("Custom event adapter called onAdClosed.");
      zzaR.onAdClosed(zzKO);
    }
    
    public void onAdFailedToLoad(int paramInt)
    {
      zzb.zzaF("Custom event adapter called onFailedToReceiveAd.");
      zzaR.onAdFailedToLoad(zzKO, paramInt);
    }
    
    public void onAdLeftApplication()
    {
      zzb.zzaF("Custom event adapter called onAdLeftApplication.");
      zzaR.onAdLeftApplication(zzKO);
    }
    
    public void onAdLoaded()
    {
      zzb.zzaF("Custom event adapter called onReceivedAd.");
      zzaR.onAdLoaded(CustomEventAdapter.this);
    }
    
    public void onAdOpened()
    {
      zzb.zzaF("Custom event adapter called onAdOpened.");
      zzaR.onAdOpened(zzKO);
    }
  }
  
  static class zzc
    implements CustomEventNativeListener
  {
    private final CustomEventAdapter zzKO;
    private final MediationNativeListener zzaS;
    
    public zzc(CustomEventAdapter paramCustomEventAdapter, MediationNativeListener paramMediationNativeListener)
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.mediation.customevent.CustomEventAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */