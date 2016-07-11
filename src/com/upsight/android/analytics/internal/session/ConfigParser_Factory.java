package com.upsight.android.analytics.internal.session;

import com.fasterxml.jackson.databind.ObjectMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class ConfigParser_Factory
  implements Factory<ConfigParser>
{
  private final Provider<ObjectMapper> mapperProvider;
  
  static
  {
    if (!ConfigParser_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ConfigParser_Factory(Provider<ObjectMapper> paramProvider)
  {
    assert (paramProvider != null);
    mapperProvider = paramProvider;
  }
  
  public static Factory<ConfigParser> create(Provider<ObjectMapper> paramProvider)
  {
    return new ConfigParser_Factory(paramProvider);
  }
  
  public ConfigParser get()
  {
    return new ConfigParser((ObjectMapper)mapperProvider.get());
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.session.ConfigParser_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */