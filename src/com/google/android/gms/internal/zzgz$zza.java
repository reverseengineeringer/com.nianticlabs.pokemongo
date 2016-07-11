package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzp;

class zzgz$zza
{
  public final long zzGP = zzp.zzbz().currentTimeMillis();
  public final zzgy zzGQ;
  
  public zzgz$zza(zzgz paramzzgz, zzgy paramzzgy)
  {
    zzGQ = paramzzgy;
  }
  
  public boolean hasExpired()
  {
    long l = zzGP;
    return ((Long)zzby.zzvn.get()).longValue() + l < zzp.zzbz().currentTimeMillis();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgz.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */