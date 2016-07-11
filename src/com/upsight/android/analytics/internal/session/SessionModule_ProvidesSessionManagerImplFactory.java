package com.upsight.android.analytics.internal.session;

import com.upsight.android.UpsightContext;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class SessionModule_ProvidesSessionManagerImplFactory
  implements Factory<SessionManagerImpl>
{
  private final Provider<Clock> clockProvider;
  private final Provider<ConfigParser> configParserProvider;
  private final SessionModule module;
  private final Provider<UpsightContext> upsightProvider;
  
  static
  {
    if (!SessionModule_ProvidesSessionManagerImplFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public SessionModule_ProvidesSessionManagerImplFactory(SessionModule paramSessionModule, Provider<UpsightContext> paramProvider, Provider<ConfigParser> paramProvider1, Provider<Clock> paramProvider2)
  {
    assert (paramSessionModule != null);
    module = paramSessionModule;
    assert (paramProvider != null);
    upsightProvider = paramProvider;
    assert (paramProvider1 != null);
    configParserProvider = paramProvider1;
    assert (paramProvider2 != null);
    clockProvider = paramProvider2;
  }
  
  public static Factory<SessionManagerImpl> create(SessionModule paramSessionModule, Provider<UpsightContext> paramProvider, Provider<ConfigParser> paramProvider1, Provider<Clock> paramProvider2)
  {
    return new SessionModule_ProvidesSessionManagerImplFactory(paramSessionModule, paramProvider, paramProvider1, paramProvider2);
  }
  
  public SessionManagerImpl get()
  {
    SessionManagerImpl localSessionManagerImpl = module.providesSessionManagerImpl((UpsightContext)upsightProvider.get(), (ConfigParser)configParserProvider.get(), (Clock)clockProvider.get());
    if (localSessionManagerImpl == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localSessionManagerImpl;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.session.SessionModule_ProvidesSessionManagerImplFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */