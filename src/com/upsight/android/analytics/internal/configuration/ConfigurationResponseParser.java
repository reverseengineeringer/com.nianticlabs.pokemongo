package com.upsight.android.analytics.internal.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.upsight.android.analytics.configuration.UpsightConfiguration;
import com.upsight.android.analytics.internal.session.Session;
import com.upsight.android.analytics.internal.session.SessionManager;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
public class ConfigurationResponseParser
{
  private ObjectMapper mMapper;
  private SessionManager mSessionManager;
  
  @Inject
  ConfigurationResponseParser(@Named("config-mapper") ObjectMapper paramObjectMapper, SessionManager paramSessionManager)
  {
    mMapper = paramObjectMapper;
    mSessionManager = paramSessionManager;
  }
  
  public Collection<UpsightConfiguration> parse(String paramString)
    throws IOException
  {
    Object localObject1 = (ConfigResponseJson)mMapper.readValue(paramString, ConfigResponseJson.class);
    paramString = new LinkedList();
    localObject1 = configs;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      paramString.add(UpsightConfiguration.create(type, mMapper.writeValueAsString(configuration), mSessionManager.getCurrentSession().getSessionNumber()));
      i += 1;
    }
    return paramString;
  }
  
  public static class ConfigJson
  {
    @JsonProperty("configuration")
    public JsonNode configuration;
    @JsonProperty("type")
    public String type;
  }
  
  public static class ConfigResponseJson
  {
    @JsonProperty("configurationList")
    public ConfigurationResponseParser.ConfigJson[] configs;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.configuration.ConfigurationResponseParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */