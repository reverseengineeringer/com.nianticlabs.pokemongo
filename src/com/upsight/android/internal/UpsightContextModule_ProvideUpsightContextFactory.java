package com.upsight.android.internal;

import android.content.Context;
import com.upsight.android.UpsightContext;
import com.upsight.android.logger.UpsightLogger;
import com.upsight.android.persistence.UpsightDataStore;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class UpsightContextModule_ProvideUpsightContextFactory
  implements Factory<UpsightContext>
{
  private final Provider<String> appTokenProvider;
  private final Provider<Context> baseContextProvider;
  private final Provider<UpsightDataStore> dataStoreProvider;
  private final Provider<UpsightLogger> loggerProvider;
  private final UpsightContextModule module;
  private final Provider<String> publicKeyProvider;
  private final Provider<String> sdkPluginProvider;
  
  static
  {
    if (!UpsightContextModule_ProvideUpsightContextFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public UpsightContextModule_ProvideUpsightContextFactory(UpsightContextModule paramUpsightContextModule, Provider<Context> paramProvider, Provider<String> paramProvider1, Provider<String> paramProvider2, Provider<String> paramProvider3, Provider<UpsightDataStore> paramProvider4, Provider<UpsightLogger> paramProvider5)
  {
    assert (paramUpsightContextModule != null);
    module = paramUpsightContextModule;
    assert (paramProvider != null);
    baseContextProvider = paramProvider;
    assert (paramProvider1 != null);
    sdkPluginProvider = paramProvider1;
    assert (paramProvider2 != null);
    appTokenProvider = paramProvider2;
    assert (paramProvider3 != null);
    publicKeyProvider = paramProvider3;
    assert (paramProvider4 != null);
    dataStoreProvider = paramProvider4;
    assert (paramProvider5 != null);
    loggerProvider = paramProvider5;
  }
  
  public static Factory<UpsightContext> create(UpsightContextModule paramUpsightContextModule, Provider<Context> paramProvider, Provider<String> paramProvider1, Provider<String> paramProvider2, Provider<String> paramProvider3, Provider<UpsightDataStore> paramProvider4, Provider<UpsightLogger> paramProvider5)
  {
    return new UpsightContextModule_ProvideUpsightContextFactory(paramUpsightContextModule, paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4, paramProvider5);
  }
  
  public UpsightContext get()
  {
    UpsightContext localUpsightContext = module.provideUpsightContext((Context)baseContextProvider.get(), (String)sdkPluginProvider.get(), (String)appTokenProvider.get(), (String)publicKeyProvider.get(), (UpsightDataStore)dataStoreProvider.get(), (UpsightLogger)loggerProvider.get());
    if (localUpsightContext == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return localUpsightContext;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.UpsightContextModule_ProvideUpsightContextFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */