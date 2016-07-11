package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.formats.zza;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.List;

class zzgm$4
  implements zzip.zza<List<zzc>, zza>
{
  zzgm$4(zzgm paramzzgm, String paramString, Integer paramInteger1, Integer paramInteger2, int paramInt1, int paramInt2, int paramInt3) {}
  
  public zza zzf(List<zzc> paramList)
  {
    if (paramList != null) {
      for (;;)
      {
        try
        {
          if (paramList.isEmpty()) {
            break;
          }
          String str = zzDR;
          List localList = zzgm.zze(paramList);
          Integer localInteger1 = zzDS;
          Integer localInteger2 = zzDT;
          if (zzDU > 0)
          {
            paramList = Integer.valueOf(zzDU);
            paramList = new zza(str, localList, localInteger1, localInteger2, paramList, zzDV + zzDW);
          }
        }
        catch (RemoteException paramList)
        {
          zzb.zzb("Could not get attribution icon", paramList);
          return null;
        }
        paramList = null;
      }
    }
    paramList = null;
    return paramList;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgm.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */