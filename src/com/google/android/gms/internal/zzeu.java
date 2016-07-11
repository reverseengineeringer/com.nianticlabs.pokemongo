package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.common.internal.zzx;

@zzgr
public final class zzeu
  implements MediationBannerListener, MediationInterstitialListener, MediationNativeListener
{
  private final zzeo zzzL;
  private NativeAdMapper zzzM;
  
  public zzeu(zzeo paramzzeo)
  {
    zzzL = paramzzeo;
  }
  
  public void onAdClicked(MediationBannerAdapter paramMediationBannerAdapter)
  {
    zzx.zzci("onAdClicked must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdClicked.");
    try
    {
      zzzL.onAdClicked();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      zzb.zzd("Could not call onAdClicked.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdClicked(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    zzx.zzci("onAdClicked must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdClicked.");
    try
    {
      zzzL.onAdClicked();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      zzb.zzd("Could not call onAdClicked.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdClicked(MediationNativeAdapter paramMediationNativeAdapter)
  {
    zzx.zzci("onAdClicked must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdClicked.");
    try
    {
      zzzL.onAdClicked();
      return;
    }
    catch (RemoteException paramMediationNativeAdapter)
    {
      zzb.zzd("Could not call onAdClicked.", paramMediationNativeAdapter);
    }
  }
  
  public void onAdClosed(MediationBannerAdapter paramMediationBannerAdapter)
  {
    zzx.zzci("onAdClosed must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdClosed.");
    try
    {
      zzzL.onAdClosed();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      zzb.zzd("Could not call onAdClosed.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdClosed(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    zzx.zzci("onAdClosed must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdClosed.");
    try
    {
      zzzL.onAdClosed();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      zzb.zzd("Could not call onAdClosed.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdClosed(MediationNativeAdapter paramMediationNativeAdapter)
  {
    zzx.zzci("onAdClosed must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdClosed.");
    try
    {
      zzzL.onAdClosed();
      return;
    }
    catch (RemoteException paramMediationNativeAdapter)
    {
      zzb.zzd("Could not call onAdClosed.", paramMediationNativeAdapter);
    }
  }
  
  public void onAdFailedToLoad(MediationBannerAdapter paramMediationBannerAdapter, int paramInt)
  {
    zzx.zzci("onAdFailedToLoad must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdFailedToLoad with error. " + paramInt);
    try
    {
      zzzL.onAdFailedToLoad(paramInt);
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      zzb.zzd("Could not call onAdFailedToLoad.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdFailedToLoad(MediationInterstitialAdapter paramMediationInterstitialAdapter, int paramInt)
  {
    zzx.zzci("onAdFailedToLoad must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdFailedToLoad with error " + paramInt + ".");
    try
    {
      zzzL.onAdFailedToLoad(paramInt);
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      zzb.zzd("Could not call onAdFailedToLoad.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdFailedToLoad(MediationNativeAdapter paramMediationNativeAdapter, int paramInt)
  {
    zzx.zzci("onAdFailedToLoad must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdFailedToLoad with error " + paramInt + ".");
    try
    {
      zzzL.onAdFailedToLoad(paramInt);
      return;
    }
    catch (RemoteException paramMediationNativeAdapter)
    {
      zzb.zzd("Could not call onAdFailedToLoad.", paramMediationNativeAdapter);
    }
  }
  
  public void onAdLeftApplication(MediationBannerAdapter paramMediationBannerAdapter)
  {
    zzx.zzci("onAdLeftApplication must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdLeftApplication.");
    try
    {
      zzzL.onAdLeftApplication();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      zzb.zzd("Could not call onAdLeftApplication.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdLeftApplication(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    zzx.zzci("onAdLeftApplication must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdLeftApplication.");
    try
    {
      zzzL.onAdLeftApplication();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      zzb.zzd("Could not call onAdLeftApplication.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdLeftApplication(MediationNativeAdapter paramMediationNativeAdapter)
  {
    zzx.zzci("onAdLeftApplication must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdLeftApplication.");
    try
    {
      zzzL.onAdLeftApplication();
      return;
    }
    catch (RemoteException paramMediationNativeAdapter)
    {
      zzb.zzd("Could not call onAdLeftApplication.", paramMediationNativeAdapter);
    }
  }
  
  public void onAdLoaded(MediationBannerAdapter paramMediationBannerAdapter)
  {
    zzx.zzci("onAdLoaded must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdLoaded.");
    try
    {
      zzzL.onAdLoaded();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      zzb.zzd("Could not call onAdLoaded.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdLoaded(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    zzx.zzci("onAdLoaded must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdLoaded.");
    try
    {
      zzzL.onAdLoaded();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      zzb.zzd("Could not call onAdLoaded.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdLoaded(MediationNativeAdapter paramMediationNativeAdapter, NativeAdMapper paramNativeAdMapper)
  {
    zzx.zzci("onAdLoaded must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdLoaded.");
    zzzM = paramNativeAdMapper;
    try
    {
      zzzL.onAdLoaded();
      return;
    }
    catch (RemoteException paramMediationNativeAdapter)
    {
      zzb.zzd("Could not call onAdLoaded.", paramMediationNativeAdapter);
    }
  }
  
  public void onAdOpened(MediationBannerAdapter paramMediationBannerAdapter)
  {
    zzx.zzci("onAdOpened must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdOpened.");
    try
    {
      zzzL.onAdOpened();
      return;
    }
    catch (RemoteException paramMediationBannerAdapter)
    {
      zzb.zzd("Could not call onAdOpened.", paramMediationBannerAdapter);
    }
  }
  
  public void onAdOpened(MediationInterstitialAdapter paramMediationInterstitialAdapter)
  {
    zzx.zzci("onAdOpened must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdOpened.");
    try
    {
      zzzL.onAdOpened();
      return;
    }
    catch (RemoteException paramMediationInterstitialAdapter)
    {
      zzb.zzd("Could not call onAdOpened.", paramMediationInterstitialAdapter);
    }
  }
  
  public void onAdOpened(MediationNativeAdapter paramMediationNativeAdapter)
  {
    zzx.zzci("onAdOpened must be called on the main UI thread.");
    zzb.zzaF("Adapter called onAdOpened.");
    try
    {
      zzzL.onAdOpened();
      return;
    }
    catch (RemoteException paramMediationNativeAdapter)
    {
      zzb.zzd("Could not call onAdOpened.", paramMediationNativeAdapter);
    }
  }
  
  public NativeAdMapper zzeb()
  {
    return zzzM;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzeu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */