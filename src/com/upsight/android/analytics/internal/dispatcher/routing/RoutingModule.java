package com.upsight.android.analytics.internal.dispatcher.routing;

import com.upsight.android.UpsightContext;
import com.upsight.android.UpsightCoreComponent;
import com.upsight.android.analytics.internal.dispatcher.delivery.QueueBuilder;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class RoutingModule
{
  @Provides
  @Singleton
  public RouterBuilder provideRouterBuilder(UpsightContext paramUpsightContext, QueueBuilder paramQueueBuilder)
  {
    return new RouterBuilder(paramUpsightContext.getCoreComponent().observeOnScheduler(), paramQueueBuilder);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.routing.RoutingModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */