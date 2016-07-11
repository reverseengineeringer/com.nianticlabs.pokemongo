package com.google.android.gms.ads.internal.request;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzbe;
import com.google.android.gms.internal.zzdp;
import com.google.android.gms.internal.zzdz;
import com.google.android.gms.internal.zzdz.zzd;
import com.google.android.gms.internal.zzis.zza;
import com.google.android.gms.internal.zzis.zzc;
import org.json.JSONObject;

class zzm$2
  implements Runnable
{
  zzm$2(zzm paramzzm, JSONObject paramJSONObject, String paramString) {}
  
  public void run()
  {
    zzm.zza(zzFp, zzm.zzfO().zzdO());
    zzm.zzb(zzFp).zza(new zzis.zzc()new zzis.zza
    {
      public void zzb(zzbe paramAnonymouszzbe)
      {
        try
        {
          paramAnonymouszzbe.zza("AFMA_getAdapterLessMediationAd", zzFq);
          return;
        }
        catch (Exception paramAnonymouszzbe)
        {
          zzb.zzb("Error requesting an ad url", paramAnonymouszzbe);
          zzm.zzfN().zzZ(zzFr);
        }
      }
    }, new zzis.zza()
    {
      public void run()
      {
        zzm.zzfN().zzZ(zzFr);
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.zzm.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */