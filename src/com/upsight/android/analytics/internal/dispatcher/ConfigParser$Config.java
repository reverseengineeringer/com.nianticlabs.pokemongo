package com.upsight.android.analytics.internal.dispatcher;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class ConfigParser$Config
{
  @JsonProperty("identifier_filters")
  public List<ConfigParser.IdentifierFilter> identifierFilters;
  @JsonProperty("identifiers")
  public List<ConfigParser.Identifier> identifiers;
  @JsonProperty("queues")
  public List<ConfigParser.Queue> queues;
  @JsonProperty("route_filters")
  public List<ConfigParser.RouteFilter> routeFilters;
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.ConfigParser.Config
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */