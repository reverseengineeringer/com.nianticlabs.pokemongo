package com.upsight.android.analytics.internal;

import com.upsight.android.analytics.UpsightAnalyticsComponent;
import dagger.Component;
import javax.inject.Singleton;

@Component(modules={AnalyticsModule.class})
@Singleton
public abstract interface AnalyticsComponent
  extends UpsightAnalyticsComponent
{}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.AnalyticsComponent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */