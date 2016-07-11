package com.google.android.gms.ads.internal.formats;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzbb;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zziz;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class zzh$5
  implements zzdk
{
  zzh$5(zzh paramzzh) {}
  
  public void zza(zziz paramzziz, Map<String, String> paramMap)
  {
    paramzziz = new JSONObject();
    try
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramzziz.put(str, paramMap.get(str));
      }
      paramzziz.put("id", zzh.zzc(zzwO));
    }
    catch (JSONException paramzziz)
    {
      zzb.zzb("Unable to dispatch sendMessageToNativeJs event", paramzziz);
      return;
    }
    zzh.zzd(zzwO).zzb("sendMessageToNativeJs", paramzziz);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.formats.zzh.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */