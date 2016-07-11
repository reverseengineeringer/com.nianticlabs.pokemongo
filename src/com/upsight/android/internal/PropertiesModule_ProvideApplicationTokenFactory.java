package com.upsight.android.internal;

import android.content.Context;
import com.upsight.android.logger.UpsightLogger;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class PropertiesModule_ProvideApplicationTokenFactory
  implements Factory<String>
{
  private final Provider<Context> contextProvider;
  private final Provider<UpsightLogger> loggerProvider;
  private final PropertiesModule module;
  
  static
  {
    if (!PropertiesModule_ProvideApplicationTokenFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public PropertiesModule_ProvideApplicationTokenFactory(PropertiesModule paramPropertiesModule, Provider<Context> paramProvider, Provider<UpsightLogger> paramProvider1)
  {
    assert (paramPropertiesModule != null);
    module = paramPropertiesModule;
    assert (paramProvider != null);
    contextProvider = paramProvider;
    assert (paramProvider1 != null);
    loggerProvider = paramProvider1;
  }
  
  public static Factory<String> create(PropertiesModule paramPropertiesModule, Provider<Context> paramProvider, Provider<UpsightLogger> paramProvider1)
  {
    return new PropertiesModule_ProvideApplicationTokenFactory(paramPropertiesModule, paramProvider, paramProvider1);
  }
  
  public String get()
  {
    String str = module.provideApplicationToken((Context)contextProvider.get(), (UpsightLogger)loggerProvider.get());
    if (str == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return str;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.PropertiesModule_ProvideApplicationTokenFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */