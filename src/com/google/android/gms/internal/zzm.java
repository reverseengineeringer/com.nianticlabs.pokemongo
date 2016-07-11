package com.google.android.gms.internal;

public class zzm<T>
{
  public final T result;
  public final zzb.zza zzag;
  public final zzr zzah;
  public boolean zzai = false;
  
  private zzm(zzr paramzzr)
  {
    result = null;
    zzag = null;
    zzah = paramzzr;
  }
  
  private zzm(T paramT, zzb.zza paramzza)
  {
    result = paramT;
    zzag = paramzza;
    zzah = null;
  }
  
  public static <T> zzm<T> zza(T paramT, zzb.zza paramzza)
  {
    return new zzm(paramT, paramzza);
  }
  
  public static <T> zzm<T> zzd(zzr paramzzr)
  {
    return new zzm(paramzzr);
  }
  
  public boolean isSuccess()
  {
    return zzah == null;
  }
  
  public static abstract interface zza
  {
    public abstract void zze(zzr paramzzr);
  }
  
  public static abstract interface zzb<T>
  {
    public abstract void zzb(T paramT);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */