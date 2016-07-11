package com.upsight.android.internal;

import android.os.Handler;
import android.os.HandlerThread;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.android.schedulers.HandlerScheduler;

@Module
public final class SchedulersModule
{
  private static final String HANDLER_THREAD_NAME = "UpsightCoreEventLoopThread";
  public static final String SCHEDULER_CALLBACK = "callback";
  public static final String SCHEDULER_EXECUTION = "execution";
  
  @Provides
  @Named("callback")
  @Singleton
  Scheduler provideObserveOnScheduler()
  {
    return AndroidSchedulers.mainThread();
  }
  
  @Provides
  @Named("execution")
  @Singleton
  Scheduler provideSubscribeOnScheduler()
  {
    HandlerThread localHandlerThread = new HandlerThread("UpsightCoreEventLoopThread");
    localHandlerThread.start();
    return HandlerScheduler.from(new Handler(localHandlerThread.getLooper()));
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.SchedulersModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */