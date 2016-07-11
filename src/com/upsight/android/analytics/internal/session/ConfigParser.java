package com.upsight.android.analytics.internal.session;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.inject.Inject;
import javax.inject.Named;

class ConfigParser
{
  private ObjectMapper mMapper;
  
  @Inject
  public ConfigParser(@Named("config-mapper") ObjectMapper paramObjectMapper)
  {
    mMapper = paramObjectMapper;
  }
  
  public SessionManagerImpl.Config parseConfig(String paramString)
    throws IOException
  {
    return new SessionManagerImpl.Config(mMapper.readValue(paramString, ConfigJson.class)).session_gap);
  }
  
  public static class ConfigJson
  {
    @JsonProperty("session_gap")
    public int session_gap;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.session.ConfigParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */