package com.google.android.gms.ads.internal.purchase;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzfw;

class zzc$1
  implements Runnable
{
  zzc$1(zzc paramzzc, zzf paramzzf, Intent paramIntent) {}
  
  public void run()
  {
    try
    {
      if (zzc.zza(zzCI).zza(zzCH.zzCR, -1, val$intent))
      {
        zzc.zzc(zzCI).zza(new zzg(zzc.zzb(zzCI), zzCH.zzCS, true, -1, val$intent, zzCH));
        return;
      }
      zzc.zzc(zzCI).zza(new zzg(zzc.zzb(zzCI), zzCH.zzCS, false, -1, val$intent, zzCH));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzaH("Fail to verify and dispatch pending transaction");
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.purchase.zzc.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */