package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;

@zzgr
public class zzhn
  extends zzhz
  implements zzhm
{
  private final Context mContext;
  private final zzhs.zza zzDe;
  private final String zzGY;
  private final ArrayList<Future> zzHp = new ArrayList();
  private final ArrayList<String> zzHq = new ArrayList();
  private final HashSet<String> zzHr = new HashSet();
  private final zzhg zzHs;
  private final Object zzpd = new Object();
  
  public zzhn(Context paramContext, String paramString, zzhs.zza paramzza, zzhg paramzzhg)
  {
    mContext = paramContext;
    zzGY = paramString;
    zzDe = paramzza;
    zzHs = paramzzhg;
  }
  
  private void zzk(String paramString1, String paramString2)
  {
    synchronized (zzpd)
    {
      zzhh localzzhh = zzHs.zzau(paramString1);
      if ((localzzhh == null) || (localzzhh.zzgd() == null) || (localzzhh.zzgc() == null)) {
        return;
      }
      paramString2 = new zzhi(mContext, paramString1, zzGY, paramString2, zzDe, localzzhh, this);
      zzHp.add(paramString2.zzgz());
      zzHq.add(paramString1);
      return;
    }
  }
  
  public void onStop() {}
  
  public void zzav(String paramString)
  {
    synchronized (zzpd)
    {
      zzHr.add(paramString);
      return;
    }
  }
  
  public void zzb(String paramString, int paramInt) {}
  
  public void zzbn()
  {
    ??? = zzDe.zzHx.zzyW.iterator();
    final Object localObject2;
    while (((Iterator)???).hasNext())
    {
      Object localObject4 = (zzed)((Iterator)???).next();
      localObject2 = zzyT;
      localObject4 = zzyO.iterator();
      while (((Iterator)localObject4).hasNext()) {
        zzk((String)((Iterator)localObject4).next(), (String)localObject2);
      }
    }
    int i = 0;
    for (;;)
    {
      if (i < zzHp.size()) {}
      try
      {
        ((Future)zzHp.get(i)).get();
        synchronized (zzpd)
        {
          if (zzHr.contains(zzHq.get(i)))
          {
            localObject2 = (String)zzHq.get(i);
            localObject2 = new zzhs(zzDe.zzHC.zzEn, null, zzDe.zzHD.zzyY, -2, zzDe.zzHD.zzyZ, zzDe.zzHD.zzEM, zzDe.zzHD.orientation, zzDe.zzHD.zzzc, zzDe.zzHC.zzEq, zzDe.zzHD.zzEK, (zzed)zzDe.zzHx.zzyW.get(i), null, (String)localObject2, zzDe.zzHx, null, zzDe.zzHD.zzEL, zzDe.zzqn, zzDe.zzHD.zzEJ, zzDe.zzHz, zzDe.zzHD.zzEO, zzDe.zzHD.zzEP, zzDe.zzHw, null);
            zza.zzJt.post(new Runnable()
            {
              public void run()
              {
                zzhn.zza(zzhn.this).zzb(localObject2);
              }
            });
            return;
          }
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        final zzhs localzzhs = new zzhs(zzDe.zzHC.zzEn, null, zzDe.zzHD.zzyY, 3, zzDe.zzHD.zzyZ, zzDe.zzHD.zzEM, zzDe.zzHD.orientation, zzDe.zzHD.zzzc, zzDe.zzHC.zzEq, zzDe.zzHD.zzEK, null, null, null, zzDe.zzHx, null, zzDe.zzHD.zzEL, zzDe.zzqn, zzDe.zzHD.zzEJ, zzDe.zzHz, zzDe.zzHD.zzEO, zzDe.zzHD.zzEP, zzDe.zzHw, null);
        zza.zzJt.post(new Runnable()
        {
          public void run()
          {
            zzhn.zza(zzhn.this).zzb(localzzhs);
          }
        });
        return;
      }
      catch (Exception localException)
      {
        i += 1;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzhn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */