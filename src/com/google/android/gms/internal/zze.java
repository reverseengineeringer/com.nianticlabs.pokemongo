package com.google.android.gms.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

public class zze
  implements zzn
{
  private final Executor zzs;
  
  public zze(final Handler paramHandler)
  {
    zzs = new Executor()
    {
      public void execute(Runnable paramAnonymousRunnable)
      {
        paramHandler.post(paramAnonymousRunnable);
      }
    };
  }
  
  public void zza(zzk<?> paramzzk, zzm<?> paramzzm)
  {
    zza(paramzzk, paramzzm, null);
  }
  
  public void zza(zzk<?> paramzzk, zzm<?> paramzzm, Runnable paramRunnable)
  {
    paramzzk.zzv();
    paramzzk.zzc("post-response");
    zzs.execute(new zza(paramzzk, paramzzm, paramRunnable));
  }
  
  public void zza(zzk<?> paramzzk, zzr paramzzr)
  {
    paramzzk.zzc("post-error");
    paramzzr = zzm.zzd(paramzzr);
    zzs.execute(new zza(paramzzk, paramzzr, null));
  }
  
  private class zza
    implements Runnable
  {
    private final zzk zzv;
    private final zzm zzw;
    private final Runnable zzx;
    
    public zza(zzk paramzzk, zzm paramzzm, Runnable paramRunnable)
    {
      zzv = paramzzk;
      zzw = paramzzm;
      zzx = paramRunnable;
    }
    
    public void run()
    {
      if (zzv.isCanceled()) {
        zzv.zzd("canceled-at-delivery");
      }
      label97:
      label107:
      for (;;)
      {
        return;
        if (zzw.isSuccess())
        {
          zzv.zza(zzw.result);
          if (!zzw.zzai) {
            break label97;
          }
          zzv.zzc("intermediate-response");
        }
        for (;;)
        {
          if (zzx == null) {
            break label107;
          }
          zzx.run();
          return;
          zzv.zzc(zzw.zzah);
          break;
          zzv.zzd("done");
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */