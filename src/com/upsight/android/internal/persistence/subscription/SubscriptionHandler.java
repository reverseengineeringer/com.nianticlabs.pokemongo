package com.upsight.android.internal.persistence.subscription;

import com.upsight.android.UpsightException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class SubscriptionHandler
{
  private final DataStoreEvent.Action mAction;
  private final Method mMethod;
  private final Object mTarget;
  private final String mType;
  
  SubscriptionHandler(Object paramObject, Method paramMethod, DataStoreEvent.Action paramAction, String paramString)
  {
    mTarget = paramObject;
    mMethod = paramMethod;
    mAction = paramAction;
    mType = paramString;
  }
  
  public void handle(DataStoreEvent paramDataStoreEvent)
    throws UpsightException
  {
    try
    {
      mMethod.invoke(mTarget, new Object[] { source });
      return;
    }
    catch (IllegalAccessException paramDataStoreEvent)
    {
      throw new UpsightException(paramDataStoreEvent, "Failed to invoke subscription method %s.%s: ", new Object[] { mTarget.getClass(), mMethod.getName() });
    }
    catch (InvocationTargetException paramDataStoreEvent)
    {
      for (;;) {}
    }
  }
  
  public boolean matches(DataStoreEvent.Action paramAction, String paramString)
  {
    return (mAction.equals(paramAction)) && (mType.equals(paramString));
  }
}

/* Location:
 * Qualified Name:     com.upsight.android.internal.persistence.subscription.SubscriptionHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */