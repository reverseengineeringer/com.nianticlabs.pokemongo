package com.upsight.android.analytics.internal.dispatcher.routing;

import com.upsight.android.analytics.internal.dispatcher.delivery.Queue;
import com.upsight.android.analytics.internal.dispatcher.delivery.Queue.Trash;
import com.upsight.android.analytics.internal.dispatcher.delivery.QueueBuilder;
import com.upsight.android.analytics.internal.dispatcher.delivery.QueueConfig;
import com.upsight.android.analytics.internal.dispatcher.schema.Schema;
import com.upsight.android.analytics.internal.dispatcher.util.ByFilterSelector;
import com.upsight.android.analytics.internal.dispatcher.util.Selector;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import rx.Scheduler;

public class RouterBuilder
{
  private QueueBuilder mQueueBuilder;
  private Scheduler mScheduler;
  
  RouterBuilder(Scheduler paramScheduler, QueueBuilder paramQueueBuilder)
  {
    mScheduler = paramScheduler;
    mQueueBuilder = paramQueueBuilder;
  }
  
  private Map<String, Queue> buildQueues(RoutingConfig paramRoutingConfig, Selector<Schema> paramSelector1, Selector<Schema> paramSelector2)
  {
    HashMap localHashMap = new HashMap();
    Object localObject = new Queue.Trash();
    localHashMap.put(((Queue)localObject).getName(), localObject);
    paramRoutingConfig = paramRoutingConfig.getQueueConfigs().entrySet().iterator();
    while (paramRoutingConfig.hasNext())
    {
      localObject = (Map.Entry)paramRoutingConfig.next();
      localHashMap.put(((Map.Entry)localObject).getKey(), mQueueBuilder.build((String)((Map.Entry)localObject).getKey(), (QueueConfig)((Map.Entry)localObject).getValue(), paramSelector1, paramSelector2));
    }
    return localHashMap;
  }
  
  private Map<String, Route> buildRoutes(RoutingConfig paramRoutingConfig, Map<String, Queue> paramMap)
  {
    HashMap localHashMap = new HashMap();
    paramRoutingConfig = paramRoutingConfig.getRouters().entrySet().iterator();
    while (paramRoutingConfig.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramRoutingConfig.next();
      LinkedList localLinkedList = new LinkedList();
      Iterator localIterator = ((List)localEntry.getValue()).iterator();
      while (localIterator.hasNext()) {
        localLinkedList.add(new RouteStep((Queue)paramMap.get((String)localIterator.next())));
      }
      localHashMap.put(localEntry.getKey(), new Route(localLinkedList));
    }
    return localHashMap;
  }
  
  public Router build(RoutingConfig paramRoutingConfig, Selector<Schema> paramSelector1, Selector<Schema> paramSelector2, RoutingListener paramRoutingListener)
  {
    paramSelector1 = buildQueues(paramRoutingConfig, paramSelector1, paramSelector2);
    paramRoutingConfig = buildRoutes(paramRoutingConfig, paramSelector1);
    paramRoutingConfig = new Router(mScheduler, new ByFilterSelector(paramRoutingConfig), paramRoutingListener);
    paramSelector1 = paramSelector1.values().iterator();
    while (paramSelector1.hasNext())
    {
      paramSelector2 = (Queue)paramSelector1.next();
      paramSelector2.setOnDeliveryListener(paramRoutingConfig);
      paramSelector2.setOnResponseListener(paramRoutingConfig);
    }
    return paramRoutingConfig;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.routing.RouterBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */