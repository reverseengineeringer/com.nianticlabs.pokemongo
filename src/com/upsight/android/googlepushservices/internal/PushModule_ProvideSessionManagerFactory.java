package com.upsight.android.googlepushservices.internal;

import com.upsight.android.UpsightContext;
import com.upsight.android.analytics.internal.session.SessionManager;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class PushModule_ProvideSessionManagerFactory
  implements Factory<SessionManager>
{
  private final PushModule module;
  private final Provider<UpsightContext> upsightProvider;
  
  static
  {
    if (!PushModule_ProvideSessionManagerFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public PushModule_ProvideSessionManagerFactory(PushModule paramPushModule, Provider<UpsightContext> paramProvider)
  {
    assert (paramPushModule != null);
    module = paramPushModule;
    assert (paramProvider != null);
    upsightProvider = paramProvider;
  }
  
  public static Factory<SessionManager> create(PushModule paramPushModule, Provider<UpsightContext> paramProvider)
  {
    return new PushModule_ProvideSessionManagerFactory(paramPushModule, paramProvider);
  }
  
  public SessionManager get()
  {
    SessionManager localSessionManager = module.provideSessionManager((UpsightContext)upsightProvider.get());
    if (localSessionManager == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localSessionManager;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.googlepushservices.internal.PushModule_ProvideSessionManagerFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */