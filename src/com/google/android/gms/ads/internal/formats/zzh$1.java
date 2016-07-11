package com.google.android.gms.ads.internal.formats;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzbb;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zziz;
import com.google.android.gms.internal.zzja;
import com.google.android.gms.internal.zzja.zza;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class zzh$1
  implements zzdk
{
  zzh$1(zzh paramzzh) {}
  
  public void zza(zziz paramzziz, final Map<String, String> paramMap)
  {
    zzh.zze(zzwO).zzhe().zza(new zzja.zza()
    {
      public void zza(zziz paramAnonymouszziz, boolean paramAnonymousBoolean)
      {
        zzh.zza(zzwO, (String)paramMap.get("id"));
        paramAnonymouszziz = new JSONObject();
        try
        {
          paramAnonymouszziz.put("messageType", "htmlLoaded");
          paramAnonymouszziz.put("id", zzh.zzc(zzwO));
          zzh.zzd(zzwO).zzb("sendMessageToNativeJs", paramAnonymouszziz);
          return;
        }
        catch (JSONException paramAnonymouszziz)
        {
          zzb.zzb("Unable to dispatch sendMessageToNativeJsevent", paramAnonymouszziz);
        }
      }
    });
    paramzziz = (String)paramMap.get("overlayHtml");
    paramMap = (String)paramMap.get("baseUrl");
    if (TextUtils.isEmpty(paramMap))
    {
      zzh.zze(zzwO).loadData(paramzziz, "text/html", "UTF-8");
      return;
    }
    zzh.zze(zzwO).loadDataWithBaseURL(paramMap, paramzziz, "text/html", "UTF-8", null);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.formats.zzh.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */