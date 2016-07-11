package com.google.android.gms.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

final class zzip$1
  implements Runnable
{
  zzip$1(zzin paramzzin, zzip.zza paramzza, zziq paramzziq) {}
  
  public void run()
  {
    try
    {
      zzJB.zzf(zzJC.zze(zzJD.get()));
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      zzJB.cancel(true);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
    catch (CancellationException localCancellationException)
    {
      for (;;) {}
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzip.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */