package com.upsight.android.analytics.internal.dispatcher;

import com.upsight.android.UpsightContext;
import com.upsight.android.analytics.internal.AnalyticsContext;
import com.upsight.android.analytics.internal.dispatcher.routing.RouterBuilder;
import com.upsight.android.analytics.internal.dispatcher.schema.SchemaSelectorBuilder;
import com.upsight.android.analytics.internal.session.SessionManager;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class DispatchModule_ProvideDispatcherFactory
  implements Factory<Dispatcher>
{
  private final Provider<ConfigParser> configParserProvider;
  private final Provider<AnalyticsContext> contextProvider;
  private final DispatchModule module;
  private final Provider<RouterBuilder> routerBuilderProvider;
  private final Provider<SchemaSelectorBuilder> schemaSelectorBuilderProvider;
  private final Provider<SessionManager> sessionManagerProvider;
  private final Provider<UpsightContext> upsightProvider;
  
  static
  {
    if (!DispatchModule_ProvideDispatcherFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public DispatchModule_ProvideDispatcherFactory(DispatchModule paramDispatchModule, Provider<UpsightContext> paramProvider, Provider<SessionManager> paramProvider1, Provider<AnalyticsContext> paramProvider2, Provider<ConfigParser> paramProvider3, Provider<RouterBuilder> paramProvider4, Provider<SchemaSelectorBuilder> paramProvider5)
  {
    assert (paramDispatchModule != null);
    module = paramDispatchModule;
    assert (paramProvider != null);
    upsightProvider = paramProvider;
    assert (paramProvider1 != null);
    sessionManagerProvider = paramProvider1;
    assert (paramProvider2 != null);
    contextProvider = paramProvider2;
    assert (paramProvider3 != null);
    configParserProvider = paramProvider3;
    assert (paramProvider4 != null);
    routerBuilderProvider = paramProvider4;
    assert (paramProvider5 != null);
    schemaSelectorBuilderProvider = paramProvider5;
  }
  
  public static Factory<Dispatcher> create(DispatchModule paramDispatchModule, Provider<UpsightContext> paramProvider, Provider<SessionManager> paramProvider1, Provider<AnalyticsContext> paramProvider2, Provider<ConfigParser> paramProvider3, Provider<RouterBuilder> paramProvider4, Provider<SchemaSelectorBuilder> paramProvider5)
  {
    return new DispatchModule_ProvideDispatcherFactory(paramDispatchModule, paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4, paramProvider5);
  }
  
  public Dispatcher get()
  {
    Dispatcher localDispatcher = module.provideDispatcher((UpsightContext)upsightProvider.get(), (SessionManager)sessionManagerProvider.get(), (AnalyticsContext)contextProvider.get(), (ConfigParser)configParserProvider.get(), (RouterBuilder)routerBuilderProvider.get(), (SchemaSelectorBuilder)schemaSelectorBuilderProvider.get());
    if (localDispatcher == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localDispatcher;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.DispatchModule_ProvideDispatcherFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */