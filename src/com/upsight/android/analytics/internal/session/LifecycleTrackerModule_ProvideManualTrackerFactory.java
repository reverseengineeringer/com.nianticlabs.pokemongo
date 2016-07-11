package com.upsight.android.analytics.internal.session;

import com.upsight.android.analytics.UpsightLifeCycleTracker;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class LifecycleTrackerModule_ProvideManualTrackerFactory
  implements Factory<UpsightLifeCycleTracker>
{
  private final LifecycleTrackerModule module;
  private final Provider<ManualTracker> trackerProvider;
  
  static
  {
    if (!LifecycleTrackerModule_ProvideManualTrackerFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public LifecycleTrackerModule_ProvideManualTrackerFactory(LifecycleTrackerModule paramLifecycleTrackerModule, Provider<ManualTracker> paramProvider)
  {
    assert (paramLifecycleTrackerModule != null);
    module = paramLifecycleTrackerModule;
    assert (paramProvider != null);
    trackerProvider = paramProvider;
  }
  
  public static Factory<UpsightLifeCycleTracker> create(LifecycleTrackerModule paramLifecycleTrackerModule, Provider<ManualTracker> paramProvider)
  {
    return new LifecycleTrackerModule_ProvideManualTrackerFactory(paramLifecycleTrackerModule, paramProvider);
  }
  
  public UpsightLifeCycleTracker get()
  {
    UpsightLifeCycleTracker localUpsightLifeCycleTracker = module.provideManualTracker((ManualTracker)trackerProvider.get());
    if (localUpsightLifeCycleTracker == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localUpsightLifeCycleTracker;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.session.LifecycleTrackerModule_ProvideManualTrackerFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */