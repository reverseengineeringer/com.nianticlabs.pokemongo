package com.upsight.android.analytics.internal;

import com.upsight.android.UpsightContext;
import com.upsight.android.UpsightCoreComponent;
import com.upsight.android.analytics.UpsightGooglePlayHelper;
import com.upsight.android.analytics.internal.session.Clock;
import com.upsight.android.internal.util.Opt;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.TimeUnit;
import javax.inject.Named;
import javax.inject.Singleton;

@Module
public final class BaseAnalyticsModule
{
  public static final String OPT_UNCAUGHT_EXCEPTION_HANDLER = "optUncaughtExceptionHandler";
  private final UpsightContext mUpsight;
  
  public BaseAnalyticsModule(UpsightContext paramUpsightContext)
  {
    mUpsight = paramUpsightContext;
  }
  
  @Provides
  @Singleton
  public Clock provideClock()
  {
    new Clock()
    {
      public long currentTimeMillis()
      {
        return System.currentTimeMillis();
      }
      
      public long currentTimeSeconds()
      {
        return TimeUnit.SECONDS.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
      }
    };
  }
  
  @Provides
  @Singleton
  public UpsightGooglePlayHelper provideGooglePlayHelper(UpsightContext paramUpsightContext)
  {
    return new GooglePlayHelper(paramUpsightContext, paramUpsightContext.getCoreComponent().objectMapper());
  }
  
  @Provides
  @Named("optUncaughtExceptionHandler")
  @Singleton
  public Opt<Thread.UncaughtExceptionHandler> provideUncaughtExceptionHandler()
  {
    return Opt.absent();
  }
  
  @Provides
  @Singleton
  public UpsightContext provideUpsightContext()
  {
    return mUpsight;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.BaseAnalyticsModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */