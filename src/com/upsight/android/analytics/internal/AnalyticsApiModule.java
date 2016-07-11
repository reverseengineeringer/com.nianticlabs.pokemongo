package com.upsight.android.analytics.internal;

import com.upsight.android.analytics.UpsightAnalyticsApi;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public final class AnalyticsApiModule
{
  @Provides
  @Singleton
  public UpsightAnalyticsApi provideUpsightAnalyticsApi(Analytics paramAnalytics)
  {
    return paramAnalytics;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.AnalyticsApiModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */