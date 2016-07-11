package com.upsight.android.analytics.internal.session;

import com.upsight.android.UpsightContext;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class ManualTracker_Factory
  implements Factory<ManualTracker>
{
  private final Provider<SessionManager> sessionManagerProvider;
  private final Provider<UpsightContext> upsightProvider;
  
  static
  {
    if (!ManualTracker_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ManualTracker_Factory(Provider<SessionManager> paramProvider, Provider<UpsightContext> paramProvider1)
  {
    assert (paramProvider != null);
    sessionManagerProvider = paramProvider;
    assert (paramProvider1 != null);
    upsightProvider = paramProvider1;
  }
  
  public static Factory<ManualTracker> create(Provider<SessionManager> paramProvider, Provider<UpsightContext> paramProvider1)
  {
    return new ManualTracker_Factory(paramProvider, paramProvider1);
  }
  
  public ManualTracker get()
  {
    return new ManualTracker((SessionManager)sessionManagerProvider.get(), (UpsightContext)upsightProvider.get());
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.session.ManualTracker_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */