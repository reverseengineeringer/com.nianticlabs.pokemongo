package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.reward.client.zzb.zza;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

public class zzhf
  extends zzb.zza
{
  private final Context mContext;
  private final zzhg zzGW;
  private final VersionInfoParcel zzpb;
  private final Object zzpd;
  
  public zzhf(Context paramContext, zzem paramzzem, VersionInfoParcel paramVersionInfoParcel)
  {
    mContext = paramContext;
    zzpb = paramVersionInfoParcel;
    zzGW = new zzhg(paramContext, AdSizeParcel.zzcC(), paramzzem, paramVersionInfoParcel);
    zzpd = new Object();
  }
  
  public void destroy()
  {
    synchronized (zzpd)
    {
      zzGW.destroy();
      return;
    }
  }
  
  public boolean isLoaded()
  {
    synchronized (zzpd)
    {
      boolean bool = zzGW.isLoaded();
      return bool;
    }
  }
  
  public void pause()
  {
    synchronized (zzpd)
    {
      zzGW.pause();
      return;
    }
  }
  
  public void resume()
  {
    synchronized (zzpd)
    {
      zzGW.resume();
      return;
    }
  }
  
  public void setUserId(String paramString)
  {
    synchronized (zzpd)
    {
      zzGW.setUserId(paramString);
      return;
    }
  }
  
  public void show()
  {
    synchronized (zzpd)
    {
      zzGW.zzga();
      return;
    }
  }
  
  public void zza(RewardedVideoAdRequestParcel paramRewardedVideoAdRequestParcel)
  {
    synchronized (zzpd)
    {
      zzGW.zza(paramRewardedVideoAdRequestParcel);
      return;
    }
  }
  
  public void zza(zzd paramzzd)
  {
    synchronized (zzpd)
    {
      zzGW.zza(paramzzd);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzhf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */