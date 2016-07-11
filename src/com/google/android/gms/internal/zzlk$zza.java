package com.google.android.gms.internal;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class zzlk$zza
  implements ThreadFactory
{
  private final ThreadFactory zzacE = Executors.defaultThreadFactory();
  private AtomicInteger zzacF = new AtomicInteger(0);
  
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = zzacE.newThread(paramRunnable);
    paramRunnable.setName("GAC_Executor[" + zzacF.getAndIncrement() + "]");
    return paramRunnable;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzlk.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */