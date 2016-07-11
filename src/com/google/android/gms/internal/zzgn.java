package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.ads.internal.formats.zza;
import com.google.android.gms.ads.internal.formats.zzd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
public class zzgn
  implements zzgm.zza<zzd>
{
  private final boolean zzEa;
  private final boolean zzEb;
  
  public zzgn(boolean paramBoolean1, boolean paramBoolean2)
  {
    zzEa = paramBoolean1;
    zzEb = paramBoolean2;
  }
  
  public zzd zzb(zzgm paramzzgm, JSONObject paramJSONObject)
    throws JSONException, InterruptedException, ExecutionException
  {
    Object localObject = paramzzgm.zza(paramJSONObject, "images", true, zzEa, zzEb);
    zziq localzziq = paramzzgm.zza(paramJSONObject, "app_icon", true, zzEa);
    paramzzgm = paramzzgm.zze(paramJSONObject);
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((zziq)((Iterator)localObject).next()).get());
    }
    return new zzd(paramJSONObject.getString("headline"), localArrayList, paramJSONObject.getString("body"), (zzcm)localzziq.get(), paramJSONObject.getString("call_to_action"), paramJSONObject.optDouble("rating", -1.0D), paramJSONObject.optString("store"), paramJSONObject.optString("price"), (zza)paramzzgm.get(), new Bundle());
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */