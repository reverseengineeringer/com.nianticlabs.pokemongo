package com.upsight.android.analytics.internal.configuration;

import com.upsight.android.UpsightContext;
import com.upsight.android.UpsightCoreComponent;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public final class ConfigurationModule
{
  @Provides
  @Singleton
  public ConfigurationManager provideConfigurationManager(UpsightContext paramUpsightContext, ConfigurationResponseParser paramConfigurationResponseParser, ManagerConfigParser paramManagerConfigParser)
  {
    return new ConfigurationManager(paramUpsightContext, paramUpsightContext.getDataStore(), paramConfigurationResponseParser, paramManagerConfigParser, paramUpsightContext.getCoreComponent().subscribeOnScheduler(), paramUpsightContext.getLogger());
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.configuration.ConfigurationModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */