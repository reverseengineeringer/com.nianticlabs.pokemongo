package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

class zzdv$2
  implements Runnable
{
  zzdv$2(zzdv paramzzdv, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event", "precacheComplete");
    localHashMap.put("src", zzyc);
    localHashMap.put("cachedSrc", zzyd);
    localHashMap.put("totalBytes", Integer.toString(zzyf));
    zzyh.zzoM.zzb("onPrecacheEvent", localHashMap);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdv.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */