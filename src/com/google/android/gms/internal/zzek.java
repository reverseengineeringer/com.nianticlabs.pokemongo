package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzgr
public class zzek
  implements zzec
{
  private final Context mContext;
  private final zzcg zzoo;
  private final zzem zzox;
  private final Object zzpd = new Object();
  private final zzee zzzA;
  private final long zzzB;
  private final long zzzC;
  private boolean zzzD = false;
  private zzeh zzzE;
  private final boolean zzzn;
  private final AdRequestInfoParcel zzzz;
  
  public zzek(Context paramContext, AdRequestInfoParcel paramAdRequestInfoParcel, zzem paramzzem, zzee paramzzee, boolean paramBoolean, long paramLong1, long paramLong2, zzcg paramzzcg)
  {
    mContext = paramContext;
    zzzz = paramAdRequestInfoParcel;
    zzox = paramzzem;
    zzzA = paramzzee;
    zzzn = paramBoolean;
    zzzB = paramLong1;
    zzzC = paramLong2;
    zzoo = paramzzcg;
  }
  
  public void cancel()
  {
    synchronized (zzpd)
    {
      zzzD = true;
      if (zzzE != null) {
        zzzE.cancel();
      }
      return;
    }
  }
  
  public zzei zzc(List<zzed> arg1)
  {
    zzb.zzaF("Starting mediation.");
    Object localObject = new ArrayList();
    zzce localzzce1 = zzoo.zzdn();
    Iterator localIterator1 = ???.iterator();
    while (localIterator1.hasNext())
    {
      zzed localzzed = (zzed)localIterator1.next();
      zzb.zzaG("Trying mediation network: " + zzyN);
      Iterator localIterator2 = zzyO.iterator();
      while (localIterator2.hasNext())
      {
        String str = (String)localIterator2.next();
        zzce localzzce2 = zzoo.zzdn();
        synchronized (zzpd)
        {
          if (zzzD)
          {
            localObject = new zzei(-1);
            return (zzei)localObject;
          }
          zzzE = new zzeh(mContext, str, zzox, zzzA, localzzed, zzzz.zzEn, zzzz.zzqn, zzzz.zzqj, zzzn, zzzz.zzqB, zzzz.zzqD);
          ??? = zzzE.zza(zzzB, zzzC);
          if (zzzt == 0)
          {
            zzb.zzaF("Adapter succeeded.");
            zzoo.zze("mediation_network_succeed", str);
            if (!((List)localObject).isEmpty()) {
              zzoo.zze("mediation_networks_fail", TextUtils.join(",", (Iterable)localObject));
            }
            zzoo.zza(localzzce2, new String[] { "mls" });
            zzoo.zza(localzzce1, new String[] { "ttm" });
            return (zzei)???;
          }
        }
        localIterable.add(str);
        zzoo.zza(localzzce2, new String[] { "mlf" });
        if (zzzv != null) {
          zzid.zzIE.post(new Runnable()
          {
            public void run()
            {
              try
              {
                paramListzzzv.destroy();
                return;
              }
              catch (RemoteException localRemoteException)
              {
                zzb.zzd("Could not destroy mediation adapter.", localRemoteException);
              }
            }
          });
        }
      }
    }
    if (!localIterable.isEmpty()) {
      zzoo.zze("mediation_networks_fail", TextUtils.join(",", localIterable));
    }
    return new zzei(1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzek
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */