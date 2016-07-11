package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.List;

public final class zzw$zza
{
  private final Object zzJm;
  private final List<String> zzago;
  
  private zzw$zza(Object paramObject)
  {
    zzJm = zzx.zzw(paramObject);
    zzago = new ArrayList();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100).append(zzJm.getClass().getSimpleName()).append('{');
    int j = zzago.size();
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append((String)zzago.get(i));
      if (i < j - 1) {
        localStringBuilder.append(", ");
      }
      i += 1;
    }
    return '}';
  }
  
  public zza zzg(String paramString, Object paramObject)
  {
    zzago.add((String)zzx.zzw(paramString) + "=" + String.valueOf(paramObject));
    return this;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzw.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */