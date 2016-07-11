package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.zzcl;
import com.google.android.gms.internal.zzel;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzgb;

public class zzaa
{
  private final Context mContext;
  private final zzh zznL;
  private String zzpa;
  private zza zzsy;
  private AdListener zzsz;
  private final zzel zztD = new zzel();
  private zzs zztF;
  private String zztG;
  private InAppPurchaseListener zztI;
  private PlayStorePurchaseListener zztJ;
  private OnCustomRenderedAdLoadedListener zztK;
  private PublisherInterstitialAd zztL;
  private AppEventListener zztj;
  
  public zzaa(Context paramContext)
  {
    this(paramContext, zzh.zzcB(), null);
  }
  
  public zzaa(Context paramContext, PublisherInterstitialAd paramPublisherInterstitialAd)
  {
    this(paramContext, zzh.zzcB(), paramPublisherInterstitialAd);
  }
  
  public zzaa(Context paramContext, zzh paramzzh, PublisherInterstitialAd paramPublisherInterstitialAd)
  {
    mContext = paramContext;
    zznL = paramzzh;
    zztL = paramPublisherInterstitialAd;
  }
  
  private void zzM(String paramString)
    throws RemoteException
  {
    if (zzpa == null) {
      zzN(paramString);
    }
    zztF = zzl.zzcG().zzb(mContext, new AdSizeParcel(), zzpa, zztD);
    if (zzsz != null) {
      zztF.zza(new zzc(zzsz));
    }
    if (zzsy != null) {
      zztF.zza(new zzb(zzsy));
    }
    if (zztj != null) {
      zztF.zza(new zzj(zztj));
    }
    if (zztI != null) {
      zztF.zza(new zzfx(zztI));
    }
    if (zztJ != null) {
      zztF.zza(new zzgb(zztJ), zztG);
    }
    if (zztK != null) {
      zztF.zza(new zzcl(zztK));
    }
  }
  
  private void zzN(String paramString)
  {
    if (zztF == null) {
      throw new IllegalStateException("The ad unit ID must be set on InterstitialAd before " + paramString + " is called.");
    }
  }
  
  public AdListener getAdListener()
  {
    return zzsz;
  }
  
  public String getAdUnitId()
  {
    return zzpa;
  }
  
  public AppEventListener getAppEventListener()
  {
    return zztj;
  }
  
  public InAppPurchaseListener getInAppPurchaseListener()
  {
    return zztI;
  }
  
  public String getMediationAdapterClassName()
  {
    try
    {
      if (zztF != null)
      {
        String str = zztF.getMediationAdapterClassName();
        return str;
      }
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to get the mediation adapter class name.", localRemoteException);
    }
    return null;
  }
  
  public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener()
  {
    return zztK;
  }
  
  public boolean isLoaded()
  {
    try
    {
      if (zztF == null) {
        return false;
      }
      boolean bool = zztF.isReady();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to check if ad is ready.", localRemoteException);
    }
    return false;
  }
  
  public boolean isLoading()
  {
    try
    {
      if (zztF == null) {
        return false;
      }
      boolean bool = zztF.isLoading();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to check if ad is loading.", localRemoteException);
    }
    return false;
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    try
    {
      zzsz = paramAdListener;
      zzs localzzs;
      if (zztF != null)
      {
        localzzs = zztF;
        if (paramAdListener == null) {
          break label38;
        }
      }
      label38:
      for (paramAdListener = new zzc(paramAdListener);; paramAdListener = null)
      {
        localzzs.zza(paramAdListener);
        return;
      }
      return;
    }
    catch (RemoteException paramAdListener)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the AdListener.", paramAdListener);
    }
  }
  
  public void setAdUnitId(String paramString)
  {
    if (zzpa != null) {
      throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
    }
    zzpa = paramString;
  }
  
  public void setAppEventListener(AppEventListener paramAppEventListener)
  {
    try
    {
      zztj = paramAppEventListener;
      zzs localzzs;
      if (zztF != null)
      {
        localzzs = zztF;
        if (paramAppEventListener == null) {
          break label38;
        }
      }
      label38:
      for (paramAppEventListener = new zzj(paramAppEventListener);; paramAppEventListener = null)
      {
        localzzs.zza(paramAppEventListener);
        return;
      }
      return;
    }
    catch (RemoteException paramAppEventListener)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the AppEventListener.", paramAppEventListener);
    }
  }
  
  public void setInAppPurchaseListener(InAppPurchaseListener paramInAppPurchaseListener)
  {
    if (zztJ != null) {
      throw new IllegalStateException("Play store purchase parameter has already been set.");
    }
    try
    {
      zztI = paramInAppPurchaseListener;
      zzs localzzs;
      if (zztF != null)
      {
        localzzs = zztF;
        if (paramInAppPurchaseListener == null) {
          break label55;
        }
      }
      label55:
      for (paramInAppPurchaseListener = new zzfx(paramInAppPurchaseListener);; paramInAppPurchaseListener = null)
      {
        localzzs.zza(paramInAppPurchaseListener);
        return;
      }
      return;
    }
    catch (RemoteException paramInAppPurchaseListener)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the InAppPurchaseListener.", paramInAppPurchaseListener);
    }
  }
  
  public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener paramOnCustomRenderedAdLoadedListener)
  {
    try
    {
      zztK = paramOnCustomRenderedAdLoadedListener;
      zzs localzzs;
      if (zztF != null)
      {
        localzzs = zztF;
        if (paramOnCustomRenderedAdLoadedListener == null) {
          break label38;
        }
      }
      label38:
      for (paramOnCustomRenderedAdLoadedListener = new zzcl(paramOnCustomRenderedAdLoadedListener);; paramOnCustomRenderedAdLoadedListener = null)
      {
        localzzs.zza(paramOnCustomRenderedAdLoadedListener);
        return;
      }
      return;
    }
    catch (RemoteException paramOnCustomRenderedAdLoadedListener)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the OnCustomRenderedAdLoadedListener.", paramOnCustomRenderedAdLoadedListener);
    }
  }
  
  public void setPlayStorePurchaseParams(PlayStorePurchaseListener paramPlayStorePurchaseListener, String paramString)
  {
    if (zztI != null) {
      throw new IllegalStateException("In app purchase parameter has already been set.");
    }
    try
    {
      zztJ = paramPlayStorePurchaseListener;
      zztG = paramString;
      zzs localzzs;
      if (zztF != null)
      {
        localzzs = zztF;
        if (paramPlayStorePurchaseListener == null) {
          break label61;
        }
      }
      label61:
      for (paramPlayStorePurchaseListener = new zzgb(paramPlayStorePurchaseListener);; paramPlayStorePurchaseListener = null)
      {
        localzzs.zza(paramPlayStorePurchaseListener, paramString);
        return;
      }
      return;
    }
    catch (RemoteException paramPlayStorePurchaseListener)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the play store purchase parameter.", paramPlayStorePurchaseListener);
    }
  }
  
  public void show()
  {
    try
    {
      zzN("show");
      zztF.showInterstitial();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to show interstitial.", localRemoteException);
    }
  }
  
  public void zza(zza paramzza)
  {
    try
    {
      zzsy = paramzza;
      zzs localzzs;
      if (zztF != null)
      {
        localzzs = zztF;
        if (paramzza == null) {
          break label38;
        }
      }
      label38:
      for (paramzza = new zzb(paramzza);; paramzza = null)
      {
        localzzs.zza(paramzza);
        return;
      }
      return;
    }
    catch (RemoteException paramzza)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to set the AdClickListener.", paramzza);
    }
  }
  
  public void zza(zzy paramzzy)
  {
    try
    {
      if (zztF == null) {
        zzM("loadAd");
      }
      if (zztF.zzb(zznL.zza(mContext, paramzzy))) {
        zztD.zze(paramzzy.zzcO());
      }
      return;
    }
    catch (RemoteException paramzzy)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to load ad.", paramzzy);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zzaa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */