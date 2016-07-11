package com.upsight.android.analytics.internal.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.upsight.android.analytics.internal.session.SessionManager;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class ConfigurationResponseParser_Factory
  implements Factory<ConfigurationResponseParser>
{
  private final Provider<ObjectMapper> mapperProvider;
  private final Provider<SessionManager> sessionManagerProvider;
  
  static
  {
    if (!ConfigurationResponseParser_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ConfigurationResponseParser_Factory(Provider<ObjectMapper> paramProvider, Provider<SessionManager> paramProvider1)
  {
    assert (paramProvider != null);
    mapperProvider = paramProvider;
    assert (paramProvider1 != null);
    sessionManagerProvider = paramProvider1;
  }
  
  public static Factory<ConfigurationResponseParser> create(Provider<ObjectMapper> paramProvider, Provider<SessionManager> paramProvider1)
  {
    return new ConfigurationResponseParser_Factory(paramProvider, paramProvider1);
  }
  
  public ConfigurationResponseParser get()
  {
    return new ConfigurationResponseParser((ObjectMapper)mapperProvider.get(), (SessionManager)sessionManagerProvider.get());
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.configuration.ConfigurationResponseParser_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */