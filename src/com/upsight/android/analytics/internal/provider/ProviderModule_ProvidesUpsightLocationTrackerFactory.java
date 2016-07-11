package com.upsight.android.analytics.internal.provider;

import com.upsight.android.analytics.provider.UpsightLocationTracker;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class ProviderModule_ProvidesUpsightLocationTrackerFactory
  implements Factory<UpsightLocationTracker>
{
  private final Provider<LocationTracker> locationTrackerProvider;
  private final ProviderModule module;
  
  static
  {
    if (!ProviderModule_ProvidesUpsightLocationTrackerFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ProviderModule_ProvidesUpsightLocationTrackerFactory(ProviderModule paramProviderModule, Provider<LocationTracker> paramProvider)
  {
    assert (paramProviderModule != null);
    module = paramProviderModule;
    assert (paramProvider != null);
    locationTrackerProvider = paramProvider;
  }
  
  public static Factory<UpsightLocationTracker> create(ProviderModule paramProviderModule, Provider<LocationTracker> paramProvider)
  {
    return new ProviderModule_ProvidesUpsightLocationTrackerFactory(paramProviderModule, paramProvider);
  }
  
  public UpsightLocationTracker get()
  {
    UpsightLocationTracker localUpsightLocationTracker = module.providesUpsightLocationTracker((LocationTracker)locationTrackerProvider.get());
    if (localUpsightLocationTracker == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localUpsightLocationTracker;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.provider.ProviderModule_ProvidesUpsightLocationTrackerFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */