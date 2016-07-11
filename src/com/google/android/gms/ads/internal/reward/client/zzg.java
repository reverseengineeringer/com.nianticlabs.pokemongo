package com.google.android.gms.ads.internal.reward.client;

import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class zzg
  extends zzd.zza
{
  private final RewardedVideoAdListener zzHd;
  
  public zzg(RewardedVideoAdListener paramRewardedVideoAdListener)
  {
    zzHd = paramRewardedVideoAdListener;
  }
  
  public void onRewardedVideoAdClosed()
  {
    if (zzHd != null) {
      zzHd.onRewardedVideoAdClosed();
    }
  }
  
  public void onRewardedVideoAdFailedToLoad(int paramInt)
  {
    if (zzHd != null) {
      zzHd.onRewardedVideoAdFailedToLoad(paramInt);
    }
  }
  
  public void onRewardedVideoAdLeftApplication()
  {
    if (zzHd != null) {
      zzHd.onRewardedVideoAdLeftApplication();
    }
  }
  
  public void onRewardedVideoAdLoaded()
  {
    if (zzHd != null) {
      zzHd.onRewardedVideoAdLoaded();
    }
  }
  
  public void onRewardedVideoAdOpened()
  {
    if (zzHd != null) {
      zzHd.onRewardedVideoAdOpened();
    }
  }
  
  public void onRewardedVideoStarted()
  {
    if (zzHd != null) {
      zzHd.onRewardedVideoStarted();
    }
  }
  
  public void zza(zza paramzza)
  {
    if (zzHd != null) {
      zzHd.onRewarded(new zze(paramzza));
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.reward.client.zzg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */