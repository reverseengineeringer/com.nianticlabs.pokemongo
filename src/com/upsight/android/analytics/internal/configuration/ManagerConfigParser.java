package com.upsight.android.analytics.internal.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
public class ManagerConfigParser
{
  private ObjectMapper mMapper;
  
  @Inject
  ManagerConfigParser(@Named("config-mapper") ObjectMapper paramObjectMapper)
  {
    mMapper = paramObjectMapper;
  }
  
  public ConfigurationManager.Config parse(String paramString)
    throws IOException
  {
    paramString = (ConfigJson)mMapper.readValue(paramString, ConfigJson.class);
    return new ConfigurationManager.Config(TimeUnit.SECONDS.toMillis(requestInterval));
  }
  
  public static class ConfigJson
  {
    @JsonProperty("requestInterval")
    public int requestInterval;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.configuration.ManagerConfigParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */