package com.google.android.gms.ads.internal.formats;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzbb;
import com.google.android.gms.internal.zziz;
import com.google.android.gms.internal.zzja.zza;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class zzh$1$1
  implements zzja.zza
{
  zzh$1$1(zzh.1 param1, Map paramMap) {}
  
  public void zza(zziz paramzziz, boolean paramBoolean)
  {
    zzh.zza(zzwQ.zzwO, (String)zzwP.get("id"));
    paramzziz = new JSONObject();
    try
    {
      paramzziz.put("messageType", "htmlLoaded");
      paramzziz.put("id", zzh.zzc(zzwQ.zzwO));
      zzh.zzd(zzwQ.zzwO).zzb("sendMessageToNativeJs", paramzziz);
      return;
    }
    catch (JSONException paramzziz)
    {
      zzb.zzb("Unable to dispatch sendMessageToNativeJsevent", paramzziz);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.formats.zzh.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */