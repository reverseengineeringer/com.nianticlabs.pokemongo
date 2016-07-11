package com.upsight.android.analytics.internal.dispatcher.routing;

import com.upsight.android.analytics.internal.dispatcher.delivery.QueueConfig;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoutingConfig$Builder
{
  private Map<String, QueueConfig> mQueueConfigs = new HashMap();
  private Map<String, List<String>> mRoutes = new HashMap();
  
  public Builder addQueueConfig(String paramString, QueueConfig paramQueueConfig)
  {
    if (mQueueConfigs.containsKey(paramString)) {
      throw new IllegalArgumentException("Queue with name " + paramString + " already exists");
    }
    mQueueConfigs.put(paramString, paramQueueConfig);
    return this;
  }
  
  public Builder addRoute(String paramString, List<String> paramList)
  {
    if (mRoutes.containsKey(paramString)) {
      throw new IllegalArgumentException("Filter with name " + paramString + " already exists");
    }
    mRoutes.put(paramString, paramList);
    return this;
  }
  
  public RoutingConfig build()
  {
    return new RoutingConfig(this, null);
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.routing.RoutingConfig.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */