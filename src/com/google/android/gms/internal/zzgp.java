package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.formats.zza;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.internal.formats.zzf;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
public class zzgp
  implements zzgm.zza<zzf>
{
  private final boolean zzEa;
  
  public zzgp(boolean paramBoolean)
  {
    zzEa = paramBoolean;
  }
  
  private void zza(zzgm paramzzgm, JSONObject paramJSONObject, zzmi<String, Future<zzc>> paramzzmi)
    throws JSONException
  {
    paramzzmi.put(paramJSONObject.getString("name"), paramzzgm.zza(paramJSONObject, "image_value", zzEa));
  }
  
  private void zza(JSONObject paramJSONObject, zzmi<String, String> paramzzmi)
    throws JSONException
  {
    paramzzmi.put(paramJSONObject.getString("name"), paramJSONObject.getString("string_value"));
  }
  
  private <K, V> zzmi<K, V> zzc(zzmi<K, Future<V>> paramzzmi)
    throws InterruptedException, ExecutionException
  {
    zzmi localzzmi = new zzmi();
    int i = 0;
    while (i < paramzzmi.size())
    {
      localzzmi.put(paramzzmi.keyAt(i), ((Future)paramzzmi.valueAt(i)).get());
      i += 1;
    }
    return localzzmi;
  }
  
  public zzf zzd(zzgm paramzzgm, JSONObject paramJSONObject)
    throws JSONException, InterruptedException, ExecutionException
  {
    zzmi localzzmi1 = new zzmi();
    zzmi localzzmi2 = new zzmi();
    zziq localzziq = paramzzgm.zze(paramJSONObject);
    JSONArray localJSONArray = paramJSONObject.getJSONArray("custom_assets");
    int i = 0;
    if (i < localJSONArray.length())
    {
      JSONObject localJSONObject = localJSONArray.getJSONObject(i);
      String str = localJSONObject.getString("type");
      if ("string".equals(str)) {
        zza(localJSONObject, localzzmi2);
      }
      for (;;)
      {
        i += 1;
        break;
        if ("image".equals(str)) {
          zza(paramzzgm, localJSONObject, localzzmi1);
        } else {
          zzb.zzaH("Unknown custom asset type: " + str);
        }
      }
    }
    return new zzf(paramJSONObject.getString("custom_template_id"), zzc(localzzmi1), localzzmi2, (zza)localzziq.get());
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */