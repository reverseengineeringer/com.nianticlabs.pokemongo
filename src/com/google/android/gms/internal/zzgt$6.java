package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.zzk;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;

class zzgt$6
  implements Runnable
{
  zzgt$6(zzgt paramzzgt, AdRequestInfoParcel paramAdRequestInfoParcel, zzk paramzzk) {}
  
  public void run()
  {
    try
    {
      AdResponseParcel localAdResponseParcel1 = zzFL.zze(zzFJ);
      localAdResponseParcel2 = localAdResponseParcel1;
      if (localAdResponseParcel1 == null) {
        localAdResponseParcel2 = new AdResponseParcel(0);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          AdResponseParcel localAdResponseParcel2;
          zzFM.zzb(localAdResponseParcel2);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          Object localObject;
          zzb.zzd("Fail to forward ad response.", localRemoteException);
        }
        localException = localException;
        zzp.zzby().zzc(localException, true);
        zzb.zzd("Could not fetch ad response due to an Exception.", localException);
        localObject = null;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgt.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */