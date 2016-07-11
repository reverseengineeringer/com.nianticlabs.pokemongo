package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzx;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class zzgm$1
  implements zzdk
{
  zzgm$1(zzgm paramzzgm, zzbb paramzzbb, zzgm.zzb paramzzb, zzin paramzzin) {}
  
  public void zza(zziz paramzziz, Map<String, String> paramMap)
  {
    zzDK.zzb("/nativeAdPreProcess", zzDL.zzDZ);
    try
    {
      paramzziz = (String)paramMap.get("success");
      if (!TextUtils.isEmpty(paramzziz))
      {
        zzDM.zzf(new JSONObject(paramzziz).getJSONArray("ads").getJSONObject(0));
        return;
      }
    }
    catch (JSONException paramzziz)
    {
      zzb.zzb("Malformed native JSON response.", paramzziz);
      zzDN.zzC(0);
      zzx.zza(zzDN.zzfD(), "Unable to set the ad state error!");
      zzDM.zzf(null);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgm.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */