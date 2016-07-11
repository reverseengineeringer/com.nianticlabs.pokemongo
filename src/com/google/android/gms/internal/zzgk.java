package com.google.android.gms.internal;

import android.content.Context;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import java.util.List;

@zzgr
public class zzgk
  extends zzgf
{
  protected zzei zzDA;
  private zzec zzDz;
  private final zzcg zzoo;
  private zzem zzox;
  private zzee zzzA;
  
  zzgk(Context paramContext, zzhs.zza paramzza, zzem paramzzem, zzgg.zza paramzza1, zzcg paramzzcg)
  {
    super(paramContext, paramzza, paramzza1);
    zzox = paramzzem;
    zzzA = zzHx;
    zzoo = paramzzcg;
  }
  
  public void onStop()
  {
    synchronized (zzDh)
    {
      super.onStop();
      if (zzDz != null) {
        zzDz.cancel();
      }
      return;
    }
  }
  
  protected zzhs zzA(int paramInt)
  {
    Object localObject = zzDe.zzHC;
    AdRequestParcel localAdRequestParcel = zzEn;
    List localList1 = zzDf.zzyY;
    List localList2 = zzDf.zzyZ;
    List localList3 = zzDf.zzEM;
    int i = zzDf.orientation;
    long l = zzDf.zzzc;
    String str2 = zzEq;
    boolean bool = zzDf.zzEK;
    zzen localzzen;
    label107:
    String str1;
    label123:
    zzee localzzee;
    if (zzDA != null)
    {
      localObject = zzDA.zzzu;
      if (zzDA == null) {
        break label235;
      }
      localzzen = zzDA.zzzv;
      if (zzDA == null) {
        break label241;
      }
      str1 = zzDA.zzzw;
      localzzee = zzzA;
      if (zzDA == null) {
        break label251;
      }
    }
    label235:
    label241:
    label251:
    for (zzeg localzzeg = zzDA.zzzx;; localzzeg = null)
    {
      return new zzhs(localAdRequestParcel, null, localList1, paramInt, localList2, localList3, i, l, str2, bool, (zzed)localObject, localzzen, str1, localzzee, localzzeg, zzDf.zzEL, zzDe.zzqn, zzDf.zzEJ, zzDe.zzHz, zzDf.zzEO, zzDf.zzEP, zzDe.zzHw, null);
      localObject = null;
      break;
      localzzen = null;
      break label107;
      str1 = AdMobAdapter.class.getName();
      break label123;
    }
  }
  
  protected void zzh(long paramLong)
    throws zzgf.zza
  {
    synchronized (zzDh)
    {
      zzDz = new zzek(mContext, zzDe.zzHC, zzox, zzzA, zzDf.zzth, paramLong, ((Long)zzby.zzvw.get()).longValue(), zzoo);
      zzDA = zzDz.zzc(zzzA.zzyW);
      switch (zzDA.zzzt)
      {
      default: 
        throw new zzgf.zza("Unexpected mediation result: " + zzDA.zzzt, 0);
      }
    }
    throw new zzgf.zza("No fill from any mediation ad networks.", 3);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */