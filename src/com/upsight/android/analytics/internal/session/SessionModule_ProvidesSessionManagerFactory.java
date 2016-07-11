package com.upsight.android.analytics.internal.session;

import dagger.internal.Factory;
import javax.inject.Provider;

public final class SessionModule_ProvidesSessionManagerFactory
  implements Factory<SessionManager>
{
  private final SessionModule module;
  private final Provider<SessionManagerImpl> sessionManagerProvider;
  
  static
  {
    if (!SessionModule_ProvidesSessionManagerFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public SessionModule_ProvidesSessionManagerFactory(SessionModule paramSessionModule, Provider<SessionManagerImpl> paramProvider)
  {
    assert (paramSessionModule != null);
    module = paramSessionModule;
    assert (paramProvider != null);
    sessionManagerProvider = paramProvider;
  }
  
  public static Factory<SessionManager> create(SessionModule paramSessionModule, Provider<SessionManagerImpl> paramProvider)
  {
    return new SessionModule_ProvidesSessionManagerFactory(paramSessionModule, paramProvider);
  }
  
  public SessionManager get()
  {
    SessionManager localSessionManager = module.providesSessionManager((SessionManagerImpl)sessionManagerProvider.get());
    if (localSessionManager == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localSessionManager;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.session.SessionModule_ProvidesSessionManagerFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */