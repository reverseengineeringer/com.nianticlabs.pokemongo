package com.upsight.android.analytics.internal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.upsight.android.UpsightContext;
import com.upsight.android.UpsightCoreComponent;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;

@Module
public final class ConfigObjectMapperModule
{
  public static final String MAPPER_CONFIG = "config-mapper";
  
  @Provides
  @Named("config-mapper")
  @Singleton
  public ObjectMapper provideConfigMapper(UpsightContext paramUpsightContext)
  {
    return paramUpsightContext.getCoreComponent().objectMapper();
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.ConfigObjectMapperModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */