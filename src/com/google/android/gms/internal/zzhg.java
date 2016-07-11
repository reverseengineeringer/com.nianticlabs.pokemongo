package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.internal.zzx;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

@zzgr
public class zzhg
  extends com.google.android.gms.ads.internal.zzb
  implements zzhk
{
  private zzd zzGX;
  private String zzGY;
  private boolean zzGZ;
  private HashMap<String, zzhh> zzHa = new HashMap();
  
  public zzhg(Context paramContext, AdSizeParcel paramAdSizeParcel, zzem paramzzem, VersionInfoParcel paramVersionInfoParcel)
  {
    super(paramContext, paramAdSizeParcel, null, paramzzem, paramVersionInfoParcel, null);
  }
  
  public void destroy()
  {
    zzx.zzci("destroy must be called on the main UI thread.");
    Iterator localIterator = zzHa.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        zzhh localzzhh = (zzhh)zzHa.get(str);
        if ((localzzhh != null) && (localzzhh.zzgc() != null)) {
          localzzhh.zzgc().destroy();
        }
      }
      catch (RemoteException localRemoteException)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Fail to destroy adapter: " + str);
      }
    }
  }
  
  public boolean isLoaded()
  {
    zzx.zzci("isLoaded must be called on the main UI thread.");
    return (zzot.zzql == null) && (zzot.zzqm == null) && (zzot.zzqo != null) && (!zzGZ);
  }
  
  public void onRewardedVideoAdClosed()
  {
    if (zzGX == null) {
      return;
    }
    try
    {
      zzGX.onRewardedVideoAdClosed();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onAdClosed().", localRemoteException);
    }
  }
  
  public void onRewardedVideoAdLeftApplication()
  {
    if (zzGX == null) {
      return;
    }
    try
    {
      zzGX.onRewardedVideoAdLeftApplication();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onAdLeftApplication().", localRemoteException);
    }
  }
  
  public void onRewardedVideoAdOpened()
  {
    zza(zzot.zzqo, false);
    if (zzGX == null) {
      return;
    }
    try
    {
      zzGX.onRewardedVideoAdOpened();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onAdOpened().", localRemoteException);
    }
  }
  
  public void onRewardedVideoStarted()
  {
    zzp.zzbH().zza(zzot.context, zzot.zzqj.zzJu, zzot.zzqo, zzot.zzqh, false, zzot.zzqo.zzzu.zzyU);
    if (zzGX == null) {
      return;
    }
    try
    {
      zzGX.onRewardedVideoStarted();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onVideoStarted().", localRemoteException);
    }
  }
  
  public void pause()
  {
    zzx.zzci("pause must be called on the main UI thread.");
    Iterator localIterator = zzHa.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        zzhh localzzhh = (zzhh)zzHa.get(str);
        if ((localzzhh != null) && (localzzhh.zzgc() != null)) {
          localzzhh.zzgc().pause();
        }
      }
      catch (RemoteException localRemoteException)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Fail to pause adapter: " + str);
      }
    }
  }
  
  public void resume()
  {
    zzx.zzci("resume must be called on the main UI thread.");
    Iterator localIterator = zzHa.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        zzhh localzzhh = (zzhh)zzHa.get(str);
        if ((localzzhh != null) && (localzzhh.zzgc() != null)) {
          localzzhh.zzgc().resume();
        }
      }
      catch (RemoteException localRemoteException)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Fail to resume adapter: " + str);
      }
    }
  }
  
  public void setUserId(String paramString)
  {
    zzx.zzci("setUserId must be called on the main UI thread.");
    zzGY = paramString;
  }
  
  public void zza(RewardedVideoAdRequestParcel paramRewardedVideoAdRequestParcel)
  {
    zzx.zzci("loadAd must be called on the main UI thread.");
    if (TextUtils.isEmpty(zzqh))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("Invalid ad unit id. Aborting.");
      return;
    }
    zzGZ = false;
    zzot.zzqh = zzqh;
    super.zzb(zzEn);
  }
  
  public void zza(zzd paramzzd)
  {
    zzx.zzci("setRewardedVideoAdListener must be called on the main UI thread.");
    zzGX = paramzzd;
  }
  
  public void zza(RewardItemParcel paramRewardItemParcel)
  {
    zzp.zzbH().zza(zzot.context, zzot.zzqj.zzJu, zzot.zzqo, zzot.zzqh, false, zzot.zzqo.zzzu.zzyV);
    if (zzGX == null) {
      return;
    }
    try
    {
      if ((zzot.zzqo != null) && (zzot.zzqo.zzHx != null) && (!TextUtils.isEmpty(zzot.zzqo.zzHx.zzzd)))
      {
        zzGX.zza(new zzhe(zzot.zzqo.zzHx.zzzd, zzot.zzqo.zzHx.zzze));
        return;
      }
    }
    catch (RemoteException paramRewardItemParcel)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onRewarded().", paramRewardItemParcel);
      return;
    }
    zzGX.zza(new zzhe(type, zzHv));
  }
  
  public void zza(final zzhs.zza paramzza, zzcg paramzzcg)
  {
    if (errorCode != -2)
    {
      zzid.zzIE.post(new Runnable()
      {
        public void run()
        {
          zzb(new zzhs(paramzza, null, null, null, null, null, null));
        }
      });
      return;
    }
    zzot.zzqH = 0;
    zzot.zzqm = new zzhn(zzot.context, zzGY, paramzza, this);
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("AdRenderer: " + zzot.zzqm.getClass().getName());
    zzot.zzqm.zzfu();
  }
  
  public boolean zza(zzhs paramzzhs1, zzhs paramzzhs2)
  {
    if (zzGX != null) {}
    try
    {
      zzGX.onRewardedVideoAdLoaded();
      return true;
    }
    catch (RemoteException paramzzhs1)
    {
      for (;;)
      {
        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onAdLoaded().", paramzzhs1);
      }
    }
  }
  
  public zzhh zzau(String paramString)
  {
    localObject1 = (zzhh)zzHa.get(paramString);
    Object localObject2 = localObject1;
    if (localObject1 == null) {}
    try
    {
      localObject2 = new zzhh(zzox.zzae(paramString), this);
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Fail to instantiate adapter " + paramString, localException1);
    }
    catch (Exception localException1)
    {
      try
      {
        zzHa.put(paramString, localObject2);
        return (zzhh)localObject2;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localObject1 = localException1;
          Object localObject3 = localException2;
        }
      }
      localException1 = localException1;
    }
    return (zzhh)localObject1;
  }
  
  protected boolean zze(int paramInt)
  {
    com.google.android.gms.ads.internal.util.client.zzb.zzaH("Failed to load ad: " + paramInt);
    if (zzGX == null) {
      return false;
    }
    try
    {
      zzGX.onRewardedVideoAdFailedToLoad(paramInt);
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onAdFailedToLoad().", localRemoteException);
    }
    return false;
  }
  
  public void zzga()
  {
    zzx.zzci("showAd must be called on the main UI thread.");
    if (!isLoaded()) {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("The reward video has not loaded.");
    }
    zzhh localzzhh;
    do
    {
      return;
      zzGZ = true;
      localzzhh = zzau(zzot.zzqo.zzzw);
    } while ((localzzhh == null) || (localzzhh.zzgc() == null));
    try
    {
      localzzhh.zzgc().showVideo();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call showVideo.", localRemoteException);
    }
  }
  
  public void zzgb()
  {
    onAdClicked();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzhg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */