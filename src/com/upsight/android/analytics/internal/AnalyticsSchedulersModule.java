package com.upsight.android.analytics.internal;

import dagger.Module;
import dagger.Provides;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Named;
import javax.inject.Singleton;
import rx.Scheduler;
import rx.schedulers.Schedulers;

@Module
public final class AnalyticsSchedulersModule
{
  private static final int MAX_SENDING_THREADS_NUM = 5;
  public static final String SCHEDULING_EXECUTOR = "dispatcher-batching";
  private static final String SENDER_THREAD_NAME = "DispatcherSenderThread-";
  public static final String SENDING_EXECUTOR = "dispatcher-threadpool";
  private static final int SENDING_THREAD_IDLE_TIME = 15;
  private static final int STD_SENDING_THREADS_NUM = 1;
  
  @Provides
  @Named("dispatcher-batching")
  @Singleton
  public Scheduler provideSchedulingExecutor()
  {
    return Schedulers.from(Executors.newSingleThreadScheduledExecutor());
  }
  
  @Provides
  @Named("dispatcher-threadpool")
  @Singleton
  public Scheduler provideSendingExecutor()
  {
    Schedulers.from(new ThreadPoolExecutor(1, 5, 15L, TimeUnit.MINUTES, new LinkedBlockingQueue(), new ThreadFactory()
    {
      private final AtomicInteger mSerial = new AtomicInteger();
      
      public Thread newThread(Runnable paramAnonymousRunnable)
      {
        return new Thread(paramAnonymousRunnable, "DispatcherSenderThread-" + mSerial.incrementAndGet());
      }
    }));
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.AnalyticsSchedulersModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */