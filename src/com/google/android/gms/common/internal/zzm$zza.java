package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Intent;

final class zzm$zza
{
  private final String zzPp;
  private final ComponentName zzagb;
  
  public zzm$zza(ComponentName paramComponentName)
  {
    zzPp = null;
    zzagb = ((ComponentName)zzx.zzw(paramComponentName));
  }
  
  public zzm$zza(String paramString)
  {
    zzPp = zzx.zzcr(paramString);
    zzagb = null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof zza)) {
        return false;
      }
      paramObject = (zza)paramObject;
    } while ((zzw.equal(zzPp, zzPp)) && (zzw.equal(zzagb, zzagb)));
    return false;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { zzPp, zzagb });
  }
  
  public String toString()
  {
    if (zzPp == null) {
      return zzagb.flattenToString();
    }
    return zzPp;
  }
  
  public Intent zzpm()
  {
    if (zzPp != null) {
      return new Intent(zzPp).setPackage("com.google.android.gms");
    }
    return new Intent().setComponent(zzagb);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzm.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */