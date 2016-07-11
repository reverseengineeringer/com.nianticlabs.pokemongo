package com.google.android.gms.ads.internal.reward.mediation.client;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzgr;

@zzgr
public class zzb
  implements MediationRewardedVideoAdListener
{
  private final zza zzHu;
  
  public zzb(zza paramzza)
  {
    zzHu = paramzza;
  }
  
  public void onAdClicked(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter)
  {
    zzx.zzci("onAdClicked must be called on the main UI thread.");
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Adapter called onAdClicked.");
    try
    {
      zzHu.zzl(zze.zzy(paramMediationRewardedVideoAdAdapter));
      return;
    }
    catch (RemoteException paramMediationRewardedVideoAdAdapter)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdClicked.", paramMediationRewardedVideoAdAdapter);
    }
  }
  
  public void onAdClosed(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter)
  {
    zzx.zzci("onAdClosed must be called on the main UI thread.");
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Adapter called onAdClosed.");
    try
    {
      zzHu.zzk(zze.zzy(paramMediationRewardedVideoAdAdapter));
      return;
    }
    catch (RemoteException paramMediationRewardedVideoAdAdapter)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdClosed.", paramMediationRewardedVideoAdAdapter);
    }
  }
  
  public void onAdFailedToLoad(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter, int paramInt)
  {
    zzx.zzci("onAdFailedToLoad must be called on the main UI thread.");
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Adapter called onAdFailedToLoad.");
    try
    {
      zzHu.zzc(zze.zzy(paramMediationRewardedVideoAdAdapter), paramInt);
      return;
    }
    catch (RemoteException paramMediationRewardedVideoAdAdapter)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdFailedToLoad.", paramMediationRewardedVideoAdAdapter);
    }
  }
  
  public void onAdLeftApplication(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter)
  {
    zzx.zzci("onAdLeftApplication must be called on the main UI thread.");
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Adapter called onAdLeftApplication.");
    try
    {
      zzHu.zzm(zze.zzy(paramMediationRewardedVideoAdAdapter));
      return;
    }
    catch (RemoteException paramMediationRewardedVideoAdAdapter)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdLeftApplication.", paramMediationRewardedVideoAdAdapter);
    }
  }
  
  public void onAdLoaded(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter)
  {
    zzx.zzci("onAdLoaded must be called on the main UI thread.");
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Adapter called onAdLoaded.");
    try
    {
      zzHu.zzh(zze.zzy(paramMediationRewardedVideoAdAdapter));
      return;
    }
    catch (RemoteException paramMediationRewardedVideoAdAdapter)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdLoaded.", paramMediationRewardedVideoAdAdapter);
    }
  }
  
  public void onAdOpened(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter)
  {
    zzx.zzci("onAdOpened must be called on the main UI thread.");
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Adapter called onAdOpened.");
    try
    {
      zzHu.zzi(zze.zzy(paramMediationRewardedVideoAdAdapter));
      return;
    }
    catch (RemoteException paramMediationRewardedVideoAdAdapter)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdOpened.", paramMediationRewardedVideoAdAdapter);
    }
  }
  
  public void onInitializationFailed(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter, int paramInt)
  {
    zzx.zzci("onInitializationFailed must be called on the main UI thread.");
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Adapter called onInitializationFailed.");
    try
    {
      zzHu.zzb(zze.zzy(paramMediationRewardedVideoAdAdapter), paramInt);
      return;
    }
    catch (RemoteException paramMediationRewardedVideoAdAdapter)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onInitializationFailed.", paramMediationRewardedVideoAdAdapter);
    }
  }
  
  public void onInitializationSucceeded(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter)
  {
    zzx.zzci("onInitializationSucceeded must be called on the main UI thread.");
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Adapter called onInitializationSucceeded.");
    try
    {
      zzHu.zzg(zze.zzy(paramMediationRewardedVideoAdAdapter));
      return;
    }
    catch (RemoteException paramMediationRewardedVideoAdAdapter)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onInitializationSucceeded.", paramMediationRewardedVideoAdAdapter);
    }
  }
  
  public void onRewarded(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter, RewardItem paramRewardItem)
  {
    zzx.zzci("onRewarded must be called on the main UI thread.");
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Adapter called onRewarded.");
    if (paramRewardItem != null) {}
    try
    {
      zzHu.zza(zze.zzy(paramMediationRewardedVideoAdAdapter), new RewardItemParcel(paramRewardItem));
      return;
    }
    catch (RemoteException paramMediationRewardedVideoAdAdapter)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onRewarded.", paramMediationRewardedVideoAdAdapter);
    }
    zzHu.zza(zze.zzy(paramMediationRewardedVideoAdAdapter), new RewardItemParcel(paramMediationRewardedVideoAdAdapter.getClass().getName(), 1));
    return;
  }
  
  public void onVideoStarted(MediationRewardedVideoAdAdapter paramMediationRewardedVideoAdAdapter)
  {
    zzx.zzci("onVideoStarted must be called on the main UI thread.");
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Adapter called onVideoStarted.");
    try
    {
      zzHu.zzj(zze.zzy(paramMediationRewardedVideoAdAdapter));
      return;
    }
    catch (RemoteException paramMediationRewardedVideoAdAdapter)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onVideoStarted.", paramMediationRewardedVideoAdAdapter);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.reward.mediation.client.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */