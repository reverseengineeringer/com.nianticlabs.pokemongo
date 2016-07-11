package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

class zzdv$3
  implements Runnable
{
  zzdv$3(zzdv paramzzdv, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event", "precacheCanceled");
    localHashMap.put("src", zzyc);
    if (!TextUtils.isEmpty(zzyd)) {
      localHashMap.put("cachedSrc", zzyd);
    }
    localHashMap.put("type", zzdv.zza(zzyh, zzyi));
    localHashMap.put("reason", zzyi);
    if (!TextUtils.isEmpty(zzyj)) {
      localHashMap.put("message", zzyj);
    }
    zzyh.zzoM.zzb("onPrecacheEvent", localHashMap);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdv.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */