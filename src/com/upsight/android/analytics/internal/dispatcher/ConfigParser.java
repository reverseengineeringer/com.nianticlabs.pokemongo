package com.upsight.android.analytics.internal.dispatcher;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.upsight.android.UpsightContext;
import com.upsight.android.analytics.internal.dispatcher.delivery.BatchSender.Config;
import com.upsight.android.analytics.internal.dispatcher.delivery.Batcher.Config;
import com.upsight.android.analytics.internal.dispatcher.delivery.QueueConfig;
import com.upsight.android.analytics.internal.dispatcher.delivery.QueueConfig.Builder;
import com.upsight.android.analytics.internal.dispatcher.routing.RoutingConfig;
import com.upsight.android.analytics.internal.dispatcher.routing.RoutingConfig.Builder;
import com.upsight.android.analytics.internal.dispatcher.schema.IdentifierConfig;
import com.upsight.android.analytics.internal.dispatcher.schema.IdentifierConfig.Builder;
import com.upsight.android.logger.UpsightLogger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
class ConfigParser
{
  private static final String LOG_TAG = "Dispatcher";
  private UpsightLogger mLogger;
  private ObjectMapper mMapper;
  
  @Inject
  public ConfigParser(UpsightContext paramUpsightContext, @Named("config-mapper") ObjectMapper paramObjectMapper)
  {
    mMapper = paramObjectMapper;
    mLogger = paramUpsightContext.getLogger();
  }
  
  private IdentifierConfig parseIdentifierConfig(Config paramConfig)
  {
    IdentifierConfig.Builder localBuilder = new IdentifierConfig.Builder();
    if (identifiers != null)
    {
      Object localObject = identifiers.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Identifier localIdentifier = (Identifier)((Iterator)localObject).next();
        localBuilder.addIdentifiers(name, new HashSet(ids));
      }
      paramConfig = identifierFilters.iterator();
      while (paramConfig.hasNext())
      {
        localObject = (IdentifierFilter)paramConfig.next();
        localBuilder.addIdentifierFilter(filter, identifiers);
      }
    }
    return localBuilder.build();
  }
  
  private QueueConfig parseQueueConfig(Queue paramQueue)
  {
    return new QueueConfig.Builder().setEndpointAddress(paramQueue.formatEndpointAddress()).setBatchSenderConfig(new BatchSender.Config(countNetworkFail, retryInterval, retryCount)).setBatcherConfig(new Batcher.Config(maxSize, maxAge)).build();
  }
  
  private RoutingConfig parseRoutingConfig(Config paramConfig)
  {
    RoutingConfig.Builder localBuilder = new RoutingConfig.Builder();
    if (queues != null)
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = queues.iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Queue)((Iterator)localObject1).next();
        localBuilder.addQueueConfig(name, parseQueueConfig((Queue)localObject2));
        localArrayList.add(name);
      }
      paramConfig = routeFilters.iterator();
      while (paramConfig.hasNext())
      {
        localObject1 = (RouteFilter)paramConfig.next();
        localObject2 = new ArrayList();
        Iterator localIterator = queues.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if ((localArrayList.contains(str)) || ("trash".equals(str))) {
            ((List)localObject2).add(str);
          } else {
            mLogger.w("Dispatcher", "Dispatcher ignored a route to a non-existent queue: " + str + " in the dispatcher configuration", new Object[0]);
          }
        }
        if (((List)localObject2).size() > 0) {
          localBuilder.addRoute(filter, (List)localObject2);
        }
      }
    }
    return localBuilder.build();
  }
  
  public Config parseConfig(String paramString)
    throws IOException
  {
    Object localObject = (Config)mMapper.readValue(paramString, Config.class);
    paramString = parseIdentifierConfig((Config)localObject);
    localObject = parseRoutingConfig((Config)localObject);
    return new Config.Builder().setRoutingConfig((RoutingConfig)localObject).setIdentifierConfig(paramString).build();
  }
  
  public static class Config
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
  
  public static class Identifier
  {
    @JsonProperty("ids")
    public List<String> ids;
    @JsonProperty("name")
    public String name;
  }
  
  public static class IdentifierFilter
  {
    @JsonProperty("filter")
    public String filter;
    @JsonProperty("identifiers")
    public String identifiers;
  }
  
  public static class Queue
  {
    @JsonProperty("count_network_fail_retries")
    public boolean countNetworkFail;
    @JsonProperty("host")
    public String host;
    @JsonProperty("max_age")
    public int maxAge;
    @JsonProperty("max_size")
    public int maxSize;
    @JsonProperty("name")
    public String name;
    @JsonProperty("protocol")
    public String protocol;
    @JsonProperty("max_retry_count")
    public int retryCount;
    @JsonProperty("retry_interval")
    public int retryInterval;
    @JsonProperty("url_fmt")
    public String urlFormat;
    
    public String formatEndpointAddress()
    {
      return urlFormat.replace("{protocol}", protocol).replace("{host}", host);
    }
  }
  
  public static class RouteFilter
  {
    @JsonProperty("filter")
    public String filter;
    @JsonProperty("queues")
    public List<String> queues;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.ConfigParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */