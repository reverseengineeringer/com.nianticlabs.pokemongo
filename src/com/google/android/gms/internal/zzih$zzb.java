package com.google.android.gms.internal;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class zzih$zzb<T>
  extends zzk<InputStream>
{
  private final zzih.zza<T> zzJe;
  private final zzm.zzb<T> zzaG;
  
  public zzih$zzb(String paramString, final zzih.zza<T> paramzza, zzm.zzb<T> paramzzb)
  {
    super(0, paramString, new zzm.zza()
    {
      public void zze(zzr paramAnonymouszzr)
      {
        zzb(paramzza.zzfF());
      }
    });
    zzJe = paramzza;
    zzaG = paramzzb;
  }
  
  protected zzm<InputStream> zza(zzi paramzzi)
  {
    return zzm.zza(new ByteArrayInputStream(data), zzx.zzb(paramzzi));
  }
  
  protected void zzj(InputStream paramInputStream)
  {
    zzaG.zzb(zzJe.zzh(paramInputStream));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzih.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */