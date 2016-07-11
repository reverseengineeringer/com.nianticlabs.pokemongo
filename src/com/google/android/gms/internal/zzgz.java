package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import java.util.WeakHashMap;

@zzgr
public final class zzgz
{
  private WeakHashMap<Context, zza> zzGO = new WeakHashMap();
  
  public zzgy zzC(Context paramContext)
  {
    Object localObject = (zza)zzGO.get(paramContext);
    if ((localObject != null) && (!((zza)localObject).hasExpired()) && (((Boolean)zzby.zzvm.get()).booleanValue())) {}
    for (localObject = new zzgy.zza(paramContext, zzGQ).zzfX();; localObject = new zzgy.zza(paramContext).zzfX())
    {
      zzGO.put(paramContext, new zza((zzgy)localObject));
      return (zzgy)localObject;
    }
  }
  
  private class zza
  {
    public final long zzGP = zzp.zzbz().currentTimeMillis();
    public final zzgy zzGQ;
    
    public zza(zzgy paramzzgy)
    {
      zzGQ = paramzzgy;
    }
    
    public boolean hasExpired()
    {
      long l = zzGP;
      return ((Long)zzby.zzvn.get()).longValue() + l < zzp.zzbz().currentTimeMillis();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */