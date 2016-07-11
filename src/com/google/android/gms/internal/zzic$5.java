package com.google.android.gms.internal;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class zzic$5
  implements ThreadFactory
{
  private final AtomicInteger zzIw = new AtomicInteger(1);
  
  zzic$5(String paramString) {}
  
  public Thread newThread(Runnable paramRunnable)
  {
    return new Thread(paramRunnable, "AdWorker(" + zzIx + ") #" + zzIw.getAndIncrement());
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzic.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */