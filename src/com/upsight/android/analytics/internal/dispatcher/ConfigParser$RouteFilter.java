package com.upsight.android.analytics.internal.dispatcher;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class ConfigParser$RouteFilter
{
  @JsonProperty("filter")
  public String filter;
  @JsonProperty("queues")
  public List<String> queues;
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.ConfigParser.RouteFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */