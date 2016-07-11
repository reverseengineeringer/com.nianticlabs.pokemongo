package com.upsight.android.analytics.internal;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class AnalyticsSchedulersModule$1
  implements ThreadFactory
{
  private final AtomicInteger mSerial = new AtomicInteger();
  
  AnalyticsSchedulersModule$1(AnalyticsSchedulersModule paramAnalyticsSchedulersModule) {}
  
  public Thread newThread(Runnable paramRunnable)
  {
    return new Thread(paramRunnable, "DispatcherSenderThread-" + mSerial.incrementAndGet());
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.AnalyticsSchedulersModule.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */