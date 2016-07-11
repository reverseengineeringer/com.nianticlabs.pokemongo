package com.squareup.otto;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class EventHandler
{
  private final int hashCode;
  private final Method method;
  private final Object target;
  private boolean valid = true;
  
  EventHandler(Object paramObject, Method paramMethod)
  {
    if (paramObject == null) {
      throw new NullPointerException("EventHandler target cannot be null.");
    }
    if (paramMethod == null) {
      throw new NullPointerException("EventHandler method cannot be null.");
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
      paramObject = (EventHandler)paramObject;
    } while ((method.equals(method)) && (target == target));
    return false;
  }
  
  public void handleEvent(Object paramObject)
    throws InvocationTargetException
  {
    if (!valid) {
      throw new IllegalStateException(toString() + " has been invalidated and can no longer handle events.");
    }
    try
    {
      method.invoke(target, new Object[] { paramObject });
      return;
    }
    catch (IllegalAccessException paramObject)
    {
      throw new AssertionError(paramObject);
    }
    catch (InvocationTargetException paramObject)
    {
      if ((((InvocationTargetException)paramObject).getCause() instanceof Error)) {
        throw ((Error)((InvocationTargetException)paramObject).getCause());
      }
      throw ((Throwable)paramObject);
    }
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
  
  public String toString()
  {
    return "[EventHandler " + method + "]";
  }
}

/* Location:
 * Qualified Name:     com.squareup.otto.EventHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */