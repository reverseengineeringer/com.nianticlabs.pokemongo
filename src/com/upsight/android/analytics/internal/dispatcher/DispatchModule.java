package com.upsight.android.analytics.internal.dispatcher;

import com.upsight.android.UpsightContext;
import com.upsight.android.UpsightCoreComponent;
import com.upsight.android.analytics.internal.AnalyticsContext;
import com.upsight.android.analytics.internal.dispatcher.routing.RouterBuilder;
import com.upsight.android.analytics.internal.dispatcher.schema.SchemaSelectorBuilder;
import com.upsight.android.analytics.internal.session.SessionManager;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public final class DispatchModule
{
  @Provides
  @Singleton
  public Dispatcher provideDispatcher(UpsightContext paramUpsightContext, SessionManager paramSessionManager, AnalyticsContext paramAnalyticsContext, ConfigParser paramConfigParser, RouterBuilder paramRouterBuilder, SchemaSelectorBuilder paramSchemaSelectorBuilder)
  {
    return new Dispatcher(paramAnalyticsContext, paramSessionManager, paramUpsightContext.getCoreComponent().backgroundDataStore(), paramConfigParser, paramRouterBuilder, paramSchemaSelectorBuilder, paramUpsightContext.getLogger());
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.DispatchModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */