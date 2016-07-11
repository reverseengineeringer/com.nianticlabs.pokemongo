package com.google.android.gms.internal;

import android.os.Process;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Callable;

final class zzic$3
  implements Runnable
{
  zzic$3(zzin paramzzin, Callable paramCallable) {}
  
  public void run()
  {
    try
    {
      Process.setThreadPriority(10);
      zzrA.zzf(zzIu.call());
      return;
    }
    catch (Exception localException)
    {
      zzp.zzby().zzc(localException, true);
      zzrA.cancel(true);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzic.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */