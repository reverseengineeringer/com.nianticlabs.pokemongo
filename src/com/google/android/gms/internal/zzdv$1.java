package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

class zzdv$1
  implements Runnable
{
  zzdv$1(zzdv paramzzdv, String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event", "precacheProgress");
    localHashMap.put("src", zzyc);
    localHashMap.put("cachedSrc", zzyd);
    localHashMap.put("bytesLoaded", Integer.toString(zzye));
    localHashMap.put("totalBytes", Integer.toString(zzyf));
    if (zzyg) {}
    for (String str = "1";; str = "0")
    {
      localHashMap.put("cacheReady", str);
      zzyh.zzoM.zzb("onPrecacheEvent", localHashMap);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdv.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */