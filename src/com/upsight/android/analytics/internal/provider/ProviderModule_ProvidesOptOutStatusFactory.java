package com.upsight.android.analytics.internal.provider;

import com.upsight.android.analytics.provider.UpsightOptOutStatus;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class ProviderModule_ProvidesOptOutStatusFactory
  implements Factory<UpsightOptOutStatus>
{
  private final ProviderModule module;
  private final Provider<OptOutStatus> optOutStatusProvider;
  
  static
  {
    if (!ProviderModule_ProvidesOptOutStatusFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ProviderModule_ProvidesOptOutStatusFactory(ProviderModule paramProviderModule, Provider<OptOutStatus> paramProvider)
  {
    assert (paramProviderModule != null);
    module = paramProviderModule;
    assert (paramProvider != null);
    optOutStatusProvider = paramProvider;
  }
  
  public static Factory<UpsightOptOutStatus> create(ProviderModule paramProviderModule, Provider<OptOutStatus> paramProvider)
  {
    return new ProviderModule_ProvidesOptOutStatusFactory(paramProviderModule, paramProvider);
  }
  
  public UpsightOptOutStatus get()
  {
    UpsightOptOutStatus localUpsightOptOutStatus = module.providesOptOutStatus((OptOutStatus)optOutStatusProvider.get());
    if (localUpsightOptOutStatus == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localUpsightOptOutStatus;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.provider.ProviderModule_ProvidesOptOutStatusFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */