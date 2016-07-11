package com.squareup.otto;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class EventProducer
{
  private final int hashCode;
  private final Method method;
  final Object target;
  private boolean valid = true;
  
  EventProducer(Object paramObject, Method paramMethod)
  {
    if (paramObject == null) {
      throw new NullPointerException("EventProducer target cannot be null.");
    }
    if (paramMethod == null) {
      throw new NullPointerException("EventProducer method cannot be null.");
    }
    target = paramObject;
    method = paramMethod;
    paramMethod.setAccessible(true);
    hashCode = ((paramMethod.hashCode() + 31) * 31 + paramObject.hashCode());
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (EventProducer)paramObject;
    } while ((method.equals(method)) && (target == target));
    return false;
  }
  
  public int hashCode()
  {
    return hashCode;
  }
  
  public void invalidate()
  {
    valid = false;
  }
  
  public boolean isValid()
  {
    return valid;
  }
  
  public Object produceEvent()
    throws InvocationTargetException
  {
    if (!valid) {
      throw new IllegalStateException(toString() + " has been invalidated and can no longer produce events.");
    }
    try
    {
      Object localObject = method.invoke(target, new Object[0]);
      return localObject;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new AssertionError(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      if ((localInvocationTargetException.getCause() instanceof Error)) {
        throw ((Error)localInvocationTargetException.getCause());
      }
      throw localInvocationTargetException;
    }
  }
  
  public String toString()
  {
    return "[EventProducer " + method + "]";
  }
}

/* Location:
 * Qualified Name:     com.squareup.otto.EventProducer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */