package com.google.android.gms.ads.internal.reward.client;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.reward.RewardItem;

public class zze
  implements RewardItem
{
  private final zza zzHc;
  
  public zze(zza paramzza)
  {
    zzHc = paramzza;
  }
  
  public int getAmount()
  {
    if (zzHc == null) {
      return 0;
    }
    try
    {
      int i = zzHc.getAmount();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not forward getAmount to RewardItem", localRemoteException);
    }
    return 0;
  }
  
  public String getType()
  {
    if (zzHc == null) {
      return null;
    }
    try
    {
      String str = zzHc.getType();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not forward getType to RewardItem", localRemoteException);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.reward.client.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */