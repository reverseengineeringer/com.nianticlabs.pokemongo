package com.upsight.android.internal;

import android.content.Context;
import com.upsight.android.logger.UpsightLogger;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class PropertiesModule_ProvideSdkPluginFactory
  implements Factory<String>
{
  private final Provider<Context> contextProvider;
  private final Provider<UpsightLogger> loggerProvider;
  private final PropertiesModule module;
  
  static
  {
    if (!PropertiesModule_ProvideSdkPluginFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public PropertiesModule_ProvideSdkPluginFactory(PropertiesModule paramPropertiesModule, Provider<Context> paramProvider, Provider<UpsightLogger> paramProvider1)
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
    return new PropertiesModule_ProvideSdkPluginFactory(paramPropertiesModule, paramProvider, paramProvider1);
  }
  
  public String get()
  {
    String str = module.provideSdkPlugin((Context)contextProvider.get(), (UpsightLogger)loggerProvider.get());
    if (str == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return str;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.PropertiesModule_ProvideSdkPluginFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */