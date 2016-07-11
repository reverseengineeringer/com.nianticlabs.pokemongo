package com.upsight.android.analytics.internal.dispatcher.routing;

import com.upsight.android.UpsightContext;
import com.upsight.android.analytics.internal.dispatcher.delivery.QueueBuilder;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class RoutingModule_ProvideRouterBuilderFactory
  implements Factory<RouterBuilder>
{
  private final RoutingModule module;
  private final Provider<QueueBuilder> queueBuilderProvider;
  private final Provider<UpsightContext> upsightProvider;
  
  static
  {
    if (!RoutingModule_ProvideRouterBuilderFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public RoutingModule_ProvideRouterBuilderFactory(RoutingModule paramRoutingModule, Provider<UpsightContext> paramProvider, Provider<QueueBuilder> paramProvider1)
  {
    assert (paramRoutingModule != null);
    module = paramRoutingModule;
    assert (paramProvider != null);
    upsightProvider = paramProvider;
    assert (paramProvider1 != null);
    queueBuilderProvider = paramProvider1;
  }
  
  public static Factory<RouterBuilder> create(RoutingModule paramRoutingModule, Provider<UpsightContext> paramProvider, Provider<QueueBuilder> paramProvider1)
  {
    return new RoutingModule_ProvideRouterBuilderFactory(paramRoutingModule, paramProvider, paramProvider1);
  }
  
  public RouterBuilder get()
  {
    RouterBuilder localRouterBuilder = module.provideRouterBuilder((UpsightContext)upsightProvider.get(), (QueueBuilder)queueBuilderProvider.get());
    if (localRouterBuilder == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localRouterBuilder;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.routing.RoutingModule_ProvideRouterBuilderFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */