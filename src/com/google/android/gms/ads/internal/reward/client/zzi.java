package com.google.android.gms.ads.internal.reward.client;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.client.zzh;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class zzi
  implements RewardedVideoAd
{
  private final Context mContext;
  private String zzGY;
  private RewardedVideoAdListener zzHd;
  private final zzb zzHe;
  private final Object zzpd = new Object();
  
  public zzi(Context paramContext, zzb paramzzb)
  {
    zzHe = paramzzb;
    mContext = paramContext;
  }
  
  public void destroy()
  {
    synchronized (zzpd)
    {
      if (zzHe == null) {
        return;
      }
    }
    try
    {
      zzHe.destroy();
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not forward destroy to RewardedVideoAd", localRemoteException);
      }
    }
  }
  
  public RewardedVideoAdListener getRewardedVideoAdListener()
  {
    synchronized (zzpd)
    {
      RewardedVideoAdListener localRewardedVideoAdListener = zzHd;
      return localRewardedVideoAdListener;
    }
  }
  
  public String getUserId()
  {
    synchronized (zzpd)
    {
      String str = zzGY;
      return str;
    }
  }
  
  public boolean isLoaded()
  {
    boolean bool;
    synchronized (zzpd)
    {
      if (zzHe == null) {
        return false;
      }
    }
    return false;
  }
  
  public void loadAd(String paramString, AdRequest paramAdRequest)
  {
    synchronized (zzpd)
    {
      if (zzHe == null) {
        return;
      }
    }
    try
    {
      zzHe.zza(zzh.zzcB().zza(mContext, paramAdRequest.zzaF(), paramString));
      return;
      paramString = finally;
      throw paramString;
    }
    catch (RemoteException paramString)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not forward loadAd to RewardedVideoAd", paramString);
      }
    }
  }
  
  public void pause()
  {
    synchronized (zzpd)
    {
      if (zzHe == null) {
        return;
      }
    }
    try
    {
      zzHe.pause();
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not forward pause to RewardedVideoAd", localRemoteException);
      }
    }
  }
  
  public void resume()
  {
    synchronized (zzpd)
    {
      if (zzHe == null) {
        return;
      }
    }
    try
    {
      zzHe.resume();
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not forward resume to RewardedVideoAd", localRemoteException);
      }
    }
  }
  
  public void setRewardedVideoAdListener(RewardedVideoAdListener paramRewardedVideoAdListener)
  {
    synchronized (zzpd)
    {
      zzHd = paramRewardedVideoAdListener;
      zzb localzzb = zzHe;
      if (localzzb != null) {}
      try
      {
        zzHe.zza(new zzg(paramRewardedVideoAdListener));
        return;
      }
      catch (RemoteException paramRewardedVideoAdListener)
      {
        for (;;)
        {
          com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not forward setRewardedVideoAdListener to RewardedVideoAd", paramRewardedVideoAdListener);
        }
      }
    }
  }
  
  public void setUserId(String paramString)
  {
    synchronized (zzpd)
    {
      if (!TextUtils.isEmpty(zzGY))
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("A user id has already been set, ignoring.");
        return;
      }
      zzGY = paramString;
      zzb localzzb = zzHe;
      if (localzzb == null) {}
    }
    try
    {
      zzHe.setUserId(paramString);
      return;
      paramString = finally;
      throw paramString;
    }
    catch (RemoteException paramString)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not forward setUserId to RewardedVideoAd", paramString);
      }
    }
  }
  
  public void show()
  {
    synchronized (zzpd)
    {
      if (zzHe == null) {
        return;
      }
    }
    try
    {
      zzHe.show();
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not forward show to RewardedVideoAd", localRemoteException);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.reward.client.zzi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */