package com.google.gson.internal;

import java.lang.reflect.Method;

final class UnsafeAllocator$1
  extends UnsafeAllocator
{
  UnsafeAllocator$1(Method paramMethod, Object paramObject) {}
  
  public <T> T newInstance(Class<T> paramClass)
    throws Exception
  {
    return (T)val$allocateInstance.invoke(val$unsafe, new Object[] { paramClass });
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.UnsafeAllocator.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */