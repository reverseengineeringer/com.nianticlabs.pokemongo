package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

@zzgr
public final class zzet
  extends zzen.zza
{
  private final MediationAdapter zzzJ;
  private zzeu zzzK;
  
  public zzet(MediationAdapter paramMediationAdapter)
  {
    zzzJ = paramMediationAdapter;
  }
  
  private Bundle zza(String paramString1, int paramInt, String paramString2)
    throws RemoteException
  {
    com.google.android.gms.ads.internal.util.client.zzb.zzaH("Server parameters: " + paramString1);
    Bundle localBundle;
    try
    {
      localBundle = new Bundle();
      if (paramString1 != null)
      {
        paramString1 = new JSONObject(paramString1);
        localBundle = new Bundle();
        Iterator localIterator = paramString1.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localBundle.putString(str, paramString1.getString(str));
        }
      }
      if (!(zzzJ instanceof AdMobAdapter)) {
        break label138;
      }
    }
    catch (Throwable paramString1)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not get Server Parameters Bundle.", paramString1);
      throw new RemoteException();
    }
    localBundle.putString("adJson", paramString2);
    localBundle.putInt("tagForChildDirectedTreatment", paramInt);
    label138:
    return localBundle;
  }
  
  public void destroy()
    throws RemoteException
  {
    try
    {
      zzzJ.onDestroy();
      return;
    }
    catch (Throwable localThrowable)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not destroy adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public zzd getView()
    throws RemoteException
  {
    if (!(zzzJ instanceof MediationBannerAdapter))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a MediationBannerAdapter: " + zzzJ.getClass().getCanonicalName());
      throw new RemoteException();
    }
    try
    {
      zzd localzzd = zze.zzy(((MediationBannerAdapter)zzzJ).getBannerView());
      return localzzd;
    }
    catch (Throwable localThrowable)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not get banner view from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public boolean isInitialized()
    throws RemoteException
  {
    if (!(zzzJ instanceof MediationRewardedVideoAdAdapter))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a MediationRewardedVideoAdAdapter: " + zzzJ.getClass().getCanonicalName());
      throw new RemoteException();
    }
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Check if adapter is initialized.");
    try
    {
      boolean bool = ((MediationRewardedVideoAdAdapter)zzzJ).isInitialized();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not check if adapter is initialized.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void pause()
    throws RemoteException
  {
    try
    {
      zzzJ.onPause();
      return;
    }
    catch (Throwable localThrowable)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not pause adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void resume()
    throws RemoteException
  {
    try
    {
      zzzJ.onResume();
      return;
    }
    catch (Throwable localThrowable)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not resume adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void showInterstitial()
    throws RemoteException
  {
    if (!(zzzJ instanceof MediationInterstitialAdapter))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a MediationInterstitialAdapter: " + zzzJ.getClass().getCanonicalName());
      throw new RemoteException();
    }
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Showing interstitial from adapter.");
    try
    {
      ((MediationInterstitialAdapter)zzzJ).showInterstitial();
      return;
    }
    catch (Throwable localThrowable)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not show interstitial from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void showVideo()
    throws RemoteException
  {
    if (!(zzzJ instanceof MediationRewardedVideoAdAdapter))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a MediationRewardedVideoAdAdapter: " + zzzJ.getClass().getCanonicalName());
      throw new RemoteException();
    }
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Show rewarded video ad from adapter.");
    try
    {
      ((MediationRewardedVideoAdAdapter)zzzJ).showVideo();
      return;
    }
    catch (Throwable localThrowable)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not show rewarded video ad from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void zza(AdRequestParcel paramAdRequestParcel, String paramString)
    throws RemoteException
  {
    if (!(zzzJ instanceof MediationRewardedVideoAdAdapter))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a MediationRewardedVideoAdAdapter: " + zzzJ.getClass().getCanonicalName());
      throw new RemoteException();
    }
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Requesting rewarded video ad from adapter.");
    for (;;)
    {
      try
      {
        MediationRewardedVideoAdAdapter localMediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter)zzzJ;
        if (zzsD == null) {
          break label204;
        }
        localObject1 = new HashSet(zzsD);
        Object localObject2;
        if (zzsB == -1L)
        {
          localObject2 = null;
          localObject2 = new zzes((Date)localObject2, zzsC, (Set)localObject1, zzsJ, zzsE, zzsF);
          if (zzsL != null)
          {
            localObject1 = zzsL.getBundle(localMediationRewardedVideoAdAdapter.getClass().getName());
            localMediationRewardedVideoAdAdapter.loadAd((MediationAdRequest)localObject2, zza(paramString, zzsF, null), (Bundle)localObject1);
          }
        }
        else
        {
          localObject2 = new Date(zzsB);
          continue;
        }
        localObject1 = null;
      }
      catch (Throwable paramAdRequestParcel)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not load rewarded video ad from adapter.", paramAdRequestParcel);
        throw new RemoteException();
      }
      continue;
      label204:
      Object localObject1 = null;
    }
  }
  
  public void zza(zzd paramzzd, AdRequestParcel paramAdRequestParcel, String paramString1, com.google.android.gms.ads.internal.reward.mediation.client.zza paramzza, String paramString2)
    throws RemoteException
  {
    if (!(zzzJ instanceof MediationRewardedVideoAdAdapter))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a MediationRewardedVideoAdAdapter: " + zzzJ.getClass().getCanonicalName());
      throw new RemoteException();
    }
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Initialize rewarded video adapter.");
    for (;;)
    {
      try
      {
        MediationRewardedVideoAdAdapter localMediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter)zzzJ;
        if (zzsD == null) {
          break label228;
        }
        localObject1 = new HashSet(zzsD);
        Object localObject2;
        if (zzsB == -1L)
        {
          localObject2 = null;
          localObject2 = new zzes((Date)localObject2, zzsC, (Set)localObject1, zzsJ, zzsE, zzsF);
          if (zzsL != null)
          {
            localObject1 = zzsL.getBundle(localMediationRewardedVideoAdAdapter.getClass().getName());
            localMediationRewardedVideoAdAdapter.initialize((Context)zze.zzp(paramzzd), (MediationAdRequest)localObject2, paramString1, new com.google.android.gms.ads.internal.reward.mediation.client.zzb(paramzza), zza(paramString2, zzsF, null), (Bundle)localObject1);
          }
        }
        else
        {
          localObject2 = new Date(zzsB);
          continue;
        }
        localObject1 = null;
      }
      catch (Throwable paramzzd)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not initialize rewarded video adapter.", paramzzd);
        throw new RemoteException();
      }
      continue;
      label228:
      Object localObject1 = null;
    }
  }
  
  public void zza(zzd paramzzd, AdRequestParcel paramAdRequestParcel, String paramString, zzeo paramzzeo)
    throws RemoteException
  {
    zza(paramzzd, paramAdRequestParcel, paramString, null, paramzzeo);
  }
  
  public void zza(zzd paramzzd, AdRequestParcel paramAdRequestParcel, String paramString1, String paramString2, zzeo paramzzeo)
    throws RemoteException
  {
    if (!(zzzJ instanceof MediationInterstitialAdapter))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a MediationInterstitialAdapter: " + zzzJ.getClass().getCanonicalName());
      throw new RemoteException();
    }
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Requesting interstitial ad from adapter.");
    for (;;)
    {
      try
      {
        MediationInterstitialAdapter localMediationInterstitialAdapter = (MediationInterstitialAdapter)zzzJ;
        if (zzsD == null) {
          break label228;
        }
        localObject1 = new HashSet(zzsD);
        Object localObject2;
        if (zzsB == -1L)
        {
          localObject2 = null;
          localObject2 = new zzes((Date)localObject2, zzsC, (Set)localObject1, zzsJ, zzsE, zzsF);
          if (zzsL != null)
          {
            localObject1 = zzsL.getBundle(localMediationInterstitialAdapter.getClass().getName());
            localMediationInterstitialAdapter.requestInterstitialAd((Context)zze.zzp(paramzzd), new zzeu(paramzzeo), zza(paramString1, zzsF, paramString2), (MediationAdRequest)localObject2, (Bundle)localObject1);
          }
        }
        else
        {
          localObject2 = new Date(zzsB);
          continue;
        }
        localObject1 = null;
      }
      catch (Throwable paramzzd)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not request interstitial ad from adapter.", paramzzd);
        throw new RemoteException();
      }
      continue;
      label228:
      Object localObject1 = null;
    }
  }
  
  public void zza(zzd paramzzd, AdRequestParcel paramAdRequestParcel, String paramString1, String paramString2, zzeo paramzzeo, NativeAdOptionsParcel paramNativeAdOptionsParcel, List<String> paramList)
    throws RemoteException
  {
    if (!(zzzJ instanceof MediationNativeAdapter))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a MediationNativeAdapter: " + zzzJ.getClass().getCanonicalName());
      throw new RemoteException();
    }
    for (;;)
    {
      try
      {
        MediationNativeAdapter localMediationNativeAdapter = (MediationNativeAdapter)zzzJ;
        if (zzsD == null) {
          break label235;
        }
        localHashSet = new HashSet(zzsD);
        Date localDate;
        if (zzsB == -1L)
        {
          localDate = null;
          paramList = new zzex(localDate, zzsC, localHashSet, zzsJ, zzsE, zzsF, paramNativeAdOptionsParcel, paramList);
          if (zzsL != null)
          {
            paramNativeAdOptionsParcel = zzsL.getBundle(localMediationNativeAdapter.getClass().getName());
            zzzK = new zzeu(paramzzeo);
            localMediationNativeAdapter.requestNativeAd((Context)zze.zzp(paramzzd), zzzK, zza(paramString1, zzsF, paramString2), paramList, paramNativeAdOptionsParcel);
          }
        }
        else
        {
          localDate = new Date(zzsB);
          continue;
        }
        paramNativeAdOptionsParcel = null;
      }
      catch (Throwable paramzzd)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not request interstitial ad from adapter.", paramzzd);
        throw new RemoteException();
      }
      continue;
      label235:
      HashSet localHashSet = null;
    }
  }
  
  public void zza(zzd paramzzd, AdSizeParcel paramAdSizeParcel, AdRequestParcel paramAdRequestParcel, String paramString, zzeo paramzzeo)
    throws RemoteException
  {
    zza(paramzzd, paramAdSizeParcel, paramAdRequestParcel, paramString, null, paramzzeo);
  }
  
  public void zza(zzd paramzzd, AdSizeParcel paramAdSizeParcel, AdRequestParcel paramAdRequestParcel, String paramString1, String paramString2, zzeo paramzzeo)
    throws RemoteException
  {
    if (!(zzzJ instanceof MediationBannerAdapter))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a MediationBannerAdapter: " + zzzJ.getClass().getCanonicalName());
      throw new RemoteException();
    }
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Requesting banner ad from adapter.");
    for (;;)
    {
      try
      {
        MediationBannerAdapter localMediationBannerAdapter = (MediationBannerAdapter)zzzJ;
        if (zzsD == null) {
          break label244;
        }
        localObject1 = new HashSet(zzsD);
        Object localObject2;
        if (zzsB == -1L)
        {
          localObject2 = null;
          localObject2 = new zzes((Date)localObject2, zzsC, (Set)localObject1, zzsJ, zzsE, zzsF);
          if (zzsL != null)
          {
            localObject1 = zzsL.getBundle(localMediationBannerAdapter.getClass().getName());
            localMediationBannerAdapter.requestBannerAd((Context)zze.zzp(paramzzd), new zzeu(paramzzeo), zza(paramString1, zzsF, paramString2), com.google.android.gms.ads.zza.zza(width, height, zzte), (MediationAdRequest)localObject2, (Bundle)localObject1);
          }
        }
        else
        {
          localObject2 = new Date(zzsB);
          continue;
        }
        localObject1 = null;
      }
      catch (Throwable paramzzd)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not request banner ad from adapter.", paramzzd);
        throw new RemoteException();
      }
      continue;
      label244:
      Object localObject1 = null;
    }
  }
  
  public zzeq zzdV()
  {
    NativeAdMapper localNativeAdMapper = zzzK.zzeb();
    if ((localNativeAdMapper instanceof NativeAppInstallAdMapper)) {
      return new zzev((NativeAppInstallAdMapper)localNativeAdMapper);
    }
    return null;
  }
  
  public zzer zzdW()
  {
    NativeAdMapper localNativeAdMapper = zzzK.zzeb();
    if ((localNativeAdMapper instanceof NativeContentAdMapper)) {
      return new zzew((NativeContentAdMapper)localNativeAdMapper);
    }
    return null;
  }
  
  public Bundle zzdX()
  {
    if (!(zzzJ instanceof zzjj))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a v2 MediationBannerAdapter: " + zzzJ.getClass().getCanonicalName());
      return new Bundle();
    }
    return ((zzjj)zzzJ).zzdX();
  }
  
  public Bundle zzdY()
  {
    if (!(zzzJ instanceof zzjk))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("MediationAdapter is not a v2 MediationInterstitialAdapter: " + zzzJ.getClass().getCanonicalName());
      return new Bundle();
    }
    return ((zzjk)zzzJ).zzdY();
  }
  
  public Bundle zzdZ()
  {
    return new Bundle();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */