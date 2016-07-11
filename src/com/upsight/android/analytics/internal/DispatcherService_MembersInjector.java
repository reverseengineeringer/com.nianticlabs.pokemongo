package com.upsight.android.analytics.internal;

import android.app.Service;
import com.upsight.android.analytics.internal.configuration.ConfigurationManager;
import com.upsight.android.analytics.internal.dispatcher.Dispatcher;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class DispatcherService_MembersInjector
  implements MembersInjector<DispatcherService>
{
  private final Provider<ConfigurationManager> mConfigurationManagerProvider;
  private final Provider<Dispatcher> mDispatcherProvider;
  private final MembersInjector<Service> supertypeInjector;
  
  static
  {
    if (!DispatcherService_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public DispatcherService_MembersInjector(MembersInjector<Service> paramMembersInjector, Provider<ConfigurationManager> paramProvider, Provider<Dispatcher> paramProvider1)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    mConfigurationManagerProvider = paramProvider;
    assert (paramProvider1 != null);
    mDispatcherProvider = paramProvider1;
  }
  
  public static MembersInjector<DispatcherService> create(MembersInjector<Service> paramMembersInjector, Provider<ConfigurationManager> paramProvider, Provider<Dispatcher> paramProvider1)
  {
    return new DispatcherService_MembersInjector(paramMembersInjector, paramProvider, paramProvider1);
  }
  
  public void injectMembers(DispatcherService paramDispatcherService)
  {
    if (paramDispatcherService == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    supertypeInjector.injectMembers(paramDispatcherService);
    mConfigurationManager = ((ConfigurationManager)mConfigurationManagerProvider.get());
    mDispatcher = ((Dispatcher)mDispatcherProvider.get());
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.DispatcherService_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */