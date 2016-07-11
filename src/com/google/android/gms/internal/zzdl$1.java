package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;
import org.json.JSONObject;

class zzdl$1
  implements Runnable
{
  zzdl$1(zzdl paramzzdl, Map paramMap, zziz paramzziz) {}
  
  public void run()
  {
    zzb.zzaF("Received Http request.");
    final Object localObject = (String)zzwP.get("http_request");
    localObject = zzxC.zzX((String)localObject);
    if (localObject == null)
    {
      zzb.e("Response should not be null.");
      return;
    }
    zzid.zzIE.post(new Runnable()
    {
      public void run()
      {
        zzxB.zzb("fetchHttpRequestCompleted", localObject);
        zzb.zzaF("Dispatched http response.");
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdl.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */