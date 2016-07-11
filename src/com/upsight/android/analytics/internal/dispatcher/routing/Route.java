package com.upsight.android.analytics.internal.dispatcher.routing;

import com.upsight.android.analytics.internal.dispatcher.delivery.Queue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Route
{
  private int mCurrentStepIndex = 0;
  private List<RouteStep> mSteps;
  
  public Route(Route paramRoute)
  {
    this(mSteps);
  }
  
  public Route(List<RouteStep> paramList)
  {
    mSteps = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RouteStep localRouteStep = (RouteStep)paramList.next();
      mSteps.add(new RouteStep(localRouteStep));
    }
  }
  
  public void failedOnCurrentStep(String paramString)
  {
    ((RouteStep)mSteps.get(mCurrentStepIndex)).setFailureReason(paramString);
  }
  
  public Queue getCurrentQueue()
  {
    return ((RouteStep)mSteps.get(mCurrentStepIndex)).getQueue();
  }
  
  public String[] getRoutingStack()
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = mSteps.iterator();
    RouteStep localRouteStep;
    StringBuilder localStringBuilder;
    if (localIterator.hasNext())
    {
      localRouteStep = (RouteStep)localIterator.next();
      localStringBuilder = new StringBuilder().append(localRouteStep.getQueue().getName()).append(" - ");
      if (localRouteStep.getFailureReason() != null) {
        break label117;
      }
    }
    label117:
    for (String str = "delivered";; str = localRouteStep.getFailureReason())
    {
      localLinkedList.add(str);
      if (localRouteStep.getFailureReason() != null) {
        break;
      }
      return (String[])localLinkedList.toArray(new String[localLinkedList.size()]);
    }
  }
  
  public int getStepsCount()
  {
    return mSteps.size();
  }
  
  public boolean hasMoreSteps()
  {
    return mCurrentStepIndex < mSteps.size() - 1;
  }
  
  public void moveToNextStep()
  {
    if (!hasMoreSteps()) {
      throw new IllegalStateException("There are no more steps to move on");
    }
    mCurrentStepIndex += 1;
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.analytics.internal.dispatcher.routing.Route
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */