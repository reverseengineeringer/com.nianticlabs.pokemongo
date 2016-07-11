package com.google.android.gms.ads.mediation.customevent;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;

@Deprecated
public final class CustomEventExtras
  implements NetworkExtras
{
  private final HashMap<String, Object> zzKQ = new HashMap();
  
  public Object getExtra(String paramString)
  {
    return zzKQ.get(paramString);
  }
  
  public void setExtra(String paramString, Object paramObject)
  {
    zzKQ.put(paramString, paramObject);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.mediation.customevent.CustomEventExtras
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */