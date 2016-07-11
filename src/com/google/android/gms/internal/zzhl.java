package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.zza.zza;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;

@zzgr
public class zzhl
  extends zza.zza
{
  private zzhm zzHh;
  private zzhj zzHn;
  private zzhk zzHo;
  
  public zzhl(zzhk paramzzhk)
  {
    zzHo = paramzzhk;
  }
  
  public void zza(zzd paramzzd, RewardItemParcel paramRewardItemParcel)
  {
    if (zzHo != null) {
      zzHo.zza(paramRewardItemParcel);
    }
  }
  
  public void zza(zzhj paramzzhj)
  {
    zzHn = paramzzhj;
  }
  
  public void zza(zzhm paramzzhm)
  {
    zzHh = paramzzhm;
  }
  
  public void zzb(zzd paramzzd, int paramInt)
  {
    if (zzHn != null) {
      zzHn.zzK(paramInt);
    }
  }
  
  public void zzc(zzd paramzzd, int paramInt)
  {
    if (zzHh != null) {
      zzHh.zzb(zze.zzp(paramzzd).getClass().getName(), paramInt);
    }
  }
  
  public void zzg(zzd paramzzd)
  {
    if (zzHn != null) {
      zzHn.zzge();
    }
  }
  
  public void zzh(zzd paramzzd)
  {
    if (zzHh != null) {
      zzHh.zzav(zze.zzp(paramzzd).getClass().getName());
    }
  }
  
  public void zzi(zzd paramzzd)
  {
    if (zzHo != null) {
      zzHo.onRewardedVideoAdOpened();
    }
  }
  
  public void zzj(zzd paramzzd)
  {
    if (zzHo != null) {
      zzHo.onRewardedVideoStarted();
    }
  }
  
  public void zzk(zzd paramzzd)
  {
    if (zzHo != null) {
      zzHo.onRewardedVideoAdClosed();
    }
  }
  
  public void zzl(zzd paramzzd)
  {
    if (zzHo != null) {
      zzHo.zzgb();
    }
  }
  
  public void zzm(zzd paramzzd)
  {
    if (zzHo != null) {
      zzHo.onRewardedVideoAdLeftApplication();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzhl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */