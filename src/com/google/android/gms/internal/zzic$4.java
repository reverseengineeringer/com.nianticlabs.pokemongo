package com.google.android.gms.internal;

import java.util.concurrent.Future;

final class zzic$4
  implements Runnable
{
  zzic$4(zzin paramzzin, Future paramFuture) {}
  
  public void run()
  {
    if (zzrA.isCancelled()) {
      zzIv.cancel(true);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzic.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */