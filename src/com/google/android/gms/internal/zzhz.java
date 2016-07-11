package com.google.android.gms.internal;

import java.util.concurrent.Future;

@zzgr
public abstract class zzhz
  implements zzgh<Future>
{
  private volatile Thread zzIl;
  private boolean zzIm;
  private final Runnable zzx = new Runnable()
  {
    public final void run()
    {
      zzhz.zza(zzhz.this, Thread.currentThread());
      zzbn();
    }
  };
  
  public zzhz()
  {
    zzIm = false;
  }
  
  public zzhz(boolean paramBoolean)
  {
    zzIm = paramBoolean;
  }
  
  public final void cancel()
  {
    onStop();
    if (zzIl != null) {
      zzIl.interrupt();
    }
  }
  
  public abstract void onStop();
  
  public abstract void zzbn();
  
  public final Future zzgz()
  {
    if (zzIm) {
      return zzic.zza(1, zzx);
    }
    return zzic.zza(zzx);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzhz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */