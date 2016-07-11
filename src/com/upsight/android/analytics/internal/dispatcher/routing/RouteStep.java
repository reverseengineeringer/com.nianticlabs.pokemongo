package com.upsight.android.analytics.internal.dispatcher.routing;

import com.upsight.android.analytics.internal.dispatcher.delivery.Queue;

class RouteStep
{
  private String mFailureReason;
  private Queue mQueue;
  
  public RouteStep(Queue paramQueue)
  {
    mQueue = paramQueue;
  }
  
  public RouteStep(RouteStep paramRouteStep)
  {
    this(mQueue);
  }
  
  public String getFailureReason()
  {
    return mFailureReason;
  }
  
  public Queue getQueue()
  {
    return mQueue;
  }
  
  public void setFailureReason(String paramString)
  {
    mFailureReason = paramString;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.routing.RouteStep
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */